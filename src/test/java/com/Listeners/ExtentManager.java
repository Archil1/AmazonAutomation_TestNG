package com.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter); // ✅ This should now work
        extent.setSystemInfo("Tester", "ARCHIL");
        return extent;
    }


}
