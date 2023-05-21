package com.store.utilites;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class GenerateExtentReport{
	com.relevantcodes.extentreports.ExtentReports extent;
	//ExtentSparkReporter sparkreporter;
	com.relevantcodes.extentreports.ExtentTest test;
	@BeforeClass
	public void startTestReport() {
		extent=new com.relevantcodes.extentreports.ExtentReports(System.getProperty("user.dir")+"/test-output/myOwnreport.html",true);
		//extent.addSystemInfo("HostName","LocalHost");
		//extent.addSystemInfo("Environment","QA");
		extent.addSystemInfo("username","usha");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

	}
	

	@Test
	public void DemoReportFail() {
		test=extent.startTest("Fail");
		Assert.assertTrue(false);
	}
		
		@AfterMethod
		public void getResult(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				
			}
			extent.endTest(test);
		}
		
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
		
	
	
}