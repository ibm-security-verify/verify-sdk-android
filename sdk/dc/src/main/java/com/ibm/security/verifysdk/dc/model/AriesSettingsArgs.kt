/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class AriesSettingsArgs (

    @JsonNames("message_prefix")
    val messagePrefix: String? = null,

    @JsonNames("did_exchange")
    val didExchange: Boolean? = null,

    @JsonNames("issue_credential_version")
    val issueCredentialVersion: String? = null,

    @JsonNames("present_proof_version")
    val presentProofVersion: String? = null

)