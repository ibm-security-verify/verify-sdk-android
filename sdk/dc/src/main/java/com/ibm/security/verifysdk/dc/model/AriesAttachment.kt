/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesAttachment(

    @JsonNames("@id")
    val atId: String,

    @JsonNames("data")
    val data: AriesAttachmentData,

    @JsonNames("mime-type")
    val mimeType: String? = null
)

