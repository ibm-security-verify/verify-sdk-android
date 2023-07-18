/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */

package com.ibm.security.verifysdk.mfa

import java.net.URL

internal data class CloudTOTPEnrollableFactor(
    override val uri: URL,
    override val type: EnrollableType = EnrollableType.TOTP,
    val id: String,
    val algorithm: String,
    val secret: String,
    val digits: Int,
    val period: Int
) : EnrollableFactor