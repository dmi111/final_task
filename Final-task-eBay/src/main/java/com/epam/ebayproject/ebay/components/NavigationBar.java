package com.epam.ebayproject.ebay.components;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum NavigationBar {
    HOME("Home", 1),
    SAVED("Saved", 2),
    ELECTRONICS("Electronics", 3),
    FASHION("Fashion", 4),
    HEALTH_AND_BEAUTY("Health & Beauty", 5),
    MOTORS("Motors", 6),
    COLLECTIBLES("Collectibles", 7),
    SPORTS("Sports", 8),
    HOME_AND_GARDEN("Home & Garden", 9),
    DEALS("Deals", 10),
    UNDER_TEN_DOLLARS("Under $10", 11),
    MORE(StringUtils.EMPTY, 12);

    private final String title;
    private final int value;

    @Override
    public String toString() {
        return title;
    }

    NavigationBar(String name, int value) {
        this.title = name;
        this.value = value;
    }
}