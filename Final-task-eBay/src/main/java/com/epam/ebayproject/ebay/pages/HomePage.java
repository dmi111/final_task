package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.ebayproject.ebay.BasePage;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage extends BasePage {
    private SelenideElement searchField = $x("//input[@aria-label='Search for anything']");
    private SelenideElement searchButton = $x("//input[@value='Search']");
    private SelenideElement electronicsDropdownMenu = $x("//a[contains(text(),'Smart Watches')]/ancestor::li/a[contains(text(),'Electronics')]");
    private SelenideElement smartWatchesCategory = $x("//a[contains(text(),'Smart Watches')]");
    private SelenideElement homeNavigationButton = $x("//span[contains(text(),'Home')]");
    private ElementsCollection navigationBar = $$x("//ul[contains(@class,'hl-cat-nav')]/li");
}