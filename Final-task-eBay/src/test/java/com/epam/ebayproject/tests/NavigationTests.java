package com.epam.ebayproject.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.ebayproject.config.GlobalConfig;
import com.epam.ebayproject.ebay.helpers.HomePageHelper;
import com.epam.ebayproject.ebay.helpers.SearchResultsPageHelper;
import com.epam.ebayproject.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.ebayproject.ebay.components.Constants.PRODUCT_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTests extends BaseTest {
    @Test
    public void checkAbilityToSearchForProductViaTheSearchBox() {
        HomePageHelper pageHelper = new HomePageHelper();
        pageHelper.fillInSearchProductField(PRODUCT_NAME)
                .clickOnSearchButton();
        SearchResultsPageHelper searchResultsPageHelper = new SearchResultsPageHelper();

        assertThat(searchResultsPageHelper.getFirstProductName())
                .as("The required product was not found.")
                .containsIgnoringCase(PRODUCT_NAME);
    }

    @Test
    public void checkAbilityToGoToHomePage() throws IOException {
        HomePageHelper homePageHelper = new HomePageHelper();
        homePageHelper.openElectronicsCategoriesList()
                .clickOnSmartWatchesCategoryInDropdownElectronicsList()
                .goToHomePage();
        homePageHelper.waitHomePageLoading();

        assertThat(WebDriverRunner.url())
                .as("Home page has not been opened.")
                .isEqualTo(GlobalConfig.getGlobalConfig().getBaseUrl());
    }

    @Test
    public void checkNavigationButtons() {
        HomePageHelper homePageHelper = new HomePageHelper();
        assertThat(homePageHelper.getNavigationButtonNamesUI())
                .as("Navigation buttons list does not match required.")
                .isEqualTo(homePageHelper.getAllExistingNavigationButtonNames());
    }
}
