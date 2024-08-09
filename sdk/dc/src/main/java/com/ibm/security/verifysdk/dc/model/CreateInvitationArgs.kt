/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class CreateInvitationArgs(

    @JsonNames("goal_code")
    val goalCode: String? = null,

    @JsonNames("goal")
    val goal: String? = null,

    @JsonNames("label")
    val label: String? = null,

    @JsonNames("attach")
    val attach: OutOfBandInvitationAttachArgs? = null,

    @JsonNames("type")
    val type: InvitationType? = null,

    @JsonNames("direct_route")
    val directRoute: Boolean? = null,

    @JsonNames("manual_accept")
    val manualAccept: Boolean? = null,

    @JsonNames("max_acceptances")
    val maxAcceptances: Double? = null,

    @JsonNames("max_connections")
    val maxConnections: Double? = null,

    @JsonNames("max_queue_count")
    val maxQueueCount: Double? = null,

    @JsonNames("max_queue_time_ms")
    val maxQueueTimeMs: Double? = null,

    @JsonNames("invitation_lifetime_ms")
    val invitationLifetimeMs: Double? = null,

    @JsonNames("connection_lifetime_ms")
    val connectionLifetimeMs: Double? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null
)
