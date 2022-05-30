package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class HelpPage {
    public WebElement getAccountsLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[@class='panel-block' and text()='Accounts']");
    }

    public WebElement getBasicGuideLink(Shadow shadow) {
        return shadow.findElement("a[href='https://help.archive.org/help/accounts-a-basic-guide/']");
    }

    public WebElement getYesButton(Shadow shadow) {
        return shadow.findElement("button[class='button is-success is-rounded is-outlined vote']");
    }

    public WebElement getMailLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()=' info@archive.org']");
    }
}
