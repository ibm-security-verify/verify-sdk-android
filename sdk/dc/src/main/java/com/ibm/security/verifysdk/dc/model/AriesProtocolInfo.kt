/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames


@ExperimentalSerializationApi
@Serializable
data class AriesProtocolInfo (

    @JsonNames("pid")
    val pid: String,

    @JsonNames("roles")
    val roles: List<String>

)