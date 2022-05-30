package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class ContentPage {
    public WebElement getCollectionTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[@id='tabby-collection-finder']");
    }

    public WebElement getCollectionBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='americana']");
    }

    public WebElement getArchiveBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='cdl']");
    }

    public WebElement getBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='wonderfulwizardo00baumiala']");
    }

    public WebElement getShareButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@data-original-title='Share this item']");
    }

    public WebElement getCollectionSoftwareLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='bussidmod']");
    }

    public WebElement getSoftwareProductLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='livery-truck-gunawan-fam-8os-by-rg-design']");
    }

    public WebElement getFavoriteButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@data-id='livery-truck-gunawan-fam-8os-by-rg-design']");
    }

    public WebElement getForumTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[@id='tabby-forum-finder']");
    }

    public WebElement getNewPostButton(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='New Post']");
    }

    public WebElement getPostSubjectInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@name='postsubject']");
    }

    public WebElement getPostBodyInput(Shadow shadow) {
        return shadow.findElementByXPath("//textarea[@name='postbody']");
    }

    public WebElement getPostSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//input[@value='Submit Post']");
    }
}
