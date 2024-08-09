/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesMessageContext (

    @JsonNames("to_key")
    val toKey: String,

    @JsonNames("to_did")
    val toDid: String? = null,

    @JsonNames("from_key")
    val fromKey: String? = null,

    @JsonNames("from_did")
    val fromDid: String? = null
)
