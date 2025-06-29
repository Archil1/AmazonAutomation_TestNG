package com.Listeners;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter{

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            String suiteName = suite.getName();
            Map<String, ISuiteResult> suiteResults = suite.getResults();

            for (ISuiteResult result : suiteResults.values()) {
                ITestContext context = result.getTestContext();

                System.out.println("Suite: " + suiteName);
                Reporter.log("Suite: " + suiteName);
                System.out.println("Passed tests: " + context.getPassedTests().getAllResults().size());
                Reporter.log("Passed tests: " + context.getPassedTests().getAllResults().size());
                System.out.println("Failed tests: " + context.getFailedTests().getAllResults().size());
                Reporter.log("Failed tests: " + context.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests: " + context.getSkippedTests().getAllResults().size());
                Reporter.log("Skipped tests: " + context.getSkippedTests().getAllResults().size());
                
                System.out.println("==================================================================");
            }
        }
    }

}
