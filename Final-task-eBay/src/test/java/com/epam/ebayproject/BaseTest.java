package com.epam.ebayproject;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.ebayproject.config.GlobalConfig;
import com.epam.ebayproject.webdriver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    @BeforeMethod()
    public void setUp() throws IOException {
        DriverFactory.configure(GlobalConfig.getGlobalConfig().getBaseUrl());
    }

    @AfterMethod()
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}