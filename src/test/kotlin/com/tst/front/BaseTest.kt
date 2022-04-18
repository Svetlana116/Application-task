package com.tst.front

import org.junit.jupiter.api.BeforeAll
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.logevents.SelenideLogger
import io.qameta.allure.selenide.AllureSelenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import utils.PropertiesStorage

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
open class BaseTest {

    companion object{
        val properties: PropertiesStorage = PropertiesStorage()
    }

    private fun open(){
        Selenide.open(properties.baseUrl)
    }

    @BeforeAll
    fun setup() {
        setupConfigurations()
        setupAllureSelenide()
        open()
    }

    private fun setupConfigurations() {
        Configuration.browser = "firefox"
        Configuration.baseUrl = "https://finanzen.check24.de/accounts/d/kreditkarte/result.html"
        Configuration.browserSize = "1920x1080"
        Configuration.holdBrowserOpen = true;
    }

    private fun setupAllureSelenide() {
        SelenideLogger.addListener(
            "AllureSelenide", AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        )
    }

    @AfterEach
    fun afterTest() {
        Selenide.closeWindow()
        Selenide.closeWebDriver()
    }



}
