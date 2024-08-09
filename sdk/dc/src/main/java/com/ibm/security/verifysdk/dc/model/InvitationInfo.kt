/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class InvitationInfo(

    @JsonNames("id")
    val id: String,

    @JsonNames("url")
    val url: String,

    @JsonNames("short_url")
    val shortUrl: String,

    @JsonNames("direct_route")
    val directRoute: Boolean,

    @JsonNames("manual_accept")
    val manualAccept: Boolean,

    @JsonNames("max_acceptances")
    val maxAcceptances: Double,

    @JsonNames("cur_acceptances")
    val curAcceptances: Double,

    @JsonNames("recipient_key")
    val recipientKey: String,

    @JsonNames("max_connections")
    val maxConnections: Double? = null,

    @JsonNames("max_queue_count")
    val maxQueueCount: Double? = null,

    @JsonNames("max_queue_time_ms")
    val maxQueueTimeMs: Double? = null,

    @JsonNames("connection_lifetime_ms")
    val connectionLifetimeMs: Double? = null,

    @JsonNames("timestamps")
    val timestamps: Map<String, TimeStampsValue>? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null,

    @JsonNames("attachments")
    val attachments: List<AriesAttachment>? = null,

    @JsonNames("attach_args")
    val attachArgs: OutOfBandInvitationAttachArgs? = null
)

typealias TimeStampsValue = String

