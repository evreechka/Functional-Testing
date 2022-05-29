package com.example.lab3;

import com.example.lab3.utils.WebDriverFactory;
import io.github.sukgu.Shadow;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class VolunteerPageTest {
    private static final List<WebDriver> WEB_DRIVERS = new ArrayList<>();

    private static List<WebDriver> getWebDrivers() {
        WEB_DRIVERS.clear();
        WEB_DRIVERS.add(WebDriverFactory.CHROME.getWebDriver());
        WEB_DRIVERS.add(WebDriverFactory.FIREFOX.getWebDriver());
        return WEB_DRIVERS;
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void openGithubProjectsTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenVolunteerPageLink(shadow).click();
        VolunteerPage.getGithubProjectsRepo(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void joinSlackChannelTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenVolunteerPageLink(shadow).click();
        VolunteerPage.getGithubChannelRepo(shadow).click();
        VolunteerPage.getChannelPageLink(shadow).click();

        webDriver.quit();
    }
}
