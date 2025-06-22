package com.tests;

import com.pages.DashBoard;
import com.pages.LoginPage;
import com.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{
  
    @Test
    public void loginTest() throws IOException, InterruptedException {
        LoginPage loginPage=new LoginPage();
        String userName= ConfigReader.getPropKey("username1");
        String passWord=ConfigReader.getPropKey("password");
        DashBoard dashBoard=loginPage.loginAs(userName,passWord);
        Thread.sleep(5000);
        takeScreenshot();
        String actual=dashBoard.getTitle();
        String expected= "Swag Labs";
        Assert.assertEquals(actual, expected, "Dashboard Title shoule match");
    }
//    
//    @Test
//    public void verifyCorrectUser(){
//        
//    }
    
    
}
