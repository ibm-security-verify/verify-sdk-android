/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class CreateInteractionRequest (

    @JsonNames("role")
    val role: String,

    @JsonNames("idoc_did")
    val idocDid: String,

    @JsonNames("mode")
    val mode: InteractionMode? = null,

    @JsonNames("to")
    val to: ToConnection? = null,

    @JsonNames("direct_route")
    val directRoute: Boolean? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null

)
