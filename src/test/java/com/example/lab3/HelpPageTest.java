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

public class HelpPageTest {
    private static HelpPage helpPage;
    private static MainPage mainPage;
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        helpPage = new HelpPage();
        mainPage = new MainPage();
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
    public void writeEmailToHelpCenterTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenHelpPageLink(shadow).click();
        helpPage.getAccountsLink(shadow).click();
        helpPage.getBasicGuideLink(shadow).click();
        helpPage.getMailLink(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void evaluateHelpForProblemTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenHelpPageLink(shadow).click();
        helpPage.getAccountsLink(shadow).click();
        helpPage.getBasicGuideLink(shadow).click();
        helpPage.getYesButton(shadow).click();

        webDriver.quit();
    }
}
