/*
 *  Copyright contributors to the IBM Security Verify DPoP Sample App for Android project
 */
package com.ibm.security.verifysdk.dpop.demoapp

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class DpopToken @OptIn(ExperimentalSerializationApi::class) constructor(
    @JsonNames("access_token")
    val accessToken: String,
    @JsonNames("expires_in")
    val expiresIn: Int,
    @JsonNames("grant_id")
    val grantId: String,
    val scope: String,
    @JsonNames("token_type")
    val tokenType: String
)
