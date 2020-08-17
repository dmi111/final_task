package com.epam.ebayproject.ebay.helpers;

import com.epam.ebayproject.ebay.pages.SignInPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.enabled;

@Log4j2
public class SignInPageHelper extends SignInPage {
    private SignInPage signInPage;

    public SignInPageHelper() {
        signInPage = new SignInPage();
    }

    public SignInPageHelper fillInEmailField(String email) {
        signInPage.getUserEmailField().shouldBe(enabled).clear();
        signInPage.getUserEmailField().shouldBe(enabled).sendKeys(email);
        log.info("'Email' field was filled.");
        return this;
    }

    public SignInPageHelper clickOnContinueButton() {
        signInPage.getContinueButton().shouldBe(enabled).click();
        log.info("'Continue' button was clicked.");
        return this;
    }

    public SignInPageHelper fillInPasswordField(String password) {
        signInPage.getUserPasswordField().shouldBe(enabled).clear();
        signInPage.getUserEmailField().shouldBe(enabled).sendKeys(password);
        log.info("'Password' field was filled.");
        return this;
    }

    public SignInPageHelper clickOnSignInButton() {
        signInPage.getContinueButton().shouldBe(enabled).click();
        log.info("'Sign In' button was clicked.");
        return this;
    }
}