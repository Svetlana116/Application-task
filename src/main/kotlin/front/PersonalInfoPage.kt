package front

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.github.javafaker.Faker
import front.Selectors.withClass
import io.qameta.allure.Step

class PersonalInfoPage {

    @Step("Generation random email")
    fun randomEmail(): String {
        val randomDigit = (10000..1000000).random()
        return "$randomDigit@test.test"
    }

    @Step("Enter email")
    fun enterEmail(): PersonalInfoPage {
        val fieldEnterEmail = `$`("#cl_login")
        fieldEnterEmail.shouldBe(visible).sendKeys(randomEmail())
        return this
    }

    @Step("Click on Continue")
    fun clickOnContinue(): PersonalInfoPage {
        `$`("#c24-uli-login-btn").shouldBe(visible).click()
        return this
    }

    @Step("Click on Ich möchte als Gast fortfahren")
    fun clickOnCheckboxGuest(): PersonalInfoPage {
        `$`(byText("Ich möchte als Gast fortfahren"))
            .click()
        return this
    }

    @Step("Click on Submit")
    fun clickOnSubmit(): PersonalInfoPage {
        `$`("#c24-uli-register-btn").shouldBe(visible).click()
        return this
    }

    @Step("Click on Extend")
    fun clickOnExtend(): PersonalInfoPage{
        `$`(withClass("ButtonExtend")).shouldBe(visible).click()
        return this
    }

    @Step("Enter Salutation")
    fun enterSalutation(): PersonalInfoPage {
        `$`(byText("Frau"))
            .click()
        return this
    }

    @Step("Enter First name")
    fun enterFirstName(): PersonalInfoPage {
        `$`("#GIVEN_NAME")
            .sendKeys(Faker().name().firstName())
        return this
    }

    @Step("Enter Last name")
    fun enterLastName(): PersonalInfoPage {
        `$`("#LAST_NAME")
            .sendKeys(Faker().name().lastName())
        return this
    }

    @Step("Enter Date of birth")
    fun enterDateOfBirth(): PersonalInfoPage {
        `$`("#DATE_OF_BIRTH")
            .sendKeys("10.10.1990")
        return this
    }

    @Step("Enter German mobile number")
    fun enterGermanMobileNumber(): PersonalInfoPage {
        `$`("#PHONENUMBER_MOBILE")
            .sendKeys("015736533968")
        return this
    }

    @Step("Checking visible title of the page - ")
    fun checkVisibleTitleOtherInfo(): PersonalInfoPage {
        `$$`(withClass("__SectionTitle-"))
            .filter(text("Weitere persönliche Angaben")).first()
            .shouldBe(visible)
        return this
    }
}
