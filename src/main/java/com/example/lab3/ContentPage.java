package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class ContentPage {
    public static WebElement getCollectionTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[@id='tabby-collection-finder']");
    }

    public static WebElement getCollectionBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='americana']");
    }

    public static WebElement getArchiveBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='cdl']");
    }

    public static WebElement getBookLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='wonderfulwizardo00baumiala']");
    }

    public static WebElement getShareButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@data-original-title='Share this item']");
    }

    public static WebElement getCollectionSoftwareLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='bussidmod']");
    }

    public static WebElement getSoftwareProductLink(Shadow shadow) {
        return shadow.findElementByXPath("//div[@data-id='livery-truck-gunawan-fam-8os-by-rg-design']");
    }

    public static WebElement getFavoriteButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@data-id='livery-truck-gunawan-fam-8os-by-rg-design']");
    }

    public static WebElement getForumTab(Shadow shadow) {
        return shadow.findElementByXPath("//a[@id='tabby-forum-finder']");
    }

    public static WebElement getNewPostButton(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='New Post']");
    }

    public static WebElement getPostSubjectInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@name='postsubject']");
    }

    public static WebElement getPostBodyInput(Shadow shadow) {
        return shadow.findElementByXPath("//textarea[@name='postbody']");
    }

    public static WebElement getPostSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//input[@value='Submit Post']");
    }
}
