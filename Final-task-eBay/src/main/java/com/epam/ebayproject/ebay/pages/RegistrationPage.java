package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ebayproject.ebay.BasePage;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RegistrationPage extends BasePage {
    private SelenideElement firstNameField = $x("//input[@id='firstname']");
    private SelenideElement lastNameField = $x("//input[@id='lastname']");
    private SelenideElement emailField = $x("//input[@id='email']");
    private SelenideElement passwordField = $x("//input[@id='PASSWORD']");
    private SelenideElement createAccountButton = $x("//button[@type='submit']");

}
