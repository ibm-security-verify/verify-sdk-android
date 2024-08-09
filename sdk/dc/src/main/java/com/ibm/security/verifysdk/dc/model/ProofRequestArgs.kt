/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class ProofRequestArgs (

    @JsonNames("name")
    val name: String? = null,

    @JsonNames("version")
    val version: String? = null,

    @JsonNames("requested_attributes")
    val requestedAttributes: String? = null,

    @JsonNames("requested_predicates")
    val requestedPredicates: String? = null,

    @JsonNames("allow_proof_request_override")
    val allowProofRequestOverride: Boolean? = null,

    @JsonNames("cred_filter")
    val credFilter: List<CredFilter>? = null,

    @JsonNames("properties")
    val properties: Map<String, String>? = null,

    @JsonNames("jsonld")
    val jsonld: DifPresentationRequest? = null,

    @JsonNames("bbs")
    val bbs: DifPresentationRequest? = null

)

