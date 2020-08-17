package com.epam.ebayproject.ebay.helpers;

import com.epam.ebayproject.ebay.BaseHelper;
import com.epam.ebayproject.ebay.pages.SearchResultsPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;

@Log4j2
public class SearchResultsPageHelper extends BaseHelper<SearchResultsPage> {
    public SearchResultsPageHelper() {
        super(new SearchResultsPage());
    }

    public String getFirstProductName() {
        return getPage().getFirstProductNameOnSearchResultsPage().shouldBe(enabled).getText();
    }

    public SearchResultsPageHelper clickOnTheFirstProductLink() {
        getPage().getFirstProductNameOnSearchResultsPage().shouldBe(exist).scrollTo().click();
        log.info("The first product in the product list was selected.");
        return this;
    }
}
