package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.utils.FileUtil;

import utility.Property;


public class TakeScreenshots 
{
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;


	@Test
	public void PassFailscreenshots() throws Exception
	{
		System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get(Property.getPropertyvalue("url"));
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File(".//Screenshots/webbrowser.png"));		
	
		
		//FileUtils.copyFile(source, ".//Screenshots/webbrowser.png");
		System.out.println("screenshot taken");
		
		driver.quit();

		
		
		
	}
	
	public String Capturescreenshots(String screenshotname)
	{
		String path = null;
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			//path = ".//Results//Screenshots/"+ screenshotname + System.currentTimeMillis() +".png" ;
			path = ".//Results//Screenshots/"+ screenshotname +".png" ;			
			File destination = new File(path);						
			FileUtils.copyFile(source, destination);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}	
		return path ;
	}
	
	
	@BeforeTest
	public void Init()
	{
		extent = new ExtentReports();
	}
	
	@Test
	public void capturescreenshotinReport()
	{
		//starting point of test, create the name
		test = extent.createTest("capture screenshot");
		
		// code to open the browser and take url
		
		System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get(Property.getPropertyvalue("url"));		
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshootpath = Capturescreenshots("sample screenshot");
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screenshootpath));
		
			
		}
		
	}

}

