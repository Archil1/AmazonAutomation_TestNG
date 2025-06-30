package com.tests;



import com.core.DriverFactory;
import com.core.WebDriverManager;
import com.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
    static WebDriver driver;
    
    
    @Parameters("browser")
    @BeforeMethod
    public void launchURL(@Optional("chrome") String browser) throws IOException {
        if(browser==null || browser.isEmpty()){
            browser= ConfigReader.getPropKey("defaultBrowser");
        }
        System.out.println(browser);
        DriverFactory.setUp(browser);
        String url=ConfigReader.getPropKey("baseUrl");
        System.out.println(url);
        DriverFactory.getDriver().get(url);
    }
    
    @AfterMethod
    public void teardown(){
        WebDriverManager.quit();
    }
    
    
    public static void takeScreenshot() {
            driver=DriverFactory.getDriver();
            // Define target directory
            String screenshotDir = System.getProperty("user.dir") + "/target/screenshots/";
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs(); // Create the directory if it doesn't exist
            }

            // Generate timestamped filename
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
            
            String screenshotPath = screenshotDir + "screenshot_" + timeStamp + ".png";

            // Take and save the screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);
            try {
                FileHandler.copy(src, dest);
                System.out.println("✅ Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                System.err.println("❌ Failed to save screenshot: " + e.getMessage());
            }
        }
    
}
