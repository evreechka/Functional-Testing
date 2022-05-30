package com.example.lab3;

import com.example.lab3.utils.WebDriverFactory;
import io.github.sukgu.Shadow;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class VolunteerPageTest {
    private static VolunteerPage volunteerPage;
    private static MainPage mainPage;
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        mainPage = new MainPage();
        volunteerPage = new VolunteerPage();
        propertiesConfiguration = new PropertiesConfiguration();
        propertiesConfiguration.load("test.properties");
    }

    private static List<WebDriver> getWebDrivers() {
        List<WebDriver> webDrivers = new ArrayList<>();
        if (propertiesConfiguration.getBoolean("chromeEnable")) {
            webDrivers.add(WebDriverFactory.CHROME.getWebDriver());
        }
        if (propertiesConfiguration.getBoolean("firefoxEnable")) {
            webDrivers.add(WebDriverFactory.FIREFOX.getWebDriver());
        }
        return webDrivers;
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void openGithubProjectsTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenVolunteerPageLink(shadow).click();
        volunteerPage.getGithubProjectsRepo(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void joinSlackChannelTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenVolunteerPageLink(shadow).click();
        volunteerPage.getGithubChannelRepo(shadow).click();
        volunteerPage.getChannelPageLink(shadow).click();

        webDriver.quit();
    }
}
