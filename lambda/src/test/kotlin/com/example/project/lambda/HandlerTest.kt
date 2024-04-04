package com.example.project.lambda

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class HandlerTest {
    @Test
    fun testHandler() {
        val handler = Handler()
        val response = handler.handleRequest(null, null)
        assertEquals(200, response.statusCode)
    }
}
