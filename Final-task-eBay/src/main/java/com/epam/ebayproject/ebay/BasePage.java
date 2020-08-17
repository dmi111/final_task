package com.epam.ebayproject.ebay;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public abstract class BasePage {
    private SelenideElement ebayHomeButton = $x("//a[@href='https://www.ebay.com/']");
    private SelenideElement registrationLink = $x("//a[contains(text(),'register')]");
    private SelenideElement signInLink = $x("(//a[contains(text(),'Sign in')])[1]");

    public SelenideElement getUserNameFromHeader(String username) {
        return $x(String.format("//b[contains(text(),'%s')]", username));
    }
}
