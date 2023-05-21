package com.store.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewCustomer {

	WebDriver ldriver;

	public NewCustomer(WebDriver rdirver) {
		ldriver = rdirver;
		PageFactory.initElements(rdirver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav main_menu']//a")
	WebElement login;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement Continue;

	public void Register() throws InterruptedException {
		// ldriver.findElement(By.xpath("//ul[@class='nav navbar-nav
		// main_menu']//a")).click();
		login.click();

	}

	public void ContinueRegister() {

		Continue.click();
	}

	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	WebElement AccountFrm_firstname;
	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	WebElement AccountFrm_lastname;
	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	WebElement AccountFrm_email;

	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	WebElement AccountFrm_address;
	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	WebElement AccountFrm_postcode;
	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	WebElement AccountFrm_loginname;

	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	WebElement AccountFrm_passwor;
	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	WebElement AccountFrm_confirm;

	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	WebElement AccountFrm_zone_id;

	@FindBy(xpath = "//select[@id='AccountFrm_country_id']")
	WebElement AccountFrm_country_id;

	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	WebElement AccountFrm_agree;
	@FindBy(xpath = "//button[@title='Continue']")
	WebElement button;
	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	WebElement AccountFrm_city;

	public void selectRegion() throws InterruptedException {
		Select sw = new Select(AccountFrm_zone_id);
		List<WebElement> reg= sw.getOptions();
		for(WebElement option:reg) {
			System.out.println(option.getText());
			
				
					
					
					
			}
		
		
		sw.selectByIndex(2);
		sw.selectByIndex(3);

		System.out.println("Selected Option"+sw.getFirstSelectedOption().getText());
		}
       

	

	public void selectCountry() {
		Select s = new Select(AccountFrm_country_id);
		s.selectByIndex(1);
		System.out.println("Selected Option"+s.getFirstSelectedOption().getText());

	}

	public void selectPrivacypolicy() {

		AccountFrm_agree.click();
	}

	public void NewRegister(String firstname, String lastname, String email, String Address, String city, String zip,
			String loginame, String pwd, String PwdConfirm) throws InterruptedException {
		Thread.sleep(1000);
		// ldriver.findElement(By.xpath("//input[@id='AccountFrm_firstname']")).sendKeys("Test2");
		AccountFrm_firstname.sendKeys(firstname);
		AccountFrm_lastname.sendKeys(lastname);

		AccountFrm_email.sendKeys(email);
		AccountFrm_address.sendKeys(Address);
		AccountFrm_city.sendKeys(city);
		AccountFrm_postcode.sendKeys(zip);
		selectRegion();
		selectCountry();


		selectPrivacypolicy();
		AccountFrm_loginname.sendKeys(loginame);
		AccountFrm_passwor.sendKeys(pwd);
		AccountFrm_confirm.sendKeys(PwdConfirm);

	}
	


	public void registerSuccessfullyTest() {

		button.click();
	}

}
