import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    application
    id("io.qameta.allure") version "2.8.0"
}

group = "me.service"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")

    implementation("com.codeborne:selenide:6.4.0")
    implementation("io.qameta.allure:allure-junit5:2.17.3")
    implementation("io.qameta.allure:allure-selenide:2.17.3")
    implementation("org.assertj:assertj-core:3.22.0")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.aspectj:aspectjweaver:1.9.9.1")
    implementation("io.rest-assured:rest-assured:4.4.0")
}

tasks.test {
    useJUnitPlatform()

    testLogging.showStandardStreams = true
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

allure {
    version = "2.8.0"
    aspectjweaver = true
    autoconfigure = true
}
