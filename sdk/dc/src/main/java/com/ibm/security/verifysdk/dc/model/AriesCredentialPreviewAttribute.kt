/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesCredentialPreviewAttribute (

    @JsonNames("name")
    val name: String,

    @JsonNames("value")
    val `value`: String,

    @JsonNames("mime-type")
    val mimeType: String? = null
)

