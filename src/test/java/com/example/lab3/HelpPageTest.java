package com.example.lab3;

import com.example.lab3.utils.WebDriverFactory;
import io.github.sukgu.Shadow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelpPageTest {
    private static HelpPage helpPage;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUpAll() {
        helpPage = new HelpPage();
        mainPage = new MainPage();
    }

    private static List<WebDriver> getWebDrivers() {
        List<WebDriver> webDrivers = new ArrayList<>();
        webDrivers.add(WebDriverFactory.CHROME.getWebDriver());
        webDrivers.add(WebDriverFactory.FIREFOX.getWebDriver());
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
