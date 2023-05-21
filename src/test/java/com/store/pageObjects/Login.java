package com.store.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Login {
	WebDriver ldriver;

	public Login(WebDriver rdirver) {
		ldriver = rdirver;
		PageFactory.initElements(rdirver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav main_menu']//a")
	WebElement login;
	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	WebElement loginFrm_loginname;
	@FindBy(xpath = "//input[@id='loginFrm_password']")
	WebElement loginFrm_password;
	@FindBy(xpath = "//div[@class='menu_text']")
	WebElement validatefirstname;
	
	@FindBy(xpath="//button[@title='Login']") 
	 WebElement loginSuccessfully;
	
	@FindBys({ @FindBy(xpath = "//nav[@class='subnav']/ul/li")

	})
	List<WebElement> selectItems;
	@FindBys({ @FindBy(xpath = "//ul[@class='thumbnails row']/li")

	})
	List<WebElement> selectProducts;
	@FindBys({ @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 col-xs-12']//div//a[contains(@class,'prdocutname')]")

	})
	List<WebElement> addToCart;
	
	@FindBy(xpath = "//fieldset//descendant::div[contains(@class,mt20)]/ul//a[@class='cart']")
	WebElement checkoutPage;
	
	@FindBy(xpath = "//div[contains(@class,'pull-right table-responsive')]//a[@title='Checkout']")
	WebElement confirmcheckOut;
	@FindBys
	({
			@FindBy(xpath="//table[@class='table confirm_products']/tbody/tr")
			
	})
 List<WebElement>  rowssize;
 @FindBys
	({
			@FindBy(xpath="//table[@class='table confirm_products']/tbody/tr[1]/td")
			
	})
List<WebElement>  colsize;
 @FindBy(xpath = "//ul[@class='nav navbar-nav main_menu']")
	WebElement logoffnav;
 
 @FindBy(xpath = "//ul[@class='nav navbar-nav main_menu']//ul[@class='sub_menu dropdown-menu']//li[10]")
	WebElement logout;

	
 public void ClickOnLogin() {
	  login.click();

 }
 public void sendloginName(String username,String pwd) throws InterruptedException {
		
	// System.out.println(loginFrm_loginname);
	 //System.out.println(loginFrm_password);
	  // retrieving "foo-button" HTML element
	 Thread.sleep(1000);
	  loginFrm_loginname.sendKeys(username);
	  loginFrm_password.sendKeys(pwd); 
	  loginSuccessfully.click(); 
	  }
 public String getLoggedUser() { 
	  String loggedUser= validatefirstname.getText(); 
	  return loggedUser;
 }
 
 public void logout() {
	 Actions a=new Actions(ldriver);
	 a.moveToElement(logoffnav).build().perform();
	a.moveToElement(logout).build().perform();
	 logout.click();
	 
 }
 public void SelectItems() 
 { 
		List<WebElement>selectShopItems=selectItems; 
	  // for(WebElement  selectItem:selectShopItems) {
		 for (int i = 0; i < selectShopItems.size(); i++) {
		//String trimval=selectItem.getText().replaceAll("\\s","");
			 if(i==1) {
			 selectShopItems.get(i).click();
			 break;
			 }
		 }
	}
 
 public void selectProducts() {
		List<WebElement> multipleproducts=selectProducts; 
		 for(WebElement product:multipleproducts) {
			 System.out.println(product.getText());
				  if(product.getText().equals("Shoes"))
				  { product.click();
				  break;
				  
				  } 
				  }
		   
		}
 
 public void addtoCartRandomly() {
		List<WebElement> addproductstoCart=addToCart; 
		 for(WebElement addproductCart:addproductstoCart) {
			
			String title=addproductCart.getAttribute("title");
			System.out.println(title);

			
			if(title.equals("Ruby Shoo Womens Jada T-Bar")) { 
				addproductCart.click(); 
				break;
				}
			 
			
			 
		 }
	}
		 public void checkOutPage() {
			 checkoutPage.click();
			 
		 }
		 
		 public void ConfirmPage() {
			 confirmcheckOut.click();
		 }
		 
	
		 public String  verifyProducts() {
			 
			 String value="";
			int rows= rowssize.size();
			int cols=colsize.size();
			for(int i=1;i<=rows;i++) {
				
				//table[@class='table confirm_products']/tbody/tr[1]/td[2]
					value=ldriver.findElement(By.xpath("//table[@class='table confirm_products']/tbody/tr["+i+"]/td[2]/a")).getText();
					
					System.out.println(value);
				
				
				 
				 
				 
			 }
			return value;
		 }
	
	
	  
	  
 

}
