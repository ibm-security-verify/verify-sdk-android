/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesService (

    @JsonNames("recipientKeys")
    val recipientKeys: List<String>,

    @JsonNames("serviceEndpoint")
    val serviceEndpoint: String,

    @JsonNames("routingKeys")
    val routingKeys: List<String>? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null
)
