/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesMessageSignature (

    @JsonNames("@type")
    val atType: String,

    @JsonNames("signer")
    val signer: String,

    @JsonNames("sig_data")
    val sigData: String,

    @JsonNames("signature")
    val signature: String

)
