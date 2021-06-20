package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class paymentpage 
{
	WebDriver driver;
	WebDriverWait wait;
	boolean flag = false;
	
	public paymentpage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@id,'rbMethodSelectorPaperCheck')]")
	WebElement paymentoption_Papercheck;
	
	
	@FindBy(xpath="//input[contains(@id,'rbMethodSelectorECheck')]")
	WebElement paymentoption_Echeck;
	
	@FindBy(xpath="//input[contains(@id,'rbMethodSelectorCheckByMail')]")
	WebElement paymentoption_faxdetails;
	
	
	@FindBy(xpath="//input[contains(@id,'ibPaymentMethod_PaperCheck')][@alt=\"CONTINUE\"]")
	WebElement continuebtn_papercheck;
	
	@FindBy(xpath="//input[contains(@id,'ibPaymentMethod_ECheck')][@alt=\"CONTINUE\"]")
	WebElement continuebtn_Echeck;
	
	@FindBy(xpath="//input[contains(@id,'ibPaymentMethod_CheckByMail')][@alt=\"CONTINUE\"]")
	WebElement continuebtn_faxdetails;	
	
	@FindBy(xpath="//input[contains(@name,'prescription')][@value=\"3\"]")
	//WebElement prescriptionbtn_email;
	List<WebElement> prescriptionbtn_email;
	
	
	@FindBy(xpath="//input[contains(@name,'prescription')][@value=\"2\"]")
	//WebElement prescriptionbtn_email;
	List<WebElement> prescriptionbtn_fax;
	
	@FindBy(xpath="//input[contains(@name,'prescription')][@value=\"1\"]")
	//WebElement prescriptionbtn_email;
	List<WebElement> prescriptionbtn_doctorfax;
	
	@FindBy(xpath ="//input[contains(@name,'ibPrescriptionNext')][@alt=\"CONTINUE\"]")
	WebElement continuebtn_prescription;
	
	@FindBy(xpath="//*[@id=\"ibContinueSubscription\"]")
	WebElement keep_in_touch_method_continue_btn;
	
	public boolean selectpaymentmethod()
	{
		try
		{
			 wait = new WebDriverWait(driver, 2000);
				//wait.until(ExpectedConditions.visibilityOf(paymentoption_Papercheck));
			Thread.sleep(5000);
				
			if (paymentoption_Papercheck.isDisplayed())
			{
				paymentoption_Papercheck.click();
				continuebtn_papercheck.click();
				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"aspnetForm\"]/div[8]/div[1]/div[7]/div[4]/h2[2]")));
				//Assert.assertTrue(myaccount.isDisplayed());
				flag = true;
			}
			else
			{
				System.out.println("Payment method is not displayed");
				flag = false;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean selectprescriptionmethod()
	{
		
		 wait = new WebDriverWait(driver, 2000);
	
		// wait.until(ExpectedConditions.visibilityOf(prescriptionbtn_email.get(0))); 		
		try
		{				
			 Thread.sleep(5000);
			//if(prescriptionbtn_email.isDisplayed())
			if(prescriptionbtn_email.size()>0)
			{	
				Thread.sleep(100);
				prescriptionbtn_email.get(0).click();
				Thread.sleep(500);				
				while (true )
				   {					 
					 if(!continuebtn_prescription.getAttribute("src").contains("_black.png"))
					 {
						 continuebtn_prescription.click();	
						 Thread.sleep(2000);
						 break;
					 }					 
				   }				
			  //	continuebtn_prescription.click();
				//Assert.assertTrue(myaccount.isDisplayed());	
				flag = true;
			}							
			else 
			{
				System.out.println("Prescription method not found");
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
