package com.core;

import com.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    private static String huburl="http://localhost:4444";
   
    
    private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    
    public static void setUp(String browser) throws MalformedURLException {
        URL hubURL=new URL(huburl);
        WebDriver webDriver=null;
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOpts = new ChromeOptions()
                    .addArguments("--disable-gpu")
                    .addArguments("--window-size=1920,1080").addArguments("--headless");
            //for excution without docker
            //WebDriverManager.chromedriver().setup();
            //webDriver=new ChromeDriver(chromeOpts);
            webDriver=new RemoteWebDriver(hubURL,chromeOpts);
            
        }
        else if(browser.equalsIgnoreCase("edge")){
            EdgeOptions edgeOpts = new EdgeOptions()
                    .addArguments("disable-gpu")
                    .addArguments("window-size=1920,1080").addArguments("headless");
            //for execution without docker
//            WebDriverManager.edgedriver().setup();
//            webDriver=new EdgeDriver(edgeOpts);
            webDriver=new RemoteWebDriver(hubURL,edgeOpts);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions=new FirefoxOptions()
                    .addArguments("disable-gpu")
                    .addArguments("window-size=1920,1080")
                    .addArguments("headless");
            
//            //for execution without docker
//            WebDriverManager.firefoxdriver().setup();
//            webDriver=new FirefoxDriver(firefoxOptions);
            webDriver=new RemoteWebDriver(hubURL,firefoxOptions);
        }
        else{
            throw new IllegalArgumentException("Unsupported Browser "+ browser);
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
