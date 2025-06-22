package com.core;

import com.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    public static void setUp(String browser){
        WebDriver webDriver=null;
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            webDriver=new EdgeDriver();
        }
        assert webDriver != null;
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.getInteger(ConfigReader.getPropKey("implicitWait"))));
        driver.set(webDriver);
    }
    public static synchronized WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver() {
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}
