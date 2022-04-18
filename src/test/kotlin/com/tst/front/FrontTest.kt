package com.tst.front

import front.CheckingMessages
import front.MainPage
import front.PersonalInfoPage
import org.junit.jupiter.api.Test

class FrontTest: BaseTest() {

    private val mainPage = MainPage()
    private val personalInfoPage = PersonalInfoPage()
    private val checkingMessages = CheckingMessages()

    @Test
    fun test(){
        mainPage
            .checkCookie()
            .clickOnAccept()
            .clickOnContinue()

        personalInfoPage
            .enterEmail()
            .clickOnContinue()
            .clickOnCheckboxGuest()
            .clickOnSubmit()
            .clickOnExtend()

        checkingMessages
            .errorSalutation()
            .errorFirstName()
            .errorLastName()
            .errorDateOfBirth()
            .errorGermanMobuleNumber()

        personalInfoPage
            .enterSalutation()
            .enterFirstName()
            .enterLastName()
            .enterDateOfBirth()
            .enterGermanMobileNumber()
            .clickOnExtend()
            .checkVisibleTitleOtherInfo()
    }
}