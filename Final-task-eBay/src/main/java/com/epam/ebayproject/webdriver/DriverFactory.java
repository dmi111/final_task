package com.epam.ebayproject.webdriver;

import com.epam.ebayproject.config.GlobalConfig;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.InvalidArgumentException;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class DriverFactory {
    public static void configure(String baseUrl) throws IOException {
        WebDriverConfiguration configuration = new WebDriverConfiguration();
        GlobalConfig globalConfig = new GlobalConfig();

        switch (globalConfig.getBrowserType()) {
            case "remote":
                log.info("RemoteWebDriver will be used to run tests");
                configureRemoteDriver(configuration);
                break;
            case "local":
                log.info("Local WebDriver will be used to run tests");
                configureLocalDriver(configuration);
                break;
            default:
                throw new InvalidArgumentException("Incorrect browser type");
        }
        configuration
                .setStartMaximized(true)
                .setBaseUrl(baseUrl);
        open(baseUrl);
    }

    private static void configureRemoteDriver(WebDriverConfiguration configuration) throws IOException {
        String browserName = GlobalConfig.getGlobalConfig().getBrowserName();
        log.info("Configuring remote WebDriver: {}", browserName);
        configuration.setRemote(GlobalConfig.getGlobalConfig().getRemoteHubUrl())
                .initLocalDriver(browserName);
    }

    private static void configureLocalDriver(WebDriverConfiguration configuration) throws IOException {
        String browserName = GlobalConfig.getGlobalConfig().getBrowserName();
        log.info("Configuring local WebDriver: {}", browserName);
        configuration.initLocalDriver(browserName);
    }
}