package com.example.project.infrastructure

import software.amazon.awscdk.App
import software.amazon.awscdk.Duration
import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.apigateway.LambdaIntegration
import software.amazon.awscdk.services.apigateway.RestApi
import software.amazon.awscdk.services.apigateway.RestApiProps
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.FunctionProps
import software.amazon.awscdk.services.lambda.Runtime
import software.constructs.Construct
import java.nio.file.Paths

fun main() {
    println("Hello, Kotlin CDK!")

    val app = App()

    val stage: String = app.node.tryGetContext("stage").toString()
    println("Current stage: $stage")
    SampleStack(app, "my-sample-stack", StackProps.builder().build(), stage)
    app.synth()
}

fun getProjectRoot(): String {
    println("project path")
    println("${Paths.get("").toAbsolutePath().toString()}/../")
    return "${Paths.get("").toAbsolutePath().toString()}/../"
}

class SampleStack(parent: Construct, name: String, props: StackProps, stage: String): Stack(parent, name, props) {
    init {
        val function = Function(this, "Function", FunctionProps.builder()
            .functionName("function-$stage")
            .runtime(Runtime.JAVA_21)
            .code(Code.fromAsset(getProjectRoot() + "lambda/build/libs/lambda.jar"))
            .handler("com.example.project.lambda.Handler")
            .memorySize(512)
            .timeout(Duration.seconds(10))
            .build()
        )

        val restApi = RestApi(this, "Api", RestApiProps.builder().restApiName("api-$stage").build())
        val lambdaPath = restApi.root.addResource("some_path")
        lambdaPath.addMethod(
            "GET",
            LambdaIntegration(function)
        )
    }
}
