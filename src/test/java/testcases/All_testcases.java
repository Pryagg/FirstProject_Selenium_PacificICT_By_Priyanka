package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;


public class All_testcases extends Core
{
	boolean flag = false;
	
	//@Test
	//@Test(enabled=false)
	public void testcase_Signedinuserendtoendscenario()
	{
		try
		{		
			String methodvalue = DataDrivenTesting("Signedin User", "Execute");
	     	if (methodvalue.equalsIgnoreCase("yes")) 	 
	     	{
	     		// taking instance of driver, htmlReporter and extent from Core class
	     		SigninasLogegdinuser signedinuser= new SigninasLogegdinuser(driver, htmlReporter, extent);	
	     		signedinuser.clickoncategorylink();
	     		// Report3log("Clickoncategorylink", "Signed in user", "desc2"); 		
	     	}				
		}
		catch(Exception e)
		{
			System.out.println("Signed in user function does not executed successfully");
			e.printStackTrace();			
		}		
	}
	
	@Test
	public void testcase_Guestuser()
	{
		try 
		{ 
     	  String methodvalue = DataDrivenTesting("Guest User", "Execute");
			  if(methodvalue.equalsIgnoreCase("yes"))
			  {
				  GuestUserendtoendtransaction guestuser= new GuestUserendtoendtransaction(driver, htmlReporter, extent); 
				  guestuser.guestuserorder(); 
				  //Report3log("Guest User", "Guest user", "test case 2 ");				  
			  }		  
		} 
		catch(Exception e) 
		{
			  System.out.println("Guest user function does not executed successfully");
				e.printStackTrace();		  
		}		
	}	
	
   // @Test
	public void testcase_Jenkinstest()
	{
		try 
		{ 
			jenkinssmalltest jenkinstestclass= new jenkinssmalltest(driver, htmlReporter, extent);	
			jenkinstestclass.jenkinstest();
			
	        //String abc = System.getenv().get("abc");			
			//System.out.println("abc");
			
			/*
			 * String methodvalue = DataDrivenTesting("Guest User", "Execute");
			 * if(methodvalue.equalsIgnoreCase("yes")) { jenkinssmalltest jenkintest = new
			 * jenkinssmalltest(driver, htmlReporter, extent); jenkintest.jenkinstest();
			 * //Report3log("Guest User", "Guest user", "test case 2 "); }
			 */
		} 
		catch(Exception e) 
		{
			  System.out.println("jenkins test function does not executed successfully");
				e.printStackTrace();		  
		}		
	}	
	
	//@Test
	public void testcase_Jenkinsfailedtest()
	{
		try 
		{ 
			jenkinssmalltest jenkinstestclass= new jenkinssmalltest(driver, htmlReporter, extent);	
			jenkinstestclass.jenkinsfailedtest();			
	       
		} 
		catch(Exception e) 
		{
			  System.out.println("jenkins test function does not executed successfully");
				e.printStackTrace();		  
		}		
	}		
	
   //@Test
	public void takevaluefrommaven()
	{
		String valuefrommaven = System.getProperty("TestingUrl");
		System.out.println("value of Maven Project: " +  valuefrommaven);
	}
	
	  // @AfterSuite
		public void Reportteardown()
		{
				extent.flush();
		}
}



