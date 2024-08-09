/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class ToInvitation(

    @JsonNames("url")
    val url: String? = null,

    @JsonNames("accept_invitation_manually")
    val acceptInvitationManually: Boolean? = null,

    @JsonNames("direct_route")
    val directRoute: Boolean? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null

)