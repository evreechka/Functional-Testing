package com.example.lab3.chrome;

import com.codeborne.selenide.Configuration;
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

import static com.codeborne.selenide.Selenide.sleep;

public class MainContentPageTest {
    public static WebDriver chromeDriver;
    public static Shadow shadow;
    public static PropertiesConfiguration propertiesConfiguration;

    @BeforeAll
    public static void setUpAll() throws ConfigurationException {
        Configuration.browserSize = "1500x1000";
        WebDriverManager.chromedriver().setup();

        chromeDriver = new ChromeDriver();
        shadow = new Shadow(chromeDriver);

        propertiesConfiguration = new PropertiesConfiguration();
        propertiesConfiguration.load("test.properties");
    }

    @BeforeEach
    public void setUp() {
        chromeDriver.get("https://archive.org/");
    }

    @AfterEach
    public void cleanUp() {
        chromeDriver.quit();
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

    @Test
    public void shareBookTest() {
        WebElement textsLink = shadow.findElementByXPath("//a[@href = '/details/texts' and @title='Texts']");
        textsLink.click();

        WebElement collectionTab = shadow.findElementByXPath("//a[@id='tabby-collection-finder']");
        collectionTab.click();

        WebElement collectionsLink = shadow.findElementByXPath("//a[@href='/details/americana']");
        collectionsLink.click();

        WebElement archiveBooksLink = shadow.findElementByXPath("//a[@href='/details/cdl']");
        archiveBooksLink.click();

        WebElement bookLink = shadow.findElementByXPath("//a[@href='/details/wonderfulwizardo00baumiala' and @title='The wonderful wizard of Oz']");
        bookLink.click();

        WebElement shareLink = shadow.findElementByXPath("//button[@data-original-title='Share this item']");
        shareLink.click();

        sleep(2000);
    }

    @Test
    public void setFavoriteToSoftwareBookWithoutLoginTest() {

        WebElement softwareLink = shadow.findElementByXPath("//a[@href = '/details/software' and @title='Software']");
        softwareLink.click();

        WebElement collectionLink = shadow.findElementByXPath("//a[@href='/details/bussidmod']");
        collectionLink.click();

        WebElement productLink = shadow.findElementByXPath(
                "//a[@href='/details/livery-truck-gunawan-fam-8os-by-rg-design'" +
                        " and @title='Livery Truck Gunawan Fam 8os By RG DESIGN']");
        productLink.click();

        WebElement favoriteButton = shadow.findElementByXPath("//button[@type='button' and @data-original-title='Favorite']");
        favoriteButton.click();

        sleep(2000);
    }

    @Test
    public void setFavoriteToSoftwareBookWithLoginTest() {
        login();

        WebElement softwareLink = shadow.findElementByXPath("//a[@href = '/details/software' and @title='Software']");
        softwareLink.click();

        WebElement collectionLink = shadow.findElementByXPath("//a[@href='/details/bussidmod']");
        collectionLink.click();

        WebElement productLink = shadow.findElementByXPath(
                "//a[@href='/details/livery-truck-gunawan-fam-8os-by-rg-design'" +
                        " and @title='Livery Truck Gunawan Fam 8os By RG DESIGN']");
        productLink.click();

        WebElement favoriteButton = shadow.findElementByXPath("//button[@type='button' and @data-original-title='Favorite']");
        favoriteButton.click();

        sleep(2000);
    }

    @Test
    public void savePageTestWithLoginTest() {
        final String LINK = propertiesConfiguration.getString("link");

        login();

        WebElement userIconButton = shadow.findElementByXPath("//button[@class='user-menu ' and @title='Expand user menu']");
        userIconButton.click();

        WebElement webArchivesLink = shadow.findElementByXPath("//a[text()='My web archives']");
        webArchivesLink.click();

        WebElement saveAndShareLink = shadow.findElement("a[href='https://web.archive.org/save/']");
        saveAndShareLink.click();

        shadow.findElementByXPath("//input[@name='url']").sendKeys(LINK);
        shadow.findElementByXPath("//input[@type='submit' and @value='SAVE PAGE']").click();

        sleep(10000);
    }

    private void login() {
        final String EMAIL = propertiesConfiguration.getString("email");
        final String PASSWORD = propertiesConfiguration.getString("password");

        WebElement logInButton = shadow.findElementByXPath("//a[@href='/account/login' and text()='Log in']");
        logInButton.click();

        shadow.findElementByXPath("//input[@type='email' and @name='username']").sendKeys(EMAIL);
        shadow.findElementByXPath("//input[@type='password' and @name='password']").sendKeys(PASSWORD);
        shadow.findElementByXPath("//input[@type='submit' and @name='submit-to-login']").click();
        sleep(2000);
    }
}
