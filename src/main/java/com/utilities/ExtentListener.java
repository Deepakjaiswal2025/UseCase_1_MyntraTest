package com.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;


public class ExtentListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReportInstance();
    private static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}
