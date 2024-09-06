package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@ExperimentalSerializationApi
@Serializable
data class CredentialList(

    @SerialName("count")
    val count: Int,

    @SerialName("items")
    val items: List<CredentialInfo>
)