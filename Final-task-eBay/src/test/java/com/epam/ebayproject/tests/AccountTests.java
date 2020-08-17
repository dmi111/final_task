package com.epam.ebayproject.tests;

import com.epam.ebayproject.config.GlobalConfig;
import com.epam.ebayproject.ebay.components.UserDataProvider;
import com.epam.ebayproject.ebay.helpers.HomePageHelper;
import com.epam.ebayproject.ebay.helpers.RegistrationPageHelper;
import com.epam.ebayproject.ebay.helpers.SignInPageHelper;
import com.epam.ebayproject.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTests extends BaseTest {
    @DataProvider
    public static Object[][] userData() {
        return new Object[][] {
                {UserDataProvider.firstName, UserDataProvider.lastName, UserDataProvider.email, StringUtils.EMPTY},
                {StringUtils.EMPTY, UserDataProvider.lastName, UserDataProvider.email, UserDataProvider.password},
                {UserDataProvider.firstName, StringUtils.EMPTY, UserDataProvider.email, UserDataProvider.password},
                {UserDataProvider.firstName, UserDataProvider.lastName, StringUtils.EMPTY, UserDataProvider.password}
        };
    }

    @Test(dataProvider = "userData")
    public void checkThatRegistrationButtonIsDisabledIfOneOfFieldsIsEmpty (String name, String lastName,
                                                                           String email, String password) {
        RegistrationPageHelper registrationPageHelper = new RegistrationPageHelper();
        registrationPageHelper.clickOnRegistrationInLink();
        registrationPageHelper.fillInFirstNameField(name)
                .fillInLastNameField(lastName)
                .fillInEmailField(email)
                .fillInPasswordField(password);

        assertThat(registrationPageHelper.isCreateAccountButtonDisabled())
                .as("'Create Account' button is active.")
                .isTrue();
    }

    @Test
    public void checkAbilityToSignIn() throws IOException {
        HomePageHelper homePageHelper = new HomePageHelper();
        homePageHelper.clickOnSignInLink();
        SignInPageHelper signInPageHelper = new SignInPageHelper();
        signInPageHelper.fillInEmailField(GlobalConfig.getGlobalConfig().getUserEmail())
                .clickOnContinueButton()
                .fillInPasswordField(GlobalConfig.getGlobalConfig().getUserPassword())
                .clickOnSignInButton();

        assertThat(homePageHelper.isUserAuthorized(GlobalConfig.getGlobalConfig().getUserName()))
                .as("The user is not logged in.")
                .isTrue();
    }
}
