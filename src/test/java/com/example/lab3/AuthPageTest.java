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
    private static AuthPage authPage;
    private static MainPage mainPage;
    private static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        authPage = new AuthPage();
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
    public void signUpTest(WebDriver webDriver) {
        Shadow shadow = new Shadow(webDriver);

        authPage.getSignUpButton(shadow).click();
        authPage.getEmailInput(shadow).sendKeys(TestUtils.generateEmail());
        authPage.getScreenNameInput(shadow).sendKeys(TestUtils.generateUsername());
        authPage.getPasswordInput(shadow).sendKeys(TestUtils.generatePassword());
        authPage.getSignUpSubmitButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void logInTest(WebDriver webDriver) {
        final String EMAIL = propertiesConfiguration.getString("email");
        final String PASSWORD = propertiesConfiguration.getString("password");
        Shadow shadow = new Shadow(webDriver);

        authPage.getLogInButton(shadow).click();
        authPage.getEmailInput(shadow).sendKeys(EMAIL);
        authPage.getPasswordInput(shadow).sendKeys(PASSWORD);
        authPage.getLogInSubmitButton(shadow).click();

        webDriver.quit();
    }

    @ParameterizedTest
    @MethodSource("getWebDrivers")
    public void logOutTest(WebDriver webDriver) throws InterruptedException {
        Shadow shadow = new Shadow(webDriver);

        login(propertiesConfiguration, shadow);
        sleep(5000);

        mainPage.getUserIconButton(shadow).click();
        authPage.getLogOutButton(shadow).click();

        webDriver.quit();
    }
}
