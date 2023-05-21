package com.store.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageObjects.BaseClass;
import com.store.pageObjects.Login;

public class LoginTest extends BaseClass {
	
	 
	Login login;
	SoftAssert sf=new SoftAssert();
    
	@Test(priority = 1,dataProvider ="login" )
	
	public void loginTest(String uname,String pwds) throws InterruptedException, IOException {
		
		login=new Login(driver);
         login.ClickOnLogin();
		
		login.sendloginName(uname,pwds);
		captureScreen(driver,"loginTest");

		
		
		
		
	}
	
	@Test(priority = 2)
	public void validateLandingpage() throws IOException {
		String validateLoggeduser=login.getLoggedUser();
		System.out.println(validateLoggeduser);
		captureScreen(driver,"validateLandingpage");

		
		sf.assertEquals(validateLoggeduser, "Welcome back Test1");
		
		
      
	}
	@Test(priority = 3)
	public void testSelectItems() {
		login.SelectItems();
	}
	@Test(priority = 4)
	public void testSelectProducts() {
		login.selectProducts();
	}
	@Test(priority = 5)
	public void testAddtoCartRandomly() {
		login.addtoCartRandomly();
	}
	
	@Test(priority = 6)
	public void testcheckOutPage() {
		login.checkOutPage();
		login.ConfirmPage();
	}
	
	
	
	
	 @Test(priority = 7)
	 public void testverifyProductDetails() {
		 String verifytitle=login.verifyProducts();
		 System.out.println(verifytitle);
		 sf.assertEquals(verifytitle,"Ruby Shoo Womens Jada T-Bar");
				sf.assertAll();
				 login.logout();

	 
	  }
	
	
	
	
	
	
	
	
	
	
		
		
	
		
		
		


	
	 
	 
	 
	@DataProvider(name="login")
	public Object[][] dataProvider() throws IOException {
		
			System.out.println("DataProvidersssss");
			
			File f=new File((System.getProperty("user.dir")+"\\Datafiles\\LoginTest1.xlsx"));
			FileInputStream fi=new FileInputStream(f);
			//System.out.println(fi);
			 XSSFWorkbook workbook=new XSSFWorkbook(fi);
			// System.out.println(workbook);
			 XSSFSheet sheet1= workbook.getSheet("Sheet1");
			// System.out.println(sheet.getPhysicalNumberOfRows());
			 int noofRows=sheet1.getPhysicalNumberOfRows();
			 int cols=sheet1.getRow(1).getLastCellNum();
			 System.out.println("noofRows");

			 System.out.println(noofRows);
			 System.out.println(cols);
			 String [][] data=new String[noofRows-1][cols];
			 for(int i=0;i<noofRows-1;i++) {
				 for(int j=0;j<cols;j++) {
					 DataFormatter d=new DataFormatter();
					// System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
					 //System.out.println(d.formatCellValue(sheet.getRow(i+1).getCell(j)));
			
						data[i][j]=d.formatCellValue(sheet1.getRow(i+1).getCell(j));
					
					 
				 }
				 
			 }
			 System.out.println(Arrays.toString(data));
			
			return data;

	}
	
		
		
 


	
	
	
	
	
	
	
}