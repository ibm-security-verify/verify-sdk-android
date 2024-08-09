/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesMessage (

    @JsonNames("@type")
    val atType: String,

    @JsonNames("@id")
    val atId: String,

    @JsonNames("~thread")
    val tildeThread: AriesThread? = null,

    @JsonNames("~timing")
    val tildeTiming: AriesTiming? = null,

    @JsonNames("~transport")
    val tildeTransport: AriesTransport? = null,

    @JsonNames("~service")
    val tildeService: AriesService? = null,

    @JsonNames("context")
    val context: AriesMessageContext? = null,

    @JsonNames("~signature")
    val tildeSignature: AriesMessageSignature? = null
)

