package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ebayproject.ebay.BasePage;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class SearchResultsPage extends BasePage {
    private SelenideElement firstProductNameOnSearchResultsPage = $x("(//h3[@class='s-item__title'])[1]");
}
