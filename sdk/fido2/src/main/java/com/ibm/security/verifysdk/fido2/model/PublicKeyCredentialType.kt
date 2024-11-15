/*
 *  Copyright contributors to the IBM Security Verify FIDO2 SDK for Android project
 */
package com.ibm.security.verifysdk.fido2.model

import com.ibm.security.verifysdk.fido2.model.PublicKeyCredentialType.PUBLIC_KEY
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An enumeration representing the type of a public key credential according to the WebAuthn specification.
 * Public key credential type specifies the type of credential used for authentication.
 *
 * This enumeration provides one option:
 * - [PUBLIC_KEY]: Represents a public key credential type.
 *
 * @property value The string value representing the public key credential type.
 */
@Serializable
enum class PublicKeyCredentialType(val value: String) {
    /**
     * Represents a public key credential type.
     */
    @SerialName("public-key")
    PUBLIC_KEY("public-key")
}
