package com.tst.api

import io.qameta.allure.Step
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiTest {

    @ParameterizedTest
    @MethodSource("parameters")
    fun test(id: String, statusCode: Int) {
        val url = "https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/$id"
        sendGetRequest(statusCode, url)
    }

    @Step("Get request")
    fun sendGetRequest(statusCode: Int, url: String): ValidatableResponse {
        return given()
            .get(url)
            .then()
            .statusCode(statusCode)
    }

    private fun parameters(): Stream<Arguments> {
        return Stream.of(
            Arguments.arguments("20007", 204),
            Arguments.arguments("abcd", 404),
            Arguments.arguments("5456", 204)
        )
    }
}
