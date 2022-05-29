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
    public void openBlogTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        MainPage.getOpenBlogPageLink(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void savePageTestWithLoginTest(WebDriver webDriver) throws InterruptedException {
        final String LINK = propertiesConfiguration.getString("link");
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);
        MainPage.getUserIconButton(shadow).click();
        MainPage.getWebArchiveTab(shadow).click();
        MainPage.getSaveAndShareButton(shadow).click();
        MainPage.getSavedURLInput(shadow).sendKeys(LINK);
        MainPage.getSaveURLSubmitButton(shadow).click();

        webDriver.quit();
    }
}
