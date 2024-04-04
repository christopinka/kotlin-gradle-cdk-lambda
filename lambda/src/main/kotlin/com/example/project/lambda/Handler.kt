package com.example.project.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent

class Handler : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    override fun handleRequest(event: APIGatewayProxyRequestEvent?, context: Context?): APIGatewayProxyResponseEvent {
        return APIGatewayProxyResponseEvent().withHeaders(
            mapOf(
                "Content-Type" to "application/json"
                )
            ).withBody("{\"result\": \"Hello, Kotlin JVM Lambda!\"}")
            .withStatusCode(200)
    }
}
