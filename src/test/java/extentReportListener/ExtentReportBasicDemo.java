package extentReportListener;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo 
{
	static WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public  ExtentTest test1;
	
	public static void main(String[] args)
	{
		try
		{
		// TODO Auto-generated method stub
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("clickoncategorylink", "this is end to end test for signed in user");
        
        System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		test1.log(Status.INFO, "test case started successfully");
		
		driver.get("http://inhousepharmacy.biz/");
		test1.pass("Navigated to website");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")).click();
		//test1.pass("clicked on login Buttn");
		//test1.addScreenCaptureFromPath("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Screenshots");
		extent.flush();
		
		ExtentTest test2= extent.createTest("test case 2", "description of test case 2");
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")).click();
		test2.pass("testcases2 is passed");
		test2.addScreenCaptureFromPath(".\\Screenshots\\loginpage.jpg");		
		extent.flush();
		
		System.out.println("Test case executed");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@BeforeTest
	public void extentreportsetup()
	{
         htmlReporter = new ExtentHtmlReporter("extentreports.html");		
		// create ExtentReports and attach reporter(s)
      extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
	}
	
	@Test
	public void extentreportexecute()
	{
		 test1 = extent.createTest("clickoncategorylink", "this is end to end test for signed in user");
	        
	        System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			test1.log(Status.INFO, "test case started successfully");
			
			driver.get("http://inhousepharmacy.biz/");
			test1.pass("Navigated to website");
			
			driver.manage().window().maximize();
			
			//driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")).click();
			//test1.pass("clicked on login Buttn");
			//test1.addScreenCaptureFromPath("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Screenshots");
			//extent.flush();
			
			ExtentTest test2= extent.createTest("test case 2", "description of test case 2");
			driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")).click();
			test2.pass("testcases2 is passed");
			//test2.addScreenCaptureFromPath("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Screenshots\\loginpage.jpg");			
			
			System.out.println("Test case executed");
	}
	
	
	
	@AfterTest
	public void extentreportteardown()
	{
		extent.flush();
		
	}


}
