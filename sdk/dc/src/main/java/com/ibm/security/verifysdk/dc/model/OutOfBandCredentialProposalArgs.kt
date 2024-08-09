/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class OutOfBandCredentialProposalArgs (

    @JsonNames("attributes")
    val attributes: Map<String, String>,

    @JsonNames("comment")
    val comment: String? = null,

    @JsonNames("credential_proposal")
    val credentialProposal: AriesCredentialPreview? = null,

    @JsonNames("cred_def_id")
    val credDefId: String? = null,

    @JsonNames("schema_id")
    val schemaId: String? = null,

    @JsonNames("schema_name")
    val schemaName: String? = null,

    @JsonNames("schema_version")
    val schemaVersion: String? = null
)