package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;

public class EmailEnterPage extends Core
{

	WebDriver driver; 
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	String testcasename;
	boolean flag = false;
		
	public EmailEnterPage(WebDriver driver,String testcasename, ExtentHtmlReporter htmlReporter, ExtentReports extent) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.extent = extent;
		this.htmlReporter = htmlReporter;
		this.testcasename = testcasename;
	}
	
	@FindBy(xpath="//input[contains(@id,'tbEmail')]")
	WebElement emaildetails;
	
	/*
	 * @FindBy(xpath="//input[contains(@id,'PageContent_ibNext')][@alt=\"NEXT\"]")
	 * WebElement continue_btn_emailPage;
	 */
	
	@FindBy(xpath="//*[@id=\"ctl00_PageContent_ibNext\"]")
	WebElement continue_btn_emailPage;

	
	
	@FindBy(xpath="//input[contains(@id,'tbPassword')]")
	WebElement password_emailpage;
	
	 
	@FindBy(id="unregisteredCustomerBlock")
	WebElement div_unregisteredmsg;
	
	public boolean EnterEmail()
	{
		try
		{
			String username = DataDrivenTesting(testcasename , "username");
			if (username.length() > 0)
			{
				emaildetails.clear();
				emaildetails.sendKeys(username + Keys.TAB);
				Thread.sleep(1000);			
				/*WebDriverWait wait = new WebDriverWait(driver, 1000);
				wait.until(ExpectedConditions.elementToBeClickable(continue_btn_emailPage));	*/			
				//Thread.sleep(1000);
				
				//String consrc = continue_btn_emailPage.getAttribute("src");
				//System.out.println(consrc);
				/*	
				 * do {
				 * 
				 * if(true) {
				 * 
				 * break; } Thread.sleep(500);
				 * 
				 * 
				 * 
				 * 
				 * } while(true);
				 */			
							
				
				 while (true )
				   {
					 if (password_emailpage.isDisplayed())
						{
						 if(password_emailpage.getText().isEmpty())
						 {
							 String pass = DataDrivenTesting(testcasename, "password");
							if(pass.length() >0)
							{
								//Thread.sleep(100);
								password_emailpage.sendKeys(pass);
								continue_btn_emailPage.click();
								break;
							}
						 }												
						}
					 
					 else if(!continue_btn_emailPage.getAttribute("src").contains("_black.png"))
					 {
						 continue_btn_emailPage.click();
						
						 //wait.until(ExpectedConditions.invisibilityOf(continue_btn_emailPage));						 
						 
						 break;
					 }			
						
					 
					 else if (div_unregisteredmsg.isDisplayed())
						 
					 {
						 if(!continue_btn_emailPage.getAttribute("src").contains("_black.png"))
						 {
							 continue_btn_emailPage.click();
							
							 //wait.until(ExpectedConditions.invisibilityOf(continue_btn_emailPage));						 
							 
							 break;
						 }
					 }					   
				   }
				
				 //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			//	continue_btn_emailPage.click();	
			//	Thread.sleep(1000);
			
				
				
				
			/*	
				if (password_emailpage.isDisplayed())
				{
					String pass = DataDrivenTesting(testcasename, "password");
					if(pass.length() >0)
					{
						Thread.sleep(100);
						password_emailpage.sendKeys(pass);
						continue_btn_emailPage.click();		
					}			
				}
				else
				{
					System.out.println("Password not found");
				}
					*/	
			}
			flag = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}		
		return flag;
	}


}
