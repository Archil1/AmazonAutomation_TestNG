package com.core;

import com.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    public static void setUp(String browser){
        WebDriver webDriver=null;
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOpts = new ChromeOptions()
                    .addArguments("--disable-gpu")
                    .addArguments("--window-size=1920,1080").addArguments("--headless");

            WebDriverManager.chromedriver().setup();
            webDriver=new ChromeDriver(chromeOpts);
        }
        else if(browser.equalsIgnoreCase("edge")){
            EdgeOptions edgeOpts = new EdgeOptions()
                    .addArguments("disable-gpu")
                    .addArguments("window-size=1920,1080").addArguments("headless");
            
            WebDriverManager.edgedriver().setup();
            webDriver=new EdgeDriver(edgeOpts);
        }
        assert webDriver != null;
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.getInteger(ConfigReader.getPropKey("implicitWait"))));
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
