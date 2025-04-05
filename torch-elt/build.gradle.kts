import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    alias(libs.plugins.shadow)
}

dependencies {
    implementation(libs.lambda.core)
    implementation(libs.lambda.events)

    implementation(platform(libs.awssdk.bom))
//    implementation(libs.awssdk.s3) // if you need to use SDK libraries

    testImplementation(libs.junit.get5())
    testImplementation(libs.junit.get5().api)
}

repositories {
    mavenCentral()
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName = "torch-elt"
        archiveClassifier = ""
        archiveVersion = ""
    }

    test {
        useJUnitPlatform()
    }
}
