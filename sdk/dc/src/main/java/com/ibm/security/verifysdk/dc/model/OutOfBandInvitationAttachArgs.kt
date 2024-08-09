/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
package com.ibm.security.verifysdk.dc.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class OutOfBandInvitationAttachArgs (

    @JsonNames("recipient")
    val recipient: InvitationRole,

    @JsonNames("use_connection")
    val useConnection: Boolean,

    @JsonNames("verification_request")
    val verificationRequest: CreateVerificationRequestArgs? = null,

    @JsonNames("verification_proposal")
    val verificationProposal: CreateVerificationProposalArgs? = null,

    @JsonNames("cred_offer")
    val credOffer: OutOfBandCredentialOfferArgs? = null,

    @JsonNames("cred_proposal")
    val credProposal: OutOfBandCredentialProposalArgs? = null,

    @JsonNames("interaction")
    val interaction: CreateInteractionRequest? = null
)