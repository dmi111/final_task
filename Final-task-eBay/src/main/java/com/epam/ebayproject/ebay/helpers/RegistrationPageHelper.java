package com.epam.ebayproject.ebay.helpers;

import com.epam.ebayproject.ebay.BaseHelper;
import com.epam.ebayproject.ebay.pages.RegistrationPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;

@Log4j2
public class RegistrationPageHelper extends BaseHelper<RegistrationPage> {
    public RegistrationPageHelper() {
        super(new RegistrationPage());
    }

    public RegistrationPageHelper fillInFirstNameField(String firstName) {
        getPage().getFirstNameField().shouldBe(visible).clear();
        getPage().getFirstNameField().sendKeys(firstName);
        log.info("'First Name' field has been filled");
        return this;
    }

    public RegistrationPageHelper fillInLastNameField(String lastName) {
        getPage().getLastNameField().shouldBe(visible).clear();
        getPage().getLastNameField().sendKeys(lastName);
        log.info("'Last Name' field has been filled");
        return this;
    }

    public RegistrationPageHelper fillInEmailField(String email) {
        getPage().getEmailField().shouldBe(visible).clear();
        getPage().getEmailField().sendKeys(email);
        log.info("'Email' field has been filled");
        return this;
    }

    public RegistrationPageHelper fillInPasswordField(String password) {
        getPage().getPasswordField().shouldBe(visible).clear();
        getPage().getPasswordField().sendKeys(password);
        log.info("'Password' field has been filled");
        return this;
    }

    public boolean isCreateAccountButtonDisabled() {
        return getPage().getCreateAccountButton().shouldBe(exist).is(disabled);
    }
}
