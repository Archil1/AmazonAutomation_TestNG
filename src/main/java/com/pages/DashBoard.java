package com.pages;

import com.core.DriverFactory;
import com.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
    
    WebDriver driver;
    public DashBoard(){
        this.driver= DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
    public String getTitle() {
        return driver.getTitle();
    }
}
