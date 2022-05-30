package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class MainPage {
    public WebElement getUserIconButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@title='Expand user menu']");
    }

    public WebElement getOpenHelpPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/about/faqs.php' and @class='help']");
    }

    public WebElement getOpenBlogPageLink(Shadow shadow) {
        return shadow.findElement("a[href='https://blog.archive.org']");
    }

    public WebElement getOpenVolunteerPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/about/volunteerpositions.php' and @class='volunteer']");
    }

    public WebElement getOpenTextsPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href = '/details/texts' and @title='Texts']");
    }

    public WebElement getOpenSoftwarePageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href = '/details/software' and @title='Software']");
    }

    public WebElement getWebArchiveTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='My web archives']");
    }

    public WebElement getSaveAndShareButton(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='__new_item__']");
    }

    public WebElement getSavedURLInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@name='url']");
    }

    public WebElement getSaveURLSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='submit' and @value='SAVE PAGE']");
    }
}
