/*
 * Copyright contributors to the IBM Verify Digital Credentials SDK for Android project
 */

package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
internal data class ConnectionInfoList(

    @SerialName("count")
    val count: Int,

    @SerialName("items")
    val items: List<ConnectionInfo>
)

