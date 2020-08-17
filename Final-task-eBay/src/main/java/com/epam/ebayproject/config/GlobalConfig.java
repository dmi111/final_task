package com.epam.ebayproject.config;

import lombok.Getter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Getter
public class GlobalConfig {
    private static final String PROPERTIES_PATH = "src/main/resources/configuration.properties";
    private Properties properties;
    private File propertyFile;
    private String browserType;
    private String browserName;
    private String baseUrl;
    private String remoteHubUrl;
    private String userName;
    private String userEmail;
    private String userPassword;


    public GlobalConfig() throws IOException {
        propertyFile = new File(PROPERTIES_PATH);
        properties = new Properties();
        properties.load(new FileReader(propertyFile));
        browserType = properties.getProperty("browser.type");
        browserName = properties.getProperty("browser.name");
        baseUrl = properties.getProperty("base.url");
        remoteHubUrl = properties.getProperty("remote.hub.url");
        userName = properties.getProperty("user.name");
        userEmail = properties.getProperty("user.email");
        userPassword = properties.getProperty("user.password");
    }

    public static GlobalConfig getGlobalConfig() throws IOException {
        return new GlobalConfig();
    }
}
