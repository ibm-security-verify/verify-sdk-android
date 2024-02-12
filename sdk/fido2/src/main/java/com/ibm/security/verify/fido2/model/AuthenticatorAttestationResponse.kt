/*
 *  Copyright contributors to the IBM Security Verify FIDO2 SDK for Android project
 */
package com.ibm.security.verify.fido2.model

import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable

/**
 * Represents the response received after an attestation operation by an authenticator.
 *
 * @property id The identifier associated with the response.
 * @property rawId The raw identifier associated with the response.
 * @property response The attestation response containing client data JSON and attestation object.
 * @property type The type of the response.
 * @property nickname The nickname associated with the authenticator. Defaults to "FIDO2App - Android".
 */
@OptIn(ExperimentalSerializationApi::class)
@Serializable
data class AuthenticatorAttestationResponse(
    val id: String,
    val rawId: String,
    val response: ResponseAttestation,
    val type: String,
    @EncodeDefault(EncodeDefault.Mode.ALWAYS) val nickname: String = "FIDO2App - Android"
)

/**
 * Represents the response data included in an attestation response.
 *
 * @property clientDataJSON The client data JSON included in the attestation response.
 * @property attestationObject The attestation object included in the attestation response.
 */
@Serializable
data class ResponseAttestation(
    val clientDataJSON: String,
    val attestationObject: String
)