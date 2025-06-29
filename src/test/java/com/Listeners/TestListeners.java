package com.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListeners implements ITestListener {
    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String reportPath = System.getProperty("user.dir") + "/target/ExtentReport/ExtentReport_" + timestamp + ".html";
    ExtentReports extent = ExtentManager.createInstance(reportPath);
    
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        System.out.println("[START] " + result.getName());
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] " + result.getName());
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] " + result.getName());
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] " + result.getName());
        test.get().skip(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
