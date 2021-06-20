package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;

public class homepage extends Core
{
	WebDriver driver; 
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	String testcasename;
	boolean flag = false;
		
	public homepage(WebDriver driver,String testcasename, ExtentHtmlReporter htmlReporter, ExtentReports extent) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.extent = extent;
		this.htmlReporter = htmlReporter;
		this.testcasename = testcasename;
		
	}
	
	//Pagefactory approach by Page Object Model
	/*
	 * @FindBy(xpath = "//*[@id='CategoryNav_25']/a") WebElement Generallink;
	 */
	
	
	@FindBy(xpath="//*[@class=\"shopping_cart_text\"]/a[contains(@href,'signin')]")
	WebElement Loginbtn;	
		
	@FindBy(xpath="//input[contains(@id,'Login_UserName')]")
	WebElement useremail;
	
	@FindBy(xpath="//input[contains(@id,'Login_Password')]")
	WebElement pswrd;
	
	@FindBy(xpath="//input[contains(@value,'Login')]" )
	WebElement Login;
	
	@FindBy(id="ctl00_ctl10_MyAccount")
	WebElement myaccount;
	
    By generallink = By.xpath("//*[@id=\"CategoryNav_25\"]");
	
	@FindBy(xpath="( //*[@id='SubName']//a//b)[1]")
	WebElement Productlink ;	
	/*
	 * @FindBy(xpath
	 * ="//input[contains(@id,'tsfSearch_Input')][contains(@name,'tsfSearch')][contains(@class,'rsbInput')]")
	 * WebElement searchbox1;
	 */
	
	@FindBy(xpath ="//input[contains(@id,'tsfSearch_Input')][contains(@name,'ctl12_tsfSearch')][contains(@class,'rsbInput')]") 
	WebElement searchbox1; 	
	
	@FindBy(xpath ="//input[contains(@id,'tsfSearch_Inpt')][contains(@name,'ctl12_tsfSearch')][contains(@class,'rsbInput')]") 
	WebElement searchbox2; 	
	
	@FindBy(xpath = "//*[@id=\"ctl00_ctl2_tsfSearch\"]/span/button/span")
	WebElement SearchButton;		
	
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[9]/div[1]/footer/div[1]/ul/li[3]/a")
	WebElement aboutuslink;
	 
	//page object model without page factory approach
	By searchbox = By.xpath("//*[@id=\"ctl00_ctl13_tsfSearch_Input\"]");	
	
	

	
	public Boolean Login(String datafileusername, String datafilepassword)
	{
		try
		{			
			//test1 = extent.createTest("Login", "test case 1");
			
			String methodvalue = DataDrivenTesting(testcasename, "usertype");
			if (methodvalue.equalsIgnoreCase("signedin user")) 
			{
				
				 JavascriptExecutor js = (JavascriptExecutor) driver ;
					  js.executeScript("window.scrollBy(0,200)");
				
				 Loginbtn.click();
				 
				 WebElement cookieclsebtn = driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));				   
					
				  if(cookieclsebtn.getText().equalsIgnoreCase("CLOSE")) 
				  {
				  cookieclsebtn.click(); 
				  }			
				
				  useremail.sendKeys(DataDrivenTesting(testcasename,"username"));
				  pswrd.sendKeys(DataDrivenTesting(testcasename,"password"));
				 			 
				/*
				 * useremail.sendKeys("priyanka@pacificict.co.nz"); pswrd.sendKeys("Test@123");
				 */
				  js.executeScript("arguments[0].scrollIntoView(true);", Login);
				Thread.sleep(200);
				Login.click();
				
				
				Thread.sleep(1000);				
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
	
	
	
	
	/*
	 * public void Login(String datafileusername, String datafilepassword) { try {
	 * //test1 = extent.createTest("Login", "test case 1");
	 * 
	 * Loginbtn.click(); useremail.sendKeys(getPropertyvalue(datafileusername));
	 * pswrd.sendKeys(getPropertyvalue(datafilepassword)); Thread.sleep(20);
	 * Login.click(); Thread.sleep(1000); //String myaccounttext =
	 * myaccount.getText(); //System.out.println(myaccounttext);
	 * //Assert.assertEquals(myaccounttext , "My Account");
	 * Assert.assertTrue(myaccount.isDisplayed()); //Assert.assertTrue(1>0);
	 * Report1og("testcase1", "end to end test case",
	 * "Logged in successfully",htmlReporter, extent);
	 * 
	 * 
	 * } catch(Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * @param datafileProductname
	 * @return
	 */
	public boolean SearchProduct(String datafileProductname)
	{
 		String productname = "";
		try
		{
			Actions actions = new Actions(driver);
			//extentrep = extentinstance();
			  //test1 = extent.createTest("SearchProduct", "test case 2");
			  
			// Method-1: Page object model example without Page factory approach			
			/*
			 * driver.findElement(By.xpath("//*[@id=\"ctl00_ctl12_tsfSearch_Input\"]")).
			 * clear();
			 * driver.findElement(By.xpath("//*[@id=\"ctl00_ctl12_tsfSearch_Input\"]")).
			 * sendKeys("Buscopan 10mg");
			 */
			// Method-2: Page object model example with Page factory approach	
			
			// taking data from Excel file 
			  productname = DataDrivenTesting(testcasename , "Productname");
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver ;						
			//  js.executeScript("arguments[0].scrollIntoView(true);", searchbox1);		
				  js.executeScript("window.scrollBy(0,200)");
			  searchbox1.clear();
			  // taking data from config file 
			 // searchbox1.sendKeys(getPropertyvalue(datafileProductname));
			//  searchbox1.sendKeys(productname);
			// actions.moveToElement(searchbox1).sendKeys("buscopan 10 mg");
			  
			
			  actions.moveToElement(searchbox1).sendKeys(searchbox1,productname).perform();
			  searchbox1.sendKeys(Keys.TAB);
			  searchbox1.sendKeys(Keys.ENTER);
			 
			 
			 
			 
			 
			  Thread.sleep(10);
			  
				// actions.moveToElement(searchbox1).sendKeys(searchbox1, productname);
			/*
			 * js.executeScript("arguments[0].scrollIntoView(true);", SearchButton);
			 * SearchButton.click();
			 */
			  //actions.moveToElement(SearchButton).click().perform();
			  
			  // search about go to element
			  
	
			 
			  flag = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}		
		
		return flag;
	}
	
	
	public void generallinkclick()
	{
		try
		{
			driver.findElement(generallink).click();			
		}
		catch(Exception e)
		{			
			e.printStackTrace();
		}		
	}
	

	public void Aboutus()
	{
		try 
		{
			aboutuslink.click();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void Login()
	{		
	}
	
	
	public void SelectCountry()
	{		
	}
	
	
	public void SelectCurrency()
	{		
	}
	
	public void ProductDecriptionLinkClick()
	{		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][1];
		data[0][0]="Priyanka.pacificict.co.nz";
		data[0][1]= "Test@123";		
		
		/*
		 * data[1][0]="Test43@pacificict.co.nz"; data[1][1]= "Test@123";
		 */
		
		return data;
		
	}

}
