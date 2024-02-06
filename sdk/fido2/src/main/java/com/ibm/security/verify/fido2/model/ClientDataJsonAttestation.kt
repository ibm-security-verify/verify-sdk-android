/*
 *  Copyright contributors to the IBM Security Verify FIDO2 SDK for Android project
 */
package com.ibm.security.verify.fido2.model

import kotlinx.serialization.Serializable

@Serializable
data class ClientDataJsonAttestation(
    val type: String,
    val challenge: String,
    val origin: String,
    val crossOrigin: Boolean
)
