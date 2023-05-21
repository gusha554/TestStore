package com.store.pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.store.*;
import com.store.utilites.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	public String baseUrl=readconfig.getApplicationURL();
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
			
			System.setProperty("webdriver.chromer.driver", readconfig.getchromebrowser());
			//;

			driver=new ChromeDriver();



		
		


		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		//Logger=Logger.getLogger("testStore");
		//PropertyConfigurator.configure("log4j.properites");
	  ExtentReports extent=new ExtentReports();
	  
	  
		
		
	}
	
	
	 @AfterClass public void tearDown() { driver.quit(); }
	 
	 public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		
	 
	 
	 

}

