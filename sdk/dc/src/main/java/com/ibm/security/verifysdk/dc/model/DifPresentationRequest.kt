/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class DifPresentationRequest (

    @JsonNames("presentation_definition")
//    val presentationDefinition: PresentationDefinitionV1,
    val presentationDefinition: String,

    @JsonNames("options")
//    val options: DifPresentationOptions? = null
    val options: String
)
