package com.epam.ebayproject.ebay.helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.ebayproject.ebay.BaseHelper;
import com.epam.ebayproject.ebay.components.NavigationBar;
import com.epam.ebayproject.ebay.pages.HomePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class HomePageHelper extends BaseHelper<HomePage> {
    public HomePageHelper() {
        super(new HomePage());
    }

    public HomePageHelper fillInSearchProductField(String product) {
        getPage().getSearchField().shouldBe(enabled).clear();
        getPage().getSearchField().sendKeys(product);
        log.info("Search field has been filled");
        return this;
    }

    public HomePageHelper clickOnSearchButton() {
        getPage().getSearchButton().shouldBe(enabled).click();
        log.info("Search button was clicked");
        return this;
    }

    public HomePageHelper chooseSectionInNavigationBar(SelenideElement section) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(section.shouldBe(visible))
                .build()
                .perform();
        return this;
    }

    public HomePageHelper openElectronicsCategoriesList() {
        chooseSectionInNavigationBar(getPage().getElectronicsDropdownMenu());
        return this;
    }

    public List<String> getNavigationButtonNamesUI() {
        return getPage().getNavigationBar().texts();
    }

    public List<String> getAllExistingNavigationButtonNames() {
        return Stream.of(NavigationBar.values())
                .map(Enum::toString)
                .collect(Collectors.toList());
    }

    public HomePageHelper clickOnSmartWatchesCategoryInDropdownElectronicsList() {
        getPage().getSmartWatchesCategory().shouldBe(visible).click();
        log.info("The 'Smart Watch' category was selected");
        return this;
    }

    public HomePageHelper waitHomePageLoading() {
        getPage().getHomeNavigationButton().shouldBe(visible);
        return this;
    }
}