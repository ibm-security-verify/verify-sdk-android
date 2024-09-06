/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */

package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ToAgent (

   @SerialName("name")
    val name: String,

   @SerialName("id")
    val id: String,

   @SerialName("url")
    val url: String
)