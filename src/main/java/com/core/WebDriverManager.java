package com.core;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverManager {
    
    public static void init_driver(String browser) throws MalformedURLException {
        DriverFactory.setUp(browser);
    }
    public static WebDriver getDriver(){
        return DriverFactory.getDriver();
    }
    
    public static void quit(){
        DriverFactory.quitDriver();
    }
}
