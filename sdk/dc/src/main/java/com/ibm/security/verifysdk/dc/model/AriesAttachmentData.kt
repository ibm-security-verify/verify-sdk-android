/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesAttachmentData (

    @JsonNames( "json")
    val json: AriesMessage? = null,

    @JsonNames( "base64")
    val base64: String? = null
)

