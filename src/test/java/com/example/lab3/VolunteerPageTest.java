package com.example.lab3;

import com.example.lab3.utils.WebDriverFactory;
import io.github.sukgu.Shadow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class VolunteerPageTest {
    private static VolunteerPage volunteerPage;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUpAll() {
        mainPage = new MainPage();
        volunteerPage = new VolunteerPage();
    }

    private static List<WebDriver> getWebDrivers() {
        List<WebDriver> webDrivers = new ArrayList<>();
        webDrivers.add(WebDriverFactory.CHROME.getWebDriver());
        webDrivers.add(WebDriverFactory.FIREFOX.getWebDriver());
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
