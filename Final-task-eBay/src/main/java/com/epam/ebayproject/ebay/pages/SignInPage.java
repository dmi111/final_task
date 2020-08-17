package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class SignInPage {
    private SelenideElement userEmailField = $x("//input[@id='userid']");
    private SelenideElement continueButton = $x("//button[@id='signin-continue-btn']");
    private SelenideElement userPasswordField = $x("//input[@id='userid']");
    private SelenideElement signImButton = $x("//button[@id='//button[@id='sgnBt']']");
}
