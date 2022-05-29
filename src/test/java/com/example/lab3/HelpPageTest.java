package com.example.lab3;

import com.example.lab3.utils.WebDriverFactory;
import io.github.sukgu.Shadow;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelpPageTest {
    private static final List<WebDriver> WEB_DRIVERS = new ArrayList<>();

    private static List<WebDriver> getWebDrivers() {
        WEB_DRIVERS.clear();
        WEB_DRIVERS.add(WebDriverFactory.CHROME.getWebDriver());
        WEB_DRIVERS.add(WebDriverFactory.FIREFOX.getWebDriver());
        return WEB_DRIVERS;
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void writeEmailToHelpCenterTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenHelpPageLink(shadow).click();
        HelpPage.getAccountsLink(shadow).click();
        HelpPage.getBasicGuideLink(shadow).click();
        HelpPage.getMailLink(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void evaluateHelpForProblemTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenHelpPageLink(shadow).click();
        HelpPage.getAccountsLink(shadow).click();
        HelpPage.getBasicGuideLink(shadow).click();
        HelpPage.getYesButton(shadow).click();

        webDriver.quit();
    }
}
