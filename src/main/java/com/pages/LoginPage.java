package com.pages;

import com.core.DriverFactory;
import com.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    
    
    //webelements
    @FindBy(id="user-name")
    WebElement usernameInput;
    @FindBy(id="password")
    WebElement passWordInput;
    @FindBy(id="login-button")
    WebElement loginBtn;
    
    
    
    WebDriver driver;
    public LoginPage(){
        this.driver= DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }
    
    public void enterUserName(String userName){
        usernameInput.clear();
        usernameInput.sendKeys(userName);
    }
    
    public void enterPassword(String passWord){
        passWordInput.clear();
        passWordInput.sendKeys(passWord);
    }
    
    public void clickLogin(){
        loginBtn.click();
    }
    
    public DashBoard loginAs(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
        return new DashBoard();
    }
}
