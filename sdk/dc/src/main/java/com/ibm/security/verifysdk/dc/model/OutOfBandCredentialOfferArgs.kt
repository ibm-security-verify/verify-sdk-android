/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class OutOfBandCredentialOfferArgs (

    @JsonNames("attributes")
    val attributes: Map<String, String>,

    @JsonNames("cred_def_id")
    val credDefId: String? = null,

    @JsonNames("schema_name")
    val schemaName: String? = null,

    @JsonNames("schema_version")
    val schemaVersion: String? = null,

    @JsonNames("comment")
    val comment: String? = null,

    @JsonNames("credential_preview")
    val credentialPreview: AriesCredentialPreview? = null
)
