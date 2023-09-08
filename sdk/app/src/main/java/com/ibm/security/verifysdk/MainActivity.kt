/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */

package com.ibm.security.verifysdk

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.verify.domain.DomainVerificationManager
import android.content.pm.verify.domain.DomainVerificationUserState
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.ibm.security.verifysdk.authentication.CodeChallengeMethod
import com.ibm.security.verifysdk.authentication.OAuthProvider
import com.ibm.security.verifysdk.authentication.PKCEHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.event.Level
import java.net.URL
import java.util.logging.LogManager

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private val clientId = "c5cf302c-ffe8-49b2-a7ef-2c14a133acd6"
    private val host = "chageman.dev.verify.ibmcloudsecurity.com"
    private val issuer = "https://$host/v1.0/endpoint/default/authorize"
    private val redirect = "https://$host/callback"
    private val tokenEndpoint = "https://$host/v1.0/endpoint/default/token"
    private val oAuthProvider = OAuthProvider(clientId = clientId)
    private val codeVerifier = PKCEHelper.generateCodeVerifier()
    private val codeChallenge = PKCEHelper.generateCodeChallenge(codeVerifier)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val log: Logger = LoggerFactory.getLogger(MainActivity::class.java)

        log.debug("XXX DEBUG")
        log.error("XXX ERROR")
        log.warn("XXX WARN")
        log.info("XXX INFO")
        log.trace("XXX TRACE")

        findViewById<Button>(R.id.btn_authenticate).setOnClickListener {

            coroutineScope.async {
                oAuthProvider.authorizeWithBrowser(
                    URL(issuer),
                    redirect,
                    codeChallenge,
                    CodeChallengeMethod.S256,
                    activity = this@MainActivity
                ).onSuccess { code ->
                    log.info("--> Authorization code: $code")
                    oAuthProvider.authorize(URL(tokenEndpoint), redirect, code, codeVerifier)
                        .onSuccess { token ->
                            log.info("--> Token: $token")
                        }
                }
            }
        }
    }
}
