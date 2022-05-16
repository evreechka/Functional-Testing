package com.example.lab3.firefox;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.codeborne.selenide.Selenide.sleep;

public class MainContentPageTest {
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
    public void evaluateHelpForProblemTest() {
        WebElement helpLink = shadow.findElementByXPath("//a[@href='/about/faqs.php' and @class='help']");
        helpLink.click();

        WebElement accountsLink = shadow.findElementByXPath("//a[@class='panel-block' and text()='Accounts']");
        accountsLink.click();

        WebElement basicGuideLink = shadow.findElement("a[href='https://help.archive.org/help/accounts-a-basic-guide/']");
        basicGuideLink.click();

        WebElement yesButton = shadow.findElement("button[class='button is-success is-rounded is-outlined vote']");
        yesButton.click();

        sleep(2000);
    }

    @Test
    public void openBlogTest() {
        WebElement blogLink = shadow.findElement("a[href='https://blog.archive.org']");
        blogLink.click();

        sleep(2000);
    }

    @Test
    public void openGithubProjectsTest() {
        WebElement volunteerLink = shadow.findElementByXPath("//a[@href='/about/volunteerpositions.php' and @class='volunteer']");
        volunteerLink.click();

        WebElement githubLink = shadow.findElement("a[href='https://github.com/internetarchive/openlibrary/blob/master/CONTRIBUTING.md']");
        githubLink.click();

        sleep(2000);
    }
}
