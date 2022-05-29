package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class MainPage {
    public static WebElement getUserIconButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@title='Expand user menu']");
    }

    public static WebElement getOpenHelpPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/about/faqs.php' and @class='help']");
    }

    public static WebElement getOpenBlogPageLink(Shadow shadow) {
        return shadow.findElement("a[href='https://blog.archive.org']");
    }

    public static WebElement getOpenVolunteerPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/about/volunteerpositions.php' and @class='volunteer']");
    }

    public static WebElement getOpenTextsPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href = '/details/texts' and @title='Texts']");
    }

    public static WebElement getOpenSoftwarePageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href = '/details/software' and @title='Software']");
    }

    public static WebElement getWebArchiveTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='My web archives']");
    }

    public static WebElement getSaveAndShareButton(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='__new_item__']");
    }

    public static WebElement getSavedURLInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@name='url']");
    }

    public static WebElement getSaveURLSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='submit' and @value='SAVE PAGE']");
    }
}
