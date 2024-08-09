/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class CredFilter (

    @JsonNames("attr_name")
    val attrName: String,

    @JsonNames("attr_values")
    val attrValues: List<String>,

    @JsonNames("proof_request_referent")
    val proofRequestReferent: String? = null,

    @JsonNames("exclude")
    val exclude: Boolean? = null

)