package com.example.lab3.utils;

import com.example.lab3.AuthPage;
import io.github.sukgu.Shadow;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.nio.charset.StandardCharsets;

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

        AuthPage.getLogInButton(shadow).click();
        AuthPage.getEmailInput(shadow).sendKeys(EMAIL);
        AuthPage.getPasswordInput(shadow).sendKeys(PASSWORD);
        AuthPage.getLogInSubmitButton(shadow).click();

        sleep(5000);
    }
}
