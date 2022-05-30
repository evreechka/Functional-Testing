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

import static com.example.lab3.utils.TestUtils.login;

public class MainPageTest {
    private static MainPage mainPage;
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        mainPage = new MainPage();
        propertiesConfiguration = new PropertiesConfiguration();
        propertiesConfiguration.load("test.properties");
    }

    private static List<WebDriver> getWebDrivers() {
        List<WebDriver> webDrivers = new ArrayList<>();
        webDrivers.add(WebDriverFactory.CHROME.getWebDriver());
        webDrivers.add(WebDriverFactory.FIREFOX.getWebDriver());
        return webDrivers;
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void openBlogTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        mainPage.getOpenBlogPageLink(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void savePageTestWithLoginTest(WebDriver webDriver) throws InterruptedException {
        final String LINK = propertiesConfiguration.getString("link");
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);
        mainPage.getUserIconButton(shadow).click();
        mainPage.getWebArchiveTab(shadow).click();
        mainPage.getSaveAndShareButton(shadow).click();
        mainPage.getSavedURLInput(shadow).sendKeys(LINK);
        mainPage.getSaveURLSubmitButton(shadow).click();

        webDriver.quit();
    }
}
