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
    private static ContentPage contentPage;
    private static MainPage mainPage;
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        contentPage = new ContentPage();
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
    public void shareBookTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenTextsPageLink(shadow).click();
        contentPage.getCollectionTab(shadow).click();
        contentPage.getCollectionBookLink(shadow).click();
        contentPage.getArchiveBookLink(shadow).click();
        contentPage.getBookLink(shadow).click();
        contentPage.getShareButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void setFavoriteToSoftwareBookWithLoginTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);

        mainPage.getOpenSoftwarePageLink(shadow).click();
        contentPage.getCollectionTab(shadow).click();
        contentPage.getCollectionSoftwareLink(shadow).click();
        contentPage.getSoftwareProductLink(shadow).click();
        contentPage.getFavoriteButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void writePostInForumTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);

        mainPage.getOpenTextsPageLink(shadow).click();
        contentPage.getForumTab(shadow).click();
        contentPage.getNewPostButton(shadow).click();
        contentPage.getPostSubjectInput(shadow).sendKeys(TestUtils.generateString(20));
        contentPage.getPostBodyInput(shadow).sendKeys(TestUtils.generateString(500));
        contentPage.getPostSubmitButton(shadow).click();

        webDriver.quit();
    }
}
