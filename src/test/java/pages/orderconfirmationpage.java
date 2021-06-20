package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import core.Core;
import utility.Property;

@Test
public class orderconfirmationpage extends Core
{
	WebDriver driver;
	boolean flag = false;
	
	public orderconfirmationpage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@id,'ibContinueSubscription')][@alt=\"CONTINUE\"]")
	WebElement keep_in_touch_method_continue_btn;
	
	@FindBy(xpath = "//div[contains(@id,'terms_box')]/label[1]/span[1]")
	WebElement condition1_acceptterms;
	
	@FindBy(xpath = "//div[contains(@id,'terms_box')]/label[2]/span[1]")
	WebElement condition2_acceptterms;
	
	/*
	 * @FindBy(xpath = "//div[contains(@id,'terms_box')]/label[3]/span[1]")
	 * //WebElement condition3_acceptterms; List<WebElement> condition3_acceptterms;
	 */
	@FindBy(xpath = "//div[contains(@id,'terms_box')]/label[3]/span[1]")
	//WebElement condition3_acceptterms;
	WebElement condition3_acceptterms;
	
	
	@FindBy(xpath = "//div[contains(@id,'terms_box')]/label[4]/span[1]")
	//WebElement condition3_acceptterms;
	WebElement condition4_acceptterms;
	
	@FindBy(xpath = "//div[contains(@id,'terms_box')]/label[5]/span[1]")
	//WebElement condition3_acceptterms;
	List<WebElement> condition5_acceptterms;
//	WebElement condition5_acceptterms;
	
	
	@FindBy(xpath="//span[contains(@id,'lblDOB')]")
	WebElement DOB;
	
	@FindBy(xpath="//select[contains(@id,'ddlDOBYear')]")
	WebElement DOB_year;
	
	@FindBy(xpath="//select[contains(@id,'ddlDOBMonth')]")
	WebElement DOB_month;
	
	@FindBy(xpath="//select[contains(@id,'ddlDOBDay')]")
	WebElement DOB_day;
	
	
	@FindBy(xpath="//input[contains(@id,'ibContinueTerms')][@alt=\"CONTINUE\"]")
	WebElement continuebtn_acceptterms;
	
	@FindBy(xpath="//input[contains(@id,'rbCreateAccount')]")
	WebElement Create_useraccount_radiobtn;
	
	@FindBy(xpath="//input[contains(@id,'rbGuestAccount')]")
	WebElement Guest_useraccount_radiobtn;
	
	
	@FindBy(xpath="//input[contains(@id,'ibPlaceOrder_alt')]")
	WebElement orderconfrmtn_btn;
	

	public boolean keepintouchmethod()
	{
		try 
		{
			Thread.sleep(2000);
			while (true )
			   {					
					 if(!keep_in_touch_method_continue_btn.getAttribute("src").contains("_black.png"))
					 {
						 keep_in_touch_method_continue_btn.click();	
						 flag = true;
						 break;
					 }										 
			   }						
			/*
			 * if(keep_in_touch_method_continue_btn.isDisplayed()) {
			 * keep_in_touch_method_continue_btn.click(); }
			 */				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean acceptterms()
	{
		try 
		{
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * ".\\resources\\drivers\\chromedriver.exe"); driver = new ChromeDriver();
			 * driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			 * driver.get("https://www.inhousepharmacy.biz/mpc/step5_summary.aspx");
			 */
					
			WebDriverWait wait = new WebDriverWait(driver, 4000);
			wait.until(ExpectedConditions.visibilityOf(condition1_acceptterms));
			Thread.sleep(2000);
			
			// replaced the commented code... start here
			List <WebElement> acceptterms_count = driver.findElements(By.xpath("//div[contains(@id,'terms_box')]/label"));
			int accept_count = acceptterms_count.size();
			//System.out.println(accept_count);
			
			
			for(int i =1;i<=accept_count;i++)
			{			
					//Dimension acc_size = driver.findElement(By.xpath("//div[contains(@id,'terms_box')]/label[" +i+ "]/span[1]")).getSize();
					//System.out.println(acc_size);
					/*if(acc_size>0)
					{*/
						driver.findElement(By.xpath("//div[contains(@id,'terms_box')]/label[" +i+ "]/span[1]")).click();	
						
				if(i==(accept_count))					
						{		//taken size of the DOB_ 
						int dob_elementexist = driver.findElements(By.xpath("//span[contains(@id,'lblDOB')]")).size();
						if(dob_elementexist!=0)
						{
							if(!DOB_year.isDisplayed())
							   {
								   DOB.click();				 
								   Thread.sleep(500);
								   DOB_year.sendKeys("1909");
								   Thread.sleep(500);
								   DOB_month.sendKeys("March");
								   Thread.sleep(500);
								   DOB_day.sendKeys("2"+ Keys.TAB);
							   }
							   else if(DOB_year.isDisplayed())
							   {   								   
								   DOB_year.sendKeys("1909");
								   DOB_month.sendKeys("March");
								   DOB_day.sendKeys("2"+ Keys.TAB);
								  // break;
							   }						  
						}		
						else
						{
							System.out.println("user is signed in user");
						}					
				}				 
			}
			Thread.sleep(500);						  
			  while(true)
			  {
				  if(!continuebtn_acceptterms.getAttribute("src").contains("_black.png") && continuebtn_acceptterms.isDisplayed())
			      {							 
					  new Actions(driver).moveToElement(continuebtn_acceptterms).click().perform();
					  flag = true;
					  break;
			       }	
			  }		
			// replaced the commented code... ends here
			


			//original code for accept terms without loop starts here	
			
			/*
			 * if(condition1_acceptterms.isDisplayed()) { condition1_acceptterms.click();
			 * condition2_acceptterms.click();
			 * 
			 * if(condition3_acceptterms.isDisplayed()) { condition3_acceptterms.click(); }
			 * if(condition4_acceptterms.isDisplayed()) { condition4_acceptterms.click(); }
			 * 
			 * if(condition5_acceptterms.size()>0)
			 * //if(condition5_acceptterms.isDisplayed()) {
			 * condition5_acceptterms.get(0).click(); //condition5_acceptterms.click();
			 * //condition3_acceptterms.sendKeys(Keys.TAB); //DOB.sendKeys(Keys.TAB);
			 * if(!DOB_year.isDisplayed()) { DOB.click(); Thread.sleep(500);
			 * DOB_year.sendKeys("1909"); DOB_month.sendKeys("March"); DOB_day.sendKeys("2"+
			 * Keys.TAB); } else { DOB_year.sendKeys("1909"); DOB_month.sendKeys("March");
			 * DOB_day.sendKeys("2"+ Keys.TAB); } } else {
			 * System.out.println("User is signed user");
			 * 
			 * } Thread.sleep(500); while(true) {
			 * if(!continuebtn_acceptterms.getAttribute("src").contains("_black.png") &&
			 * continuebtn_acceptterms.isDisplayed()) { new
			 * Actions(driver).moveToElement(continuebtn_acceptterms).click().perform();
			 * flag = true; break; } } }
			 */
			//original code for accept terms without loop ends here
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean guestuser_continue()
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 4000);
			wait.until(ExpectedConditions.visibilityOf(Guest_useraccount_radiobtn));
			
			if(Guest_useraccount_radiobtn.isDisplayed())
			{				
				Guest_useraccount_radiobtn.click();
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

	public boolean Orderconfirmationclick()
	{
		try 
		{
			if(orderconfrmtn_btn.isDisplayed())
			{
				Thread.sleep(1000);
				/*
				 * new Actions(driver).moveToElement(orderconfrmtn_btn).click().perform();
				 * orderconfrmtn_btn.click(); flag= true;
				 */
				
				String orderconfirmationsrcstring = orderconfrmtn_btn.getAttribute("src");
				if(orderconfirmationsrcstring.contains("complete_order_now_green.png"))
				{
					orderconfrmtn_btn.click();
					flag= true;
				}	
				
				else
				{
					System.out.println("order confirmation button not found");
					flag=false;
				}		
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean logout_signedinuser()
	{
		String logoutstring = null;
		try 
		{
			/*
			 * driver.get(Property.getPropertyvalue("logouturl")); flag = true;
			 */
			logoutstring = Property.getPropertyvalue("url")+"/signout.aspx";
			driver.get(logoutstring);
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
	
