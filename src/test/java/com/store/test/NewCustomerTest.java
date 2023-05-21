package com.store.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.pageObjects.BaseClass;
import com.store.pageObjects.NewCustomer;



public class NewCustomerTest extends BaseClass{
	
	@Test(dataProvider="Register")
	public void NewCustomerTest(String firstname,String lastname,String email,String Address,String city,String zip,String loginame,String pwd,String PwdConfirm) throws InterruptedException {
		//driver.get(baseUrl);
		NewCustomer newcustomer=new NewCustomer(driver);
		newcustomer.Register();
		
		newcustomer.ContinueRegister();
		
		//newcustomer.selectCountry();
		newcustomer.NewRegister(firstname,lastname,email,Address,city,zip,loginame,pwd,PwdConfirm);
		newcustomer.registerSuccessfullyTest();
		
	}
		@DataProvider(name="Register")
		public Object[][] dataProviderReg() throws IOException {
			
				System.out.println("DataProvidersssss Register");
				
				File f=new File((System.getProperty("user.dir")+"\\Datafiles\\Register1.xlsx"));
				FileInputStream fi=new FileInputStream(f);
				System.out.println(fi);
				 XSSFWorkbook workbook=new XSSFWorkbook(fi);
				 System.out.println(workbook);
				 XSSFSheet sheet= workbook.getSheet("Sheet1");
				 System.out.println(sheet.getPhysicalNumberOfRows());
				 int noofRows=sheet.getPhysicalNumberOfRows();
				 int cols=sheet.getRow(1).getLastCellNum();
				 System.out.println(noofRows);
				 System.out.println(cols);
				 String [][] data=new String[noofRows-1][cols];
				 for(int i=0;i<noofRows-1;i++) {
					 for(int j=0;j<cols;j++) {
						 DataFormatter d=new DataFormatter();
						
						//System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue());
				
						//data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
						
						System.out.println(d.formatCellValue(sheet.getRow(i+1).getCell(j)));
						data[i][j]=d.formatCellValue(sheet.getRow(i+1).getCell(j));
						
						
						
						 
					 }
					 
				 }
				 System.out.println(Arrays.toString(data));
				
				return data;

		}
	 
	

}

	

