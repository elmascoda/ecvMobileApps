package org.example;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReportsDemo {
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    public ExtentReportsDemo() {
    }

    @BeforeSuite
    public void reportSetup() {
        this.htmlReporter = new ExtentHtmlReporter("C:\\Users\\dell\\Desktop\\extent.html");
        this.extent = new ExtentReports();
        this.extent.attachReporter(new ExtentReporter[]{this.htmlReporter});
    }

    @AfterSuite
    public void reportTeardown() {
        this.extent.flush();
    }
}
