package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent; // this class is used to  manage lifecycle test case status and attach report to spark repotter
    public static ExtentSparkReporter spark; // mainly used for create html report file and responsible for UI layout of reports

    public static ExtentReports getReportInstance() {
    	    
    	    if(spark == null) {
    	
	        spark =  new ExtentSparkReporter("extentReports/SparkReport.html");
	
	        spark.config().setReportName("Automation Test Results");
	        spark.config().setDocumentTitle("Selenium Extent Report");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	        
	        extent.setSystemInfo("broswer", "Chrome");
	        extent.setSystemInfo("OS", "Window 11");
	        extent.setSystemInfo("RAM/ROM", "8/512GB");
	        extent.setSystemInfo("Tester", "Deepak");
	        extent.setSystemInfo("Environment", "QA");
    	    
    	  }
        return extent;
    }
}