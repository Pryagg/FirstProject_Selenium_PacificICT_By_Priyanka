package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.Core;


public class shippingPage extends Core
{
	WebDriver driver;
	String testcasename;
	WebDriverWait wait;
	boolean flag = false;
	
	
	public shippingPage(WebDriver driver,String testcasename) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.testcasename = testcasename;

	}
	
	
	
	@FindBy(xpath="//input[contains(@id,'tbFirstName')]")
	WebElement Ship_add_Firstname;
	
	@FindBy(xpath="//input[contains(@id,'tbLastName')]")
	WebElement Ship_add_Lastname;
	
	@FindBy(xpath="//input[contains(@id,'tbPhone')]")
	WebElement Ship_add_phone;
	
	@FindBy(xpath="//input[contains(@id,'tbAddress1')]")
	WebElement Ship_add_addressline1;
	
	@FindBy(xpath="//input[contains(@id,'tbAddress2')]")
	WebElement Ship_add_addressline2;
	
	@FindBy(xpath="//input[contains(@id,'tbCity')]")
	WebElement Ship_add_city;
	
	@FindBy(xpath="//select[contains(@id,'ddlCountry')]")
	WebElement Ship_add_country;
	
	@FindBy(xpath="//select[contains(@id,'ddlState')]")
	WebElement Ship_add_state;	
	
	@FindBy(xpath="//input[contains(@id,'tbZipCode')]")
	WebElement Ship_add_zipcode;
	
	@FindBy(xpath="//textarea[contains(@id,'tbDeliveryInstructions')]")
	WebElement Ship_add_deleiveryins;
	
	
	@FindBy(xpath="//input[contains(@id,'ShippingAddressNext')]")
	WebElement Ship_add_continuebtn;
	
	
	@FindBy(xpath="//input[contains(@id,'rblShippingMethodsDynamic_0')]")
	WebElement shippingoption1;

	@FindBy(xpath="//input[contains(@id,'rblShippingMethodsDynamic_1')]")
	WebElement shippingoption2;
	
	@FindBy(xpath="//input[contains(@id,'rblShippingMethodsDynamic_2')]")
	WebElement shippingoption3;
	
	@FindBy(xpath="//input[contains(@id,'ibShippingMethodNext')]")
	WebElement continuebtn_shippingpage;
	
	
	public boolean ShippingAddressEnter()
	{
		try
		{			 			
			String shp_firstname = DataDrivenTesting(testcasename , "shipping address Firstname");
			String shp_Lastname = DataDrivenTesting(testcasename , "shipping address Lastname");
			String shp_phone = DataDrivenTesting(testcasename , "shipping address phone");		
		//	int phone =  Integer.parseInt(DataDrivenTesting(testcasename , "shipping address phone"));					
			String shp_addline1 = DataDrivenTesting(testcasename , "shipping address address line1");			
			String shp_addline2 = DataDrivenTesting(testcasename , "shipping address address line2");			
			String shp_addcity = DataDrivenTesting(testcasename , "shipping address address line3");
			String shp_country = DataDrivenTesting(testcasename , "Shipping address country");
			String shp_state = DataDrivenTesting(testcasename , "Shipping address State");
			String shp_postcode = DataDrivenTesting(testcasename , "Shipping address postcode");
			String shp_del_ins = DataDrivenTesting(testcasename , "shipping address Deleivery instructions ");
			
			wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOf(Ship_add_Firstname));
						
			while(true)
			{
				if (shp_firstname.length() > 0)
				{
					Ship_add_Firstname.sendKeys(shp_firstname);
				}
				if (shp_Lastname.length() > 0)
				{
					Ship_add_Lastname.sendKeys(shp_Lastname);
				}
				
				//Ship_add_phone.sendKeys("abc5696");
				
				  if (shp_phone.length() > 0) {
				  
				  Ship_add_phone.sendKeys(shp_phone); }
				 
				if (shp_addline1.length() > 0)
				{
					
					Ship_add_addressline1.sendKeys(shp_addline1);
				}			
				 
				if (shp_addline2.length() > 0)
				{
					
					Ship_add_addressline2.sendKeys(shp_addline2);
				}
				if (shp_addcity.length() > 0)
				{
					
					Ship_add_city.sendKeys(shp_addcity);
				}
				if (shp_country.length() > 0)
				{
					
					Ship_add_country.sendKeys(shp_country);	
					Thread.sleep(500);
					if(Ship_add_state.isDisplayed())
					{
						 if (shp_state.length() > 0) {
							  
							  Ship_add_state.sendKeys(shp_state); }
					}					
					
					 
				}
				
				 
				if (shp_postcode.length() > 0)
				{				
					Ship_add_zipcode.sendKeys(shp_postcode);
				}		
				if (shp_del_ins.length() > 0)
				{				
					Ship_add_deleiveryins.sendKeys(shp_del_ins);
				}	
				Thread.sleep(500);
				
				 while (true )
				   {
					 
					 
					 if(!Ship_add_continuebtn.getAttribute("src").contains("_black.png"))
					 {
						// Ship_add_continuebtn.click();
						 new Actions(driver).moveToElement(Ship_add_continuebtn).click().perform();
						 
						 flag = true;
						 wait = new WebDriverWait(driver, 2000);
							wait.until(ExpectedConditions.visibilityOf(shippingoption1));
						// wait.until(ExpectedConditions.invisibilityOf(Ship_add_continuebtn));
						 
						 break;
					 }						
				   }
				 break;
				
			}
			/*
			 * if (Ship_add_continuebtn.isDisplayed()) { Ship_add_continuebtn.click(); }
			 */
		    	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
		public boolean selectshippingmethod()
	{
		try
		{
			 wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOf(shippingoption1));
			
			if(shippingoption1.isDisplayed())
			{
				shippingoption1.click();
				
				while (true )
				   {					 
					 if(!continuebtn_shippingpage.getAttribute("src").contains("_black.png"))
					 {
						 continuebtn_shippingpage.click();						 
						 break;
					 }					 
				   }				
		    	//	continuebtn_shippingpage.click();
				//Assert.assertTrue(myaccount.isDisplayed());
				flag = true;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
