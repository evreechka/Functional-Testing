package com.example.lab3;

import io.github.sukgu.Shadow;
import org.openqa.selenium.WebElement;

public class AuthPage {
    public WebElement getSignUpButton(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/account/signup' and text()='Sign up']");
    }

    public WebElement getEmailInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='email' and @name='username']");
    }

    public WebElement getScreenNameInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='text' and @name='screenname']");
    }

    public WebElement getPasswordInput(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='password' and @name='password']");
    }

    public WebElement getSignUpSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//button[@name='submit-to-signup']");
    }

    public WebElement getLogInButton(Shadow shadow) {
        return shadow.findElementByXPath("//a[@href='/account/login' and text()='Log in']");
    }

    public WebElement getLogInSubmitButton(Shadow shadow) {
        return shadow.findElementByXPath("//input[@type='submit' and @name='submit-to-login']");
    }

    public WebElement getLogOutButton(Shadow shadow) {
        return shadow.findElementByXPath("//a[text()='Log out']");
    }
}
