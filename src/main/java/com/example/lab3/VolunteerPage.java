package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class VolunteerPage {
    public static WebElement getGithubProjectsRepo(Shadow shadow) {
        return shadow.findElement("a[href='https://github.com/internetarchive/openlibrary/blob/master/CONTRIBUTING.md']");
    }

    public static WebElement getGithubChannelRepo(Shadow shadow) {
        return shadow.findElement("a[href='https://github.com/internetarchive/openlibrary/issues/686']");
    }

    public static WebElement getChannelPageLink(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='gitter channel']");
    }
}
