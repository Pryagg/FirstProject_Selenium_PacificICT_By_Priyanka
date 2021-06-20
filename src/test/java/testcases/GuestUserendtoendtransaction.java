package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;
import pages.BillingPage;
import pages.EmailEnterPage;
import pages.homepage;
import pages.orderconfirmationpage;
import pages.paymentpage;
import pages.searchresultspage;
import pages.shippingPage;

public class GuestUserendtoendtransaction extends Core
{
	 public GuestUserendtoendtransaction(WebDriver driver, ExtentReporter htmlReporter, ExtentReports extent) 
	  { // TODO Auto-generated constructor stub
	  this.driver=driver; 
	  this.htmlReporter = (ExtentHtmlReporter) htmlReporter;
	  this.extent = extent;	  
	  //PageFactory.initElements(driver, this);	  
	  }
	 
	 
	//@Test
	public void guestuserorder()
	{
		//boolean result = false;
		boolean flag = false;
		boolean result = false;
		try
		{
			String methodvalue = "Yes";
			//String methodvalue = DataDrivenTesting("Guest User", "Execute");
			if (methodvalue.equalsIgnoreCase("yes")) 	 
	    	{
				 homepage hmepg = new homepage(driver,"Guest user", htmlReporter,extent);	
				 searchresultspage srchpg = new searchresultspage(driver, "Guest user");
				 shippingPage shippg = new shippingPage(driver,"Guest user" );		
				 BillingPage billingpg = new BillingPage(driver,"Guest user" );	
				 paymentpage paypg = new paymentpage(driver);
				 EmailEnterPage emailpg = new EmailEnterPage(driver,"Guest user", htmlReporter, extent);
				 orderconfirmationpage orpg = new orderconfirmationpage(driver);		
				 
                  //T1
				 // Logging Level 1 Report for signed In User
				 ExtentTest parenttest = Report_Level1("Guest User", htmlReporter, extent);
				 flag = hmepg.SearchProduct("productname");	
				 if (flag)
				  {
				  Report_Level2("Search Product", "1_SearchProduct","Passed", htmlReporter, extent, parenttest); 
				 // Capturescreenshots("SearchProductPage_Passed");
				  //Thread.sleep(1000); 
				  }
				  else 
				  {
					 Report_Level2("Search Product","1_Enter the Product name into serach box", "Failed", htmlReporter, extent, parenttest);
				  //Thread.sleep(1000); 
					  //Capturescreenshots("SearchProductPage_Failed");
				  }
				 
				 				  
				 //T1
				 // Click on the first product appearing in the list 
				
				  flag = srchpg.clickOnfirstproduct();
				  if (flag) 
				  {
				    Report_Level2("Click on first product", "2_ClickOnfirstproduct","Passed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Click on first product", "2_ClickOnfirstproduct", "Failed", htmlReporter, extent, parenttest);
				  //Thread.sleep(1000); 
				  }
				  
				 //T3 - Add the product to the cart
				  flag = srchpg.addtocart(); 
				  if (flag) 
				  {
				    Report_Level2("AddToCart", "3_addtocart", "Passed", htmlReporter, extent, parenttest); 
				 // Thread.sleep(1000); 			
				  }
				  else
				  {
				    Report_Level2("AddToCart", "3_addtocart", "Failed", htmlReporter, extent, parenttest); 				 // Thread.sleep(1000); 
				
				  } 
				  
				  // T5- click on Proceed to Purchase Button 
				  flag =  srchpg.proceedtopurchase();
				  if(flag) 
				  { 
					  Report_Level2("Proceed To Purchase","4_Proceedtopurchase", "Passed", htmlReporter, extent, parenttest);
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				     Report_Level2("Proceed To Purchase", "4_Proceedtopurchase", "Failed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }				  
				  
				// T6- Enter the email for guest user 
				  flag = emailpg.EnterEmail(); 
				  if(flag) 
				  { 
					  Report_Level2("Enteremail for GuestUser","5_EnterEmail", "Passed", htmlReporter, extent, parenttest);
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				     Report_Level2("Enteremail for GuestUser","5_EnterEmail", "Failed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }				
				  
				  //Thread.sleep(500);
				  
				// T7- Enter the shipping address for Guest User
				  flag =  shippg.ShippingAddressEnter(); // Thread.sleep(8000);
				 if(flag) 
				  { 
					  Report_Level2("Enter Shipping Address","6_ShippingAddressEnter", "Passed", htmlReporter, extent, parenttest);
				 // Thread.sleep(1000); 
				  }
				  else
				  {
				     Report_Level2("Enter Shipping Address","6_ShippingAddressEnter", "Failed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }				
				  
				 // T8- Select the Shipping method
				 flag = shippg.selectshippingmethod(); 
				  if (flag) 
				  {
				    Report_Level2("Select Shipping Method", "7_Selectshippingmethod", "Passed", htmlReporter, extent, parenttest); 
				 // Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Shipping Method", "7_Selectshippingmethod", "Failed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  } 
				  
				  
				  //T9 Select Billing Method
				  flag = billingpg.selectbillingmethod();	 				  
				  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS); //
				  Thread.sleep(5000); 
				  if (flag) 
				  {
				    Report_Level2("Select Billing Method", "8_Selectbillingmethod", "Passed", htmlReporter, extent, parenttest); 
				 // Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Billing Method", "8_Selectbillingmethod", "Failed", htmlReporter, extent, parenttest); 
				//  Thread.sleep(1000); 
				  } 			  
				  
				  
				  
				  //T10- Select the Payment method
				  flag= paypg.selectpaymentmethod();				  
				  if (flag) 
				  {
 				    Report_Level2("Select Payment Method", "9_Selectpaymentmethod", "Passed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(5000); 
				  }
				  else
				  {
				    Report_Level2("Select Payment Method", "9_Selectpaymentmethod", "Failed", htmlReporter, extent, parenttest); 
				//  Thread.sleep(5000); 
				  } 
				  
				//T11 - Select the Prescription Method
				  flag =  paypg.selectprescriptionmethod();
				  if (flag) 
				  {
				    Report_Level2("Select Prescription Method", "10_Selectprescriptionmethod", "Passed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Select Prescription Method", "10_Selectprescriptionmethod", "Failed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  } 
				  
				  //T12 Keep in Touch Method
				  flag =  orpg.keepintouchmethod();
				 if (flag) 
				  {					 
				    Report_Level2("Keep in touch Method", "11_keepintouchmethod", "Passed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Keep in touch Method", "11_keepintouchmethod", "Failed", htmlReporter, extent, parenttest); 
				// Thread.sleep(1000); 
				  } 
				  
				  
				  //T13- Accept the Terms 
				 flag= orpg.acceptterms(); 
				  if (flag) 
				  {
				    Report_Level2("Accept terms", "12_acceptterms", "Passed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("Accept terms", "12_acceptterms", "Failed", htmlReporter, extent, parenttest); 
				 // Thread.sleep(1000); 
				  } 
				  
				  //T14 Guest user continue
				  flag= orpg.guestuser_continue(); 
				  if (flag) 
				  {
				    Report_Level2("continue as a guest user", "13_guestuser_continue", "Passed", htmlReporter, extent, parenttest); 
				  //Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("continue as a guest user", "13_guestuser_continue", "Failed", htmlReporter, extent, parenttest); 
				  Thread.sleep(1000); 
				  } 
				  
				  //T15- Click on Order Confirmation Link
				  flag = orpg.Orderconfirmationclick();
				  if (flag) 
				  {
				    Report_Level2("OrderConfirmationclick", "14_Orderconfirmationclick", "Passed", htmlReporter, extent, parenttest); 
				    //result = true;
				//  Thread.sleep(1000); 
				  }
				  else
				  {
				    Report_Level2("OrderConfirmationclick", "14_Orderconfirmationclick", "Failed", htmlReporter, extent, parenttest); 
				 // Thread.sleep(1000); 
				  } 			
			      
				//  driver.close();
				 // driver.quit();  
	    	}
		}
			catch(Exception e)
			{
				e.printStackTrace();
				 //result = false;
			} 		
		}
}
