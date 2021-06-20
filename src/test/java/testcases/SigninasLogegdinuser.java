package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.base;
import core.Core;
import pages.homepage;
import pages.orderconfirmationpage;
import pages.paymentpage;
import pages.searchresultspage;
import pages.shippingPage;
import utility.Property;

public class SigninasLogegdinuser extends Core
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentReports extentrep;
	public ExtentTest test1;
	public ExtentTest parenttest;
	
	String usrnm;
	String pswrd = null;	
	
	
	
	  public SigninasLogegdinuser(WebDriver driver, ExtentReporter htmlReporter, ExtentReports extent) 
	  { // TODO Auto-generated constructor stub
	  this.driver=driver; 
	  this.htmlReporter = (ExtentHtmlReporter) htmlReporter;
	  this.extent = extent;	  
	  //PageFactory.initElements(driver, this);	  	 
	  }
	 
	
	//@Test
	public void clickoncategorylink()
	{
		Boolean flag = true;
		//driver =getbrowser(getPropertyvalue("browser"));
		try 
		{			
			 
			String methodvalue = "Yes";
			//String methodvalue = DataDrivenTesting("Signedin User", "Execute");
	     	if (methodvalue.equalsIgnoreCase("yes")) 	 
	    	{
	     		homepage hmepg = new homepage(driver,"signedin user", htmlReporter,extent);	
				 searchresultspage srchpg = new searchresultspage(driver, "Guest user");
				 shippingPage shippg = new shippingPage(driver, "Guest user");			
				 paymentpage paypg = new paymentpage(driver);
				 orderconfirmationpage orpg = new orderconfirmationpage(driver);				 
				
				 
				 // Logging Level 1 Report for signed In User
				 ExtentTest parenttest = Report_Level1("signed in user", htmlReporter, extent);
				 
				 JavascriptExecutor js = (JavascriptExecutor) driver ;
				  js.executeScript("window.scrollBy(0,200)");
			
				  String Devurl = System.getProperty("devurl");
				  String Navigateurl;
					if (Devurl != null) 
					{
						Navigateurl = Devurl;
					}
					else 
					{
						Navigateurl = Property.getPropertyvalue("url");
					}
				  
				  
				 Report_Level2("Homepage URL", Navigateurl , "Passed", htmlReporter, extent, parenttest);
				 
				 // T1- Login to the Home Page 
				 //Login function and taking usename and password from config file
				 flag = hmepg.Login("username", "password");				
				 if (flag)
				 {
					 Report_Level2("Homepage Login", "1_Login to the HomePage", "Passed", htmlReporter, extent, parenttest);
					 Thread.sleep(1000);
				 }
				 else
				 {
					 Report_Level2("Homepage Login", "1_Login to the HomePage", "Failed", htmlReporter, extent, parenttest);
					 Thread.sleep(1000);
				 }
				// Thread.sleep(1000);
				 
				 // T2- Searching for the product name and product name is populating from the data sheet 
				 flag= hmepg.SearchProduct("productname");	
				 
				 if (flag) 
				  {
				  Report_Level2("Search Product", "2_Enter the Product name into serach box","Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
					 Report_Level2("Search Product","2_Enter the Product name into serach box", "Failed", htmlReporter, extent, parenttest);
				  Thread.sleep(1000); 
				  }
				 
				 
				//search for the product , fetching productname from the config file	
				 //Report2log("Clickoncategorylink", "Signed in user", "desc2");
				 
				// Report3log("Clickoncategorylink", "Signed in user", "desc2");
					
				
				 //T3 -Click on the first product appearing in the list 
				 flag =   srchpg.clickOnfirstproduct();
				  if (flag) 
				  {
				    Report_Level2("Click on first product", "3_First product would be clicked","Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Click on first product", "3_First product would be clicked", "Failed", htmlReporter, extent, parenttest);
				  Thread.sleep(1000); 
				  }
				  
				  //T4 - Add the product to the cart
				  flag = srchpg.addtocart(); 
				  if (flag) 
				  {
				    Report_Level2("AddToCart", "4_Add Product to the Cart", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("AddToCart", "4_Add Product to the Cart", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				  // T5- click on Proceed to Purchase Button 
				  flag = srchpg.proceedtopurchase();
				  if(flag) 
				  { 
					  Report_Level2("Proceed To Purchase","5_Click on Proceed To Purchase  Button ", "Passed", htmlReporter, extent, parenttest);
				  Thread.sleep(1000); 
				  }
				  else
				  {
				     Report_Level2("Proceed To Purchase", "5_Click on Proceed To Purchase  Button ", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  
				 	  
				  // click on change and complete the shipping address as otherwise it would not capture the delievery instructions 
				  
				  
				  
				  // T6- Select the Shipping method
				  flag = shippg.selectshippingmethod();
				  if (flag) 
				  {
 				    Report_Level2("Select Shipping Method", "6_Select the Shipping Method", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Shipping Method", "6_Select the Shipping Method", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				 
				  
				  //T7- Select the Payment method
				  flag = paypg.selectpaymentmethod();
				  if (flag) 
				  {
				    Report_Level2("Select Payment Method", "7_Payment method is selected", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Payment Method", "7_Payment method is selected", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				 
				  
				  //T8 - Select the Prescription Method
				  flag =  paypg.selectprescriptionmethod(); 
				 if (flag) 
				  {
				    Report_Level2("Select Prescription Method", "8_Prescription Method is selected", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Prescription Method", "8_Prescription Method is selected", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				  
				  //T9- Accept the Terms 
				 flag =   orpg.acceptterms();
				  if (flag) 
				  {
				    Report_Level2("Accept terms", "9_Click on Accept Terms", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Accept terms", "9_Click on Accept Terms", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				  //T10- Click on Order Confirmation Link
				  flag=  orpg.Orderconfirmationclick();
				  if (flag) 
				  {
				    Report_Level2("OrderConfirmationclick", "10_Click on OrderconfirmatrionLink", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("OrderConfirmationclick", "10_Click on OrderconfirmatrionLink", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				  //T-11 Logout from the Signed in User
				  flag= orpg.logout_signedinuser();		
				  if (flag) 
				  {
				    Report_Level2("Logout", "11_Signed in user would be logged out", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Logout", "11_Signed in user would be logged out", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
					 					 		 	
	     	}
	     	
	     	else
	     	{
	     		System.out.println("excute says No");
	     	}
			 		 			
		}			
		catch(Exception e)
		{
			e.printStackTrace();
		}	
    }	
	
//	@Test
		public void testreport()
		{
			System.out.println("executed successfuly");
			      Assert.assertTrue(1>0);
				//Report1og("testcase1", "end to end test case", "Logged in successfully");
			
		}
		
		//@Test
		public void testreport2()
		{
			System.out.println("executed successfuly");
			      Assert.assertTrue(1>0);
				//Report1og("testcase2", "end to end test case", "Logged in successfully");
			
		}
}
