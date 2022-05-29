package com.example.lab3;

import com.example.lab3.utils.TestUtils;
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

import static com.example.lab3.utils.TestUtils.login;

public class ContentPageTest {
    private static final List<WebDriver> WEB_DRIVERS = new ArrayList<>();
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        propertiesConfiguration = new PropertiesConfiguration();
        propertiesConfiguration.load("test.properties");
    }

    private static List<WebDriver> getWebDrivers() {
        WEB_DRIVERS.clear();
        WEB_DRIVERS.add(WebDriverFactory.CHROME.getWebDriver());
        WEB_DRIVERS.add(WebDriverFactory.FIREFOX.getWebDriver());
        return WEB_DRIVERS;
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void shareBookTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenTextsPageLink(shadow).click();
        ContentPage.getCollectionTab(shadow).click();
        ContentPage.getCollectionBookLink(shadow).click();
        ContentPage.getArchiveBookLink(shadow).click();
        ContentPage.getBookLink(shadow).click();
        ContentPage.getShareButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void setFavoriteToSoftwareBookWithLoginTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);

        MainPage.getOpenSoftwarePageLink(shadow).click();
        ContentPage.getCollectionTab(shadow).click();
        ContentPage.getCollectionSoftwareLink(shadow).click();
        ContentPage.getSoftwareProductLink(shadow).click();
        ContentPage.getFavoriteButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void writePostInForumTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);

        MainPage.getOpenTextsPageLink(shadow).click();
        ContentPage.getForumTab(shadow).click();
        ContentPage.getNewPostButton(shadow).click();
        ContentPage.getPostSubjectInput(shadow).sendKeys(TestUtils.generateString(20));
        ContentPage.getPostBodyInput(shadow).sendKeys(TestUtils.generateString(500));
        ContentPage.getPostSubmitButton(shadow).click();

        webDriver.quit();
    }
}
