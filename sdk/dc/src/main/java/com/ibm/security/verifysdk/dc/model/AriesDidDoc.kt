/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames


@ExperimentalSerializationApi
@Serializable
data class AriesDidDoc (

    @JsonNames("@context")
    val atContext: String,

    @JsonNames("id")
    val id: String,

    @JsonNames("service")
    val service: List<AriesDidDocService>,

    @JsonNames("publicKey")
    val publicKey: List<AriesDidDocPublicKey>? = null
)
