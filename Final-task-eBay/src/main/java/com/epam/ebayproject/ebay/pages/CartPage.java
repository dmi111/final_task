package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ebayproject.ebay.BasePage;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CartPage extends BasePage {
    private SelenideElement removeProductFromCartButton = $x("//button[@data-test-id='cart-remove-item']");

    public SelenideElement getShoppingCartTitle(String numberOfProducts) {
        return $x(String.format("//h1[contains(text(), 'Shopping cart%s')]", numberOfProducts));
    }
}
