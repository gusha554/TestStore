package com.store.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()  {
		
		File f =new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		public String getApplicationURL() {
			String URL=pro.getProperty("baseUrl");
			return URL;
			
			 }
	
		public String getchromebrowser() {
			String browser=pro.getProperty("chromepath");
			return browser;
			
			 }
		public String getedgebrowser() {
			String browser=pro.getProperty("edgepath");
			return browser;
			
			 }
		
	


}
