/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesTiming (

    @JsonNames("in_time")
    val inTime: String? = null,

    @JsonNames("out_time")
    val outTime: String? = null,

    @JsonNames("stale_time")
    val staleTime: String? = null,

    @JsonNames("expires_time")
    val expiresTime: String? = null,

    @JsonNames("delay_milli")
    val delayMilli: Double? = null,

    @JsonNames("wait_until_time")
    val waitUntilTime: String? = null
)