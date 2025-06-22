package com.tests;

import com.core.WebDriverManager;
import com.utils.ConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    @Parameters("browser")
    @BeforeTest
    public void launchURL(String browser){
        if(browser==null || browser.isEmpty()){
            browser= ConfigReader.getPropKey("defaultBrowser");
        }
        WebDriverManager.init_driver(browser);
        WebDriverManager.getDriver().get(ConfigReader.getPropKey("baseUrl"));
    }
    
    @AfterTest
    public void teardown(){
        WebDriverManager.quit();
    }
}
