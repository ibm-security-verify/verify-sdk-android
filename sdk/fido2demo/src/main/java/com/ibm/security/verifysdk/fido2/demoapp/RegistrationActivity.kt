package com.ibm.security.verifysdk.fido2.demoapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.ibm.security.verify.fido2.Fido2Api
import com.ibm.security.verify.fido2.model.AttestationOptions
import com.ibm.security.verify.fido2.model.AuthenticatorAttestationResponse
import com.ibm.security.verify.fido2.model.PublicKeyCredentialCreationOptions
import com.ibm.security.verifysdk.fido2.demoapp.model.IvCreds
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import kotlin.experimental.or

class RegistrationActivity : AppCompatActivity() {

    private val httpClient by lazy { NetworkHelper.getInstance }
    private val fido2Api = Fido2Api()
    private val keyName = "61683285-900f-4bed-87e0-b83b5277ba93"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registration)

        findViewById<Button>(R.id.button_initiate_registration).setOnClickListener {

            val relyingPartyUrl =
                findViewById<EditText>(R.id.edit_text_relying_party_url).text.toString()
            val nickName =
                findViewById<EditText>(R.id.edit_text_nickname).text.toString()
            val accessToken = getSharedPreferences(
                application.packageName,
                Context.MODE_PRIVATE
            ).getString("accessToken", null) ?: "KtYBbhXUl76S8R2izvXnr9uFODFv3Z"

            lifecycleScope.launch {
                getWhoAmI(accessToken)
                    .onSuccess { ivCreds ->
                        if (ivCreds.AZN_CRED_PRINCIPAL_NAME.isNotEmpty()) {

                            getSharedPreferences(
                                application.packageName,
                                Context.MODE_PRIVATE
                            )
                                .edit()
                                .putString("accessToken", accessToken)
                                .putString("nickName", nickName)
                                .putString("displayName", ivCreds.name)
                                .putString("userName", ivCreds.username)
                                .putString("email", ivCreds.email)
                                .apply()

                            fido2Api.initiateAttestation(
                                attestationOptionsUrl = "$relyingPartyUrl/attestation/options",
                                authorization = "Bearer $accessToken",
                                AttestationOptions(displayName = ivCreds.name)
                            )
                                .onSuccess { publicKeyCredentialCreationOptions ->
                                    sendAttestationOptionsResult(
                                        publicKeyCredentialCreationOptions,
                                        relyingPartyUrl,
                                        accessToken,
                                        nickName.ifEmpty { "FIDO2App - Android" }
                                    )
                                }
                                .onFailure {
                                    print("Failure: $it.message")
                                    displayError("${it.message}")
                                }
                        }
                    }
                    .onFailure {
                        print("Failure: $it.message")
                        displayError("${it.message}")
                    }
            }
        }
    }

    private suspend fun getWhoAmI(
        accessToken: String
    ): Result<IvCreds> {
        return try {
            val result = httpClient.get {
                url("https://fidointerop.securitypoc.com/ivcreds")
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Authorization, "Bearer $accessToken")
                }
            }.body<IvCreds>()
            Result.success(result)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    private fun sendAttestationOptionsResult(
        publicKeyCredentialCreationOptions: PublicKeyCredentialCreationOptions,
        rpUrl: String, accessToken: String, nickName: String
    ) {

        val promptInfoBuilder = BiometricPrompt.PromptInfo.Builder()
            .setTitle("FIDO2 Demo")
            .setSubtitle("User Verification")
            .setNegativeButtonText("Cancel")

        var flags: Byte = 0x01 // userPresence (UP)
        flags = (flags or 0x04)  // userVerification (UV)
        flags = (flags or 0x40)  // attestedCredentialData (AT)

        lifecycleScope.launch {

            val authenticatorAssertionResponse: AuthenticatorAttestationResponse =
                fido2Api.buildAuthenticatorAttestationResponse(
                    this@RegistrationActivity,
                    ContextCompat.getMainExecutor(this@RegistrationActivity),
                    promptInfoBuilder,
                    "6DC9F22D-2C0A-4461-B878-DE61E159EC61",
                    keyName,
                    flags,
                    publicKeyCredentialCreationOptions,
                    nickName
                )

            fido2Api.sendAttestation(
                attestationResultUrl = "$rpUrl/attestation/result",
                authorization = "Bearer $accessToken",
                authenticatorAssertionResponse
            )
                .onSuccess {
                    val sharedPreferences =
                        getSharedPreferences(application.packageName, Context.MODE_PRIVATE)
                    with(sharedPreferences.edit()) {
                        putString("accessToken", accessToken)
                        putString("relyingPartyUrl", rpUrl)
                        putString("nickName", nickName)
                        putString("createdAt", LocalDateTime.now().toString())
                        apply()
                    }
                    startActivity(
                        Intent(
                            this@RegistrationActivity,
                            AuthenticationActivity::class.java
                        )
                    )
                }
                .onFailure {
                    displayError("${it.message}")
                }
        }
    }

    private fun displayError(error: String) {
        runOnUiThread {
            val errorDialogBuilder = AlertDialog.Builder(
                this@RegistrationActivity
            )
            errorDialogBuilder.setTitle("Failure")
            errorDialogBuilder.setMessage(error)
            errorDialogBuilder.setCancelable(false)
            errorDialogBuilder.setPositiveButton("Ok", null)

            val errorDialog = errorDialogBuilder.create()
            errorDialog.show()

            val mPositiveButton = errorDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            mPositiveButton.setOnClickListener {
                errorDialog.cancel()
            }
        }
    }
}