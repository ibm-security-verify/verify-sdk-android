/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesDidDocPublicKey (

    @JsonNames("id")
    val id: String,

    @JsonNames("type")
    val type: String,

    @JsonNames("controller")
    val controller: String,

    @JsonNames("publicKeyBase58")
    val publicKeyBase58: String
)

