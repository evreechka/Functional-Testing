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
import static java.lang.Thread.sleep;

public class AuthPageTest {
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
    public void signUpTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        AuthPage.getSignUpButton(shadow).click();
        AuthPage.getEmailInput(shadow).sendKeys(TestUtils.generateEmail());
        AuthPage.getScreenNameInput(shadow).sendKeys(TestUtils.generateUsername());
        AuthPage.getPasswordInput(shadow).sendKeys(TestUtils.generatePassword());
        AuthPage.getSignUpSubmitButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void logInTest(WebDriver webDriver) {
        final String EMAIL = propertiesConfiguration.getString("email");
        final String PASSWORD = propertiesConfiguration.getString("password");
        Shadow shadow = new Shadow(webDriver);

        AuthPage.getLogInButton(shadow).click();
        AuthPage.getEmailInput(shadow).sendKeys(EMAIL);
        AuthPage.getPasswordInput(shadow).sendKeys(PASSWORD);
        AuthPage.getLogInSubmitButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void logOutTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);
        sleep(5000);

        MainPage.getUserIconButton(shadow).click();
        AuthPage.getLogOutButton(shadow).click();

        webDriver.quit();
    }
}
