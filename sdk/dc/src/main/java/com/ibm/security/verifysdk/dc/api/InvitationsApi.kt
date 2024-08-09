/*
 *  Copyright contributors to the IBM Security Verify DC SDK for Android project
 */
@file:Suppress("unused")

package com.ibm.security.verifysdk.dc.api

import android.net.Uri
import com.ibm.security.verifysdk.core.extension.toResultFailure
import com.ibm.security.verifysdk.dc.model.CreateInvitationArgs
import com.ibm.security.verifysdk.dc.model.InvitationInfo
import com.ibm.security.verifysdk.dc.model.InvitationList
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import java.net.URL

@OptIn(ExperimentalSerializationApi::class)
open class InvitationsApi(private val baseUrl: URL) {

    private val decoder = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    open suspend fun create(
        httpClient: HttpClient,
        url: URL? = null,
        accessToken: String? = null,
        createInvitationArgs: CreateInvitationArgs
    ): Result<InvitationInfo> {

        return try {
            lateinit var localUrl: URL
            url?.let {
                localUrl = url
            } ?: {
                localUrl = URL("$baseUrl/diagency/v1.0/diagency/invitations")
            }

            val response = httpClient.post {
                url(localUrl)
                accessToken?.let { token ->
                    bearerAuth(token)
                }
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                setBody(createInvitationArgs)
            }

            if (response.status.isSuccess()) {
                Result.success(decoder.decodeFromString<InvitationInfo>(response.bodyAsText()))
            } else {
                Result.failure(response.toResultFailure())
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    open suspend fun delete(
        httpClient: HttpClient,
        url: URL? = null,
        accessToken: String? = null,
        id: String
    ): Result<InvitationInfo> {

        return try {
            lateinit var localUrl: URL
            url?.let {
                localUrl = url
            } ?: {
                val uriBuilder = Uri.Builder()
                uriBuilder.scheme((baseUrl.protocol))
                    .encodedAuthority(baseUrl.authority)
                    .appendEncodedPath("/diagency/v1.0/diagency/invitations/${id}")
                localUrl = URL(uriBuilder.build().toString())
            }

            val response = httpClient.delete {
                url(localUrl)
                accessToken?.let { token ->
                    bearerAuth(token)
                }
            }

            if (response.status.isSuccess()) {
                Result.success(decoder.decodeFromString<InvitationInfo>(response.bodyAsText()))
            } else {
                Result.failure(response.toResultFailure())
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    open suspend fun getAll(
        httpClient: HttpClient,
        url: URL? = null,
        accessToken: String? = null
    ): Result<InvitationList> {

        return try {
            val localUrl: String = url?.toString() ?: run {
                "$baseUrl/diagency/v1.0/diagency/invitations"
            }

            val response = httpClient.get {
                url(localUrl)
                accessToken?.let { token ->
                    bearerAuth(token)
                }
                accept(ContentType.Application.Json)
            }

            if (response.status.isSuccess()) {
                Result.success(decoder.decodeFromString<InvitationList>(response.bodyAsText()))
            } else {
                Result.failure(response.toResultFailure())
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    open suspend fun getOne(
        httpClient: HttpClient,
        url: URL? = null,
        accessToken: String? = null,
        id: String
    ): Result<InvitationInfo> {

        return try {
            lateinit var localUrl: URL
            url?.let {
                localUrl = url
            } ?: {
                localUrl = URL("$baseUrl/diagency/v1.0/diagency/invitations/${id}")
            }

            val response = httpClient.get {
                url(localUrl)
                accessToken?.let { token ->
                    bearerAuth(token)
                }
                accept(ContentType.Application.Json)
            }

            if (response.status.isSuccess()) {
                Result.success(decoder.decodeFromString<InvitationInfo>(response.bodyAsText()))
            } else {
                Result.failure(response.toResultFailure())
            }
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}
