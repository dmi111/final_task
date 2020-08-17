package com.epam.ebayproject.ebay.components;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class UserDataProvider {
    public static String firstName = randomAlphabetic(6);
    public static String lastName = randomAlphabetic(6);
    public static String email = randomAlphabetic(6).toLowerCase() + "@gmail.com";
    public static String password  = randomAlphabetic(6) + randomNumeric(2);
}