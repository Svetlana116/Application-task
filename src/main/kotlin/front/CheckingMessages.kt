package front

import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide.`$`
import io.qameta.allure.Step

class CheckingMessages {

    @Step("Message error - Bitte wählen Sie Ihre Anrede aus.")
    fun errorSalutation(): CheckingMessages {
        `$`(byText("Bitte wählen Sie Ihre Anrede aus.")).isDisplayed
        return this
    }

    @Step("Message error - Bitte geben Sie Ihren Vornamen an.")
    fun errorFirstName(): CheckingMessages {
        `$`(byText("Bitte geben Sie Ihren Vornamen an.")).isDisplayed
        return this
    }

    @Step("Message error - Bitte geben Sie Ihren Nachnamen an.")
    fun errorLastName(): CheckingMessages {
        `$`(byText("Bitte geben Sie Ihren Nachnamen an.")).isDisplayed
        return this
    }

    @Step("Message error - Bitte geben Sie Ihr Geburtsdatum an.")
    fun errorDateOfBirth(): CheckingMessages {
        `$`(byText("Bitte geben Sie Ihr Geburtsdatum an.")).isDisplayed
        return this
    }

    @Step("Message error - Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.")
    fun errorGermanMobuleNumber(): CheckingMessages {
        `$`(byText("Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.")).isDisplayed
        return this
    }
}
