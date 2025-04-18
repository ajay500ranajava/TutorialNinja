package com.tutorialninja.qa.listener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialninja.qa.utils.ExtentReporter;
import com.tutorialninja.qa.utils.Utilities;

public class MyListener implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		//System.out.println("execution of Project test started");
		
		 extentReport=ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
	    extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+"started executing");
		//System.out.println(testName+" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		extentTest.log(Status.PASS,testName+"Got successfully passed");
		//System.out.println(testName+" Got successfully passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver = null;
		
		
		
	 try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		
		e.printStackTrace();
	}
	 
	String destinationScreenshotPath= Utilities.captureScreenshot(driver, result.getName());
	   
        extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
	  
		
		extentTest.log(Status.INFO, result.getThrowable());
		
		extentTest.log(Status.FAIL,testName+"Got failed");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP,testName+"Got skipped");
	}



	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathOfExtentReport= System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
