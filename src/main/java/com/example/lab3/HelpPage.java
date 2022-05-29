package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class HelpPage {
    public static WebElement getAccountsLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@class='panel-block' and text()='Accounts']");
    }

    public static WebElement getBasicGuideLink(Shadow shadow) {
        return shadow.findElement("a[href='https://help.archive.org/help/accounts-a-basic-guide/']");
    }

    public static WebElement getYesButton(Shadow shadow) {
        return shadow.findElement("button[class='button is-success is-rounded is-outlined vote']");
    }

    public static WebElement getMailLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()=' info@archive.org']");
    }
}
