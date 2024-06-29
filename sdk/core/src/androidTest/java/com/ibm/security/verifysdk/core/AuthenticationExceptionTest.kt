/*
 * Copyright contributors to the IBM Security Verify SDK for Android project
 */
package com.ibm.security.verifysdk.core

import io.ktor.http.HttpStatusCode
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class AuthenticationExceptionTest {

    @Test
    fun constructor_happyPath_shouldReturnObject() {
        val e = AuthenticationException(HttpStatusCode.OK, "ErrorDescription")

        assertEquals(HttpStatusCode.OK, e.error)
        assertEquals("ErrorDescription", e.errorDescription)
        assertEquals(serializedError, e.errorDescription)
        assertEquals("error: ErrorId\nerrorDescription: ErrorDescription", e.toString())
        assertEquals("TAG $serializedError", e.toString("TAG"))
    }

    private val serializedError = """
        {"error":"${HttpStatusCode.OK}","errorDescription":"ErrorDescription"}
    """.trimIndent()
}