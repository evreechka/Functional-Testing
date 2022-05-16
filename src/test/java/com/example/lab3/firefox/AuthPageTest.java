package com.example.lab3.firefox;

import com.codeborne.selenide.Configuration;
import com.example.lab3.utils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.sleep;

public class AuthPageTest {
    public static WebDriver firefoxDriver;
    public static Shadow shadow;
    public static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        Configuration.browserSize = "1500x1000";
        WebDriverManager.firefoxdriver().setup();

        firefoxDriver = new FirefoxDriver();
        shadow = new Shadow(firefoxDriver);
        propertiesConfiguration = new PropertiesConfiguration();

        propertiesConfiguration.load("test.properties");
    }

    @BeforeEach
    public void setUp() {
        firefoxDriver.get("https://archive.org/");
    }

    @AfterEach
    public void cleanUp() {
        firefoxDriver.quit();
    }

    @Test
    public void clickSignUpTest() {
        WebElement signUpButton = shadow.findElementByXPath("//a[@href='/account/signup' and text()='Sign up']");
        signUpButton.click();

        sleep(2000);
    }

    @Test
    public void signUpTest() {
        WebElement signUpButton = shadow.findElementByXPath("//a[@href='/account/signup' and text()='Sign up']");
        signUpButton.click();

        shadow.findElementByXPath("//input[@type='email' and @name='username']").sendKeys(TestUtils.generateEmail());
        shadow.findElementByXPath("//input[@type='text' and @name='screenname']").sendKeys(TestUtils.generateUsername());
        shadow.findElementByXPath("//input[@type='password' and @name='password']").sendKeys(TestUtils.generatePassword());
        shadow.findElementByXPath("//button[@name='submit-to-signup']").click();

        sleep(2000);
    }

    @Test
    public void clickLogInTest() {
        WebElement logInButton = shadow.findElementByXPath("//a[@href='/account/login' and text()='Log in']");
        logInButton.click();

        sleep(2000);
    }

    @Test
    public void logInTest() {
        final String EMAIL = propertiesConfiguration.getString("email");
        final String PASSWORD = propertiesConfiguration.getString("password");

        WebElement logInButton = shadow.findElementByXPath("//a[@href='/account/login' and text()='Log in']");
        logInButton.click();

        shadow.findElementByXPath("//input[@type='email' and @name='username']").sendKeys(EMAIL);
        shadow.findElementByXPath("//input[@type='password' and @name='password']").sendKeys(PASSWORD);
        shadow.findElementByXPath("//input[@type='submit' and @name='submit-to-login']").click();

        sleep(2000);
    }

    @Test
    public void logOutTest() {
        logInTest();
        sleep(1000);

        WebElement userIconButton = shadow.findElementByXPath("//button[@class='user-menu ' and @title='Expand user menu']");
        userIconButton.click();

        WebElement logOutButton = shadow.findElementByXPath("//a[text()='Log out']");
        logOutButton.click();

        sleep(2000);
    }
}
