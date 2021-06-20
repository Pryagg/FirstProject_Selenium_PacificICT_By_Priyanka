package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;




public  class testextent extends Core
{
	//@Test
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
	
	//@Test
	public void testreport3()
	{
		System.out.println("executed successfuly");
		      Assert.assertTrue(1>0);
			//Report1og("testcase2", "end to end test case", "Logged in successfully");
		
	}
	
	

}
