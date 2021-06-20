package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class jenkinssmalltest extends Core
{
	 public jenkinssmalltest(WebDriver driver, ExtentReporter htmlReporter, ExtentReports extent) 
	  { // TODO Auto-generated constructor stub
	  this.driver=driver; 
	  this.htmlReporter = (ExtentHtmlReporter) htmlReporter;
	  this.extent = extent;	  
	  //PageFactory.initElements(driver, this);	  
	  }
	 
	 public void jenkinstest()
	 {
		 boolean flag = false;
			boolean result = false;
			try 
			{

				String methodvalue = "Yes";
				//String methodvalue = DataDrivenTesting("Guest User", "Execute");
				if (methodvalue.equalsIgnoreCase("yes")) 	 
		    	{
					 homepage hmepg = new homepage(driver,"Guest user", htmlReporter,extent);	
					// searchresultspage srchpg = new searchresultspage(driver, "Guest user");
					 
	                  //T1
					 // Logging Level 1 Report for signed In User
					 ExtentTest parenttest = Report_Level1("Jenkins Test", htmlReporter, extent);
					 flag = hmepg.SearchProduct("productname");	
					 if (flag)
					  {
					  Report_Level2("Search Product", "Enter the Product name into search box","Passed", htmlReporter, extent, parenttest); 
					  //Thread.sleep(1000); 
					  }
					  else 
					  {
						 Report_Level2("Search Product","Enter the Product name into serach box", "Failed", htmlReporter, extent, parenttest);
					  //Thread.sleep(1000); 
					  }
		    	}
			}
			
			catch(Exception e)
			{
				System.out.println("not executed successfully");
			}
		 
		 
		 
	 }
	 
	 
	 public void jenkinsfailedtest()
	 {
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
					 
	                  //T1
					 // Logging Level 1 Report for signed In User
					 ExtentTest parenttest = Report_Level1("Jenkins Test failed", htmlReporter, extent);
					 driver.findElement(By.xpath("//input[contains(@id,'tsfSearch_Int')]")).sendKeys("Buscopan");
					 
					 flag = false;					 
					
					 if (flag)
					  {
					  Report_Level2("Search Product", "Enter the Product name into serach box","Passed", htmlReporter, extent, parenttest); 
					  //Thread.sleep(1000); 
					  }
					  
		    	}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("not executed successfully");
				Report_Level2("Search Product","Enter the Product name into serach box", "Failed", htmlReporter, extent, parenttest);
			}
		 
		 
		 
	 }
	 

}
