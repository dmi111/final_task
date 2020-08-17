package com.epam.ebayproject.ebay.helpers;

import com.epam.ebayproject.ebay.BaseHelper;
import com.epam.ebayproject.ebay.pages.CartPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class CartPageHelper extends BaseHelper<CartPage> {
    public CartPageHelper() {
        super(new CartPage());
    }

    public boolean isShoppingCartTitleDisplayed(String productNumber) {
        return getPage().getShoppingCartTitle(productNumber).shouldBe(visible).isDisplayed();
    }

    public CartPageHelper removeProductFromCart() {
        getPage().getRemoveProductFromCartButton().shouldBe(visible).click();
        log.info("'Remove' product from cart button was clicked");
        return this;
    }
}