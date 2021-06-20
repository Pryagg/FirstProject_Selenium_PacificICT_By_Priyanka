package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sun.mail.iap.Argument;

import core.Core;

public class searchresultspage extends Core
{
	WebDriver driver;
	String testcasename;
	boolean flag = false;
	
	public searchresultspage(WebDriver driver,String testcasename) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.testcasename = testcasename;
	}
	


	
    @FindBy(xpath="//div[contains(@class,'search_results')][1]/div[2]/a")
	  WebElement firstSearchedProduct ;

	
	@FindBy(xpath="//*[@id='ctl00_PageContent_pnlContent']/div[1]/div[1]/div[2]/div[2]/a")
	WebElement secondsearchedproduct;
	
	//need to change the xpath so that it would be generic one
	// @FindBy(xpath="//*[@id=\"AddToCartButton_827_4167\"]")
	@FindBy(xpath="//input[contains(@id,'AddToCartButton')]")
	WebElement addtocartbtn;
	
	@FindBy(xpath ="//textarea[contains(@id,'OrderNotes')]")
	WebElement Ordernotestextarea;
	
	
	@FindBy(xpath="//input[contains(@value,'Checkout Now')]")
	WebElement proceedtopurchasebtn;
	
	@FindBy(className = "shippingAddress_h2 static_content")
	WebElement shippingaddresstext;
	
	
	
	
	
	// function to Click on First product after searching the product name 
	public boolean clickOnfirstproduct()
	{
		try
		{		
			
			Actions actions = new Actions(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver ;		
			js.executeScript("arguments[0].scrollIntoView(true);", firstSearchedProduct);
			//js.executeScript("window.scrollBy(0,200)");
			//String prductname = firstSearchedProduct.getText();
			//System.out.println(prductname);
			firstSearchedProduct.click();
			
			
			
			
			flag = true;
		}
		catch(Exception e )
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	//Product is added to the cart
	public boolean  addtocart()
	{
		try 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			js.executeScript("arguments[0].scrollIntoView(true);", addtocartbtn);
			//  js.executeScript("window.scrollBy(0,200)");
		addtocartbtn.click();
		Thread.sleep(100);
		//Assert.assertTrue(proceedtopurchasebtn.isDisplayed());
		
		
		//  js.executeScript("window.scrollBy(0,200)");
		
		
		flag = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}		
		return flag;
	}
	
	// click on Proceed to Purchase Button 
	
	
	public boolean proceedtopurchase()
	{
		try 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver ;
			
			js.executeScript("arguments[0].scrollIntoView(true);", Ordernotestextarea);
			Ordernotestextarea.sendKeys("test order, please delete it");
			
			js.executeScript("arguments[0].scrollIntoView(true);", proceedtopurchasebtn);
			//  js.executeScript("window.scrollBy(0,200)");
		    proceedtopurchasebtn.click();
		     Thread.sleep(100);
		
		
		 // js.executeScript("window.scrollBy(0,200)");
		  
		//Assert.assertTrue(shippingaddresstext.isDisplayed());
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
