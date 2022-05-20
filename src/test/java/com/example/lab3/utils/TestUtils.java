package com.example.lab3.utils;

import io.github.sukgu.Shadow;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebElement;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Thread.sleep;

public class TestUtils {
    public static String generateEmail() {
        int count = (int) (Math.random() * 10 + 4);
        StringBuilder email = new StringBuilder(generateString(count)).append("@");
        count = (int) (Math.random() * 5 + 2);
        email.append(generateString(count)).append(".com");
        return email.toString();
    }

    public static String generatePassword() {
        int count = (int) (Math.random() * 20 + 3);
        return generateString(count);
    }

    public static String generateUsername() {
        int count = (int) (Math.random() * 30 + 6);
        return generateString(count);
    }

    public static String generateString(int count) {
        byte[] array = new byte[count];
        for (int i = 0; i < count; i++) {
            array[i] = (byte) (Math.random() * 26 + 97);
        }
        return new String(array, StandardCharsets.US_ASCII);
    }

    public static void login(PropertiesConfiguration propertiesConfiguration, Shadow shadow) throws InterruptedException {
        final String EMAIL = propertiesConfiguration.getString("email");
        final String PASSWORD = propertiesConfiguration.getString("password");

        WebElement logInButton = shadow.findElementByXPath("//a[@href='/account/login' and text()='Log in']");
        logInButton.click();

        shadow.findElementByXPath("//input[@type='email' and @name='username']").sendKeys(EMAIL);
        shadow.findElementByXPath("//input[@type='password' and @name='password']").sendKeys(PASSWORD);
        shadow.findElementByXPath("//input[@type='submit' and @name='submit-to-login']").click();

        sleep(1000);
    }
}
