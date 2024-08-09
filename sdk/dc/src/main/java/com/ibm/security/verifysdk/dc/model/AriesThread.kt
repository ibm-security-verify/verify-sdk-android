/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesThread (

    @JsonNames("thid")
    val thid: String,

    @JsonNames("sender_order")
    val senderOrder: Double,

    @JsonNames("received_orders")
    val receivedOrders: Map<String, Double>,

    @JsonNames("pthid")
    val pthid: String? = null
)