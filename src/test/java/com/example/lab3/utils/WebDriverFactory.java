package com.example.lab3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverFactory {
    CHROME {
        @Override
        public WebDriver getWebDriver() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://archive.org/");
            return driver;
        }
    },
    FIREFOX {
        @Override
        public WebDriver getWebDriver() {
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://archive.org/");
            return driver;
        }
    };

    public abstract WebDriver getWebDriver();
}
