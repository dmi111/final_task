package com.epam.ebayproject.tests;

import com.epam.ebayproject.ebay.helpers.CartPageHelper;
import com.epam.ebayproject.ebay.helpers.HomePageHelper;
import com.epam.ebayproject.ebay.helpers.ProductPageHelper;
import com.epam.ebayproject.ebay.helpers.SearchResultsPageHelper;
import com.epam.ebayproject.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import static com.epam.ebayproject.ebay.components.Constants.ONE_PRODUCT_IN_CART;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTests extends BaseTest {
    @Test
    public void checkAbilityToAddProductToCart() {
        HomePageHelper homePageHelper = new HomePageHelper();
        homePageHelper.openElectronicsCategoriesList()
                .clickOnSmartWatchesCategoryInDropdownElectronicsList();

        SearchResultsPageHelper searchResultsPageHelper = new SearchResultsPageHelper();
        searchResultsPageHelper.clickOnTheFirstProductLink();

        ProductPageHelper productPageHelper = new ProductPageHelper();
        productPageHelper.clickOnAddToCartButton();

        CartPageHelper cartPageHelper = new CartPageHelper();
        assertThat(cartPageHelper.isShoppingCartTitleDisplayed(ONE_PRODUCT_IN_CART))
                .as("Product was not added to cart.")
                .isTrue();
    }

    @Test
    public void checkAbilityToDeleteProductFromCart() {
        HomePageHelper homePageHelper = new HomePageHelper();
        homePageHelper.openElectronicsCategoriesList()
                .clickOnSmartWatchesCategoryInDropdownElectronicsList();

        SearchResultsPageHelper searchResultsPageHelper = new SearchResultsPageHelper();
        searchResultsPageHelper.clickOnTheFirstProductLink();

        ProductPageHelper productPageHelper = new ProductPageHelper();
        productPageHelper.clickOnAddToCartButton();

        CartPageHelper cartPageHelper = new CartPageHelper();
        cartPageHelper.removeProductFromCart();

        assertThat(cartPageHelper.isShoppingCartTitleDisplayed(StringUtils.EMPTY))
                .as("Item was not deleted from cart successfully.")
                .isTrue();
    }
}
