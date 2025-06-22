package com.pages;

import com.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    
    //webelements
    
    
    WebDriver driver;
    public LoginPage(){
        this.driver= WebDriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }
}
