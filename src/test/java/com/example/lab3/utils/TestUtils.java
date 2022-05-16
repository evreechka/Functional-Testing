package com.example.lab3.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

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
    private static String generateString(int count) {
        byte[] array = new byte[count];
        for (int i = 0; i < count; i++) {
            array[i] = (byte) (Math.random() * 26 + 97);
        }
        return new String(array, StandardCharsets.US_ASCII);
    }
}
