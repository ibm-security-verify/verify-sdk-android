/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesSettings (

    @JsonNames("message_prefix")
    val messagePrefix: String,

    @JsonNames("did_exchange")
    val didExchange: Boolean,

    @JsonNames("issue_credential_version")
    val issueCredentialVersion: String,

    @JsonNames("present_proof_version")
    val presentProofVersion: String
)