/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */

package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SdJwtObject(

    @SerialName("undefined")
    val undefined: List<String>? = null
)
