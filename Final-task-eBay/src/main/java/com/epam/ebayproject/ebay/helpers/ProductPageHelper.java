package com.epam.ebayproject.ebay.helpers;

import com.epam.ebayproject.ebay.BaseHelper;
import com.epam.ebayproject.ebay.pages.ProductPage;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.*;

@Log4j2
public class ProductPageHelper extends BaseHelper<ProductPage> {
    public ProductPageHelper() {
        super(new ProductPage());
    }

    public ProductPageHelper clickOnAddToCartButton() {
        getPage().getAddToCartButton().shouldBe(text("Add to cart"));
        getPage().getAddToCartButton().shouldBe(enabled).click();
        log.info("Buy button was clicked");
        return this;
    }
}
