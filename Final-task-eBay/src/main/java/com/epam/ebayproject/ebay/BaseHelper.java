package com.epam.ebayproject.ebay;

import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;

@Getter
public abstract class BaseHelper<PAGE extends BasePage> {
    private PAGE page;

    public BaseHelper(PAGE page) {
        this.page = page;
    }

    public void clickOnSignInLink() {
        getPage().getSignInLink().shouldBe(visible).click();
    }

    public void clickOnRegistrationInLink() {
        getPage().getRegistrationLink().shouldBe(visible).click();
    }

    public void goToHomePage() {
        getPage().getEbayHomeButton().shouldBe(visible).click();
    }

    public boolean isUserAuthorized(String userName) {
        return getPage().getUserNameFromHeader(userName).shouldBe(visible).isDisplayed();
    }
}
