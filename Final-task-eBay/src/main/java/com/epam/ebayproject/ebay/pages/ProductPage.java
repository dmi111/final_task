package com.epam.ebayproject.ebay.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ebayproject.ebay.BasePage;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProductPage extends BasePage {
   private SelenideElement addToCartButton = $x("//a[@id='isCartBtn_btn']");
}
