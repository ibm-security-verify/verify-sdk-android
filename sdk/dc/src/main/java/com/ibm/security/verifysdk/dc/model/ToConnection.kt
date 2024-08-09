/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class ToConnection (

    @JsonNames("name")
    val name: String? = null,

    @JsonNames("id")
    val id: String? = null,

    @JsonNames("url")
    val url: String? = null,

    @JsonNames("did")
    val did: String? = null,

    @JsonNames("verkey")
    val verkey: String? = null,

    @JsonNames("invitation")
    val invitation: ToInvitation? = null
)
