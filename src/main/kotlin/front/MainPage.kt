package front

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import front.Selectors.withClass
import io.qameta.allure.Step
import org.assertj.core.api.Assertions.assertThat
import org.openqa.selenium.By

class MainPage {

    private val acceptButton = `$`("[onclick*='giveConsent']")

    @Step("Click on the button Accept")
    fun clickOnAccept(): MainPage {
        acceptButton.shouldBe(visible).click()
        return this
    }

    @Step("Checking whether the cookie `ppset=kreditkarte`")
    fun checkCookie(): MainPage {
        val driver = Selenide.webdriver().driver().webDriver
        val cookiePPset = driver.manage().getCookieNamed("ppset")
        assertThat(cookiePPset.value.contains("kreditkarte")).isTrue
        return this
    }

    @Step("Click on button Continue")
    fun clickOnContinue(): MainPage {
        `$`(By.id("501240")).`$`(withClass("button"))
            .shouldBe(Condition.text("weiter"))
            .click()
        return this
    }
}
