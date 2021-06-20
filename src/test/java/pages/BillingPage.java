package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Core;

public class BillingPage extends Core
{
	
	WebDriver driver;
	String testcasename;
	boolean flag = false;
	
	public BillingPage(WebDriver driver,String testcasename) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.testcasename = testcasename;
	}
	
	@FindBy(xpath="//input[contains(@name,'rblBillingEqualsShipping')][@value=\"1\"]")
	WebElement billingaddress_sameasshipping;
	
	@FindBy(xpath="//input[contains(@name,'rblBillingEqualsShipping')][@value=\"0\"]")
	WebElement billingaddress_differentasshipping;
	
	
	public boolean selectbillingmethod() 
	{
		try
		{
			String billingaddressvalue = DataDrivenTesting(testcasename , "Billing address");
			
			 wait = new WebDriverWait(driver, 2000);
				wait.until(ExpectedConditions.visibilityOf(billingaddress_sameasshipping));
				
				//Assert.assertTrue(myaccount.isDisplayed());
			
			if(billingaddressvalue.equalsIgnoreCase("same as Shipping "))
			{
				billingaddress_sameasshipping.click();
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
