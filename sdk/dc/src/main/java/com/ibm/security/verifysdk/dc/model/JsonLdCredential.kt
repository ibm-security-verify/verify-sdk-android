/*
 * Copyright contributors to the IBM Verify Digital Credentials SDK for Android project
 */

package com.ibm.security.verifysdk.dc.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonPrimitive
import java.time.Instant
import java.time.format.DateTimeParseException
import java.util.Base64

/**
 * Represents a JSON-LD formatted credential used in decentralized identity systems.
 *
 * This class contains details about a credential issued in JSON-LD format, including its
 * metadata, issuer information, connection details, and properties.
 *
 * @property id The unique identifier of the credential.
 * @property role The role of the credential in the exchange process (e.g., issuer or holder).
 * @property state The current state of the credential (e.g., issued, revoked).
 * @property issuerDid The Decentralized Identifier (DID) of the credential issuer.
 * @property format The format of the credential, which in this case is JSON-LD.
 * @property jsonRepresentation The raw JSON representation of the credential.
 * @property connection Information about the connection associated with the credential exchange.
 * @property properties A map containing additional metadata and attributes related to the credential.
 *
 * @sine 3.0.4
 */
@Serializable
data class JsonLdCredential(
    override val id: String,
    override val role: CredentialRole,
    override val state: CredentialState,
    @SerialName("issuer_did")
    override val issuerDid: DID,
    override val format: CredentialFormat,
    @SerialName("cred_json")
    override val jsonRepresentation: JsonElement?,
    val connection: ConnectionInfo,
    val properties: Map<String, JsonElement>
) : CredentialDescriptor {

    override fun getAgentName(): String = connection.remote.name
    override fun getAgentUrl(): String = connection.remote.url
    override fun getFriendlyName(): String = properties["name"]?.jsonPrimitive.toString()

    val offerTime: Instant
        get() {
            val time = properties["time"]?.jsonPrimitive?.toString()
            return if (time != null) {
                try {
                    Instant.parse(time)
                } catch (e: DateTimeParseException) {
                    Instant.now()
                }
            } else {
                Instant.now()
            }
        }

    val icon: Bitmap?
        get() {
            val icon = properties["icon"]
            val value = icon?.jsonPrimitive?.toString()
            if (!value.isNullOrEmpty()) {
                val components = value.split("base64,")
                if (components.size == 2) {
                    val data = Base64.getDecoder().decode(components[1])
                    return BitmapFactory.decodeByteArray(data, 0, data.size)
                }
            }
            return null
        }
}