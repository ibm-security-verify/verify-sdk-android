/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class CreateVerificationRequestArgs (

    @JsonNames("to")
    val to: ToConnection? = null,

    @JsonNames("comment")
    val comment: String? = null,

    @JsonNames("state")
    val state: VerificationState? = null,

    @JsonNames("proof_schema_id")
    val proofSchemaId: String? = null,

    @JsonNames("proof_request")
    val proofRequest: ProofRequestArgs? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null,

    @JsonNames("direct_route")
    val directRoute: Boolean? = null,

    @JsonNames("aries_version")
    val ariesVersion: String? = null,

    @JsonNames("allow_proof_request_override")
    val allowProofRequestOverride: Boolean? = null
)