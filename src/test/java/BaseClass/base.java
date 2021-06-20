package BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class base 
{
	WebDriver driver;

	
	public static  String getPropertyvalue(String name)
	{
		String value =null;		
		try
		{			
			FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(name);	
					
		}		
		catch(Exception e)
		{
			e.printStackTrace();			
		}		
		return value;
	}
	

	public WebDriver getbrowser(String browsername)
	{
		try 
		{			
			if(browsername.equalsIgnoreCase("chrome")||browsername.equalsIgnoreCase("GoogleChrome")||browsername.equalsIgnoreCase("Google"))
			{
				
				System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");	
				ChromeOptions options = new ChromeOptions();
				options.addArguments("window-size=1920,1400");
				options.addArguments("headless"); 
				
				String Devurl = System.getProperty("devurl");
				if (Devurl != null) 
				{
					driver = new ChromeDriver(options);
					//driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
					
				}
				
				else
				{
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					//driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
					
				}
				
				
				
				// driver = new ChromeDriver();
				//  driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
				 
				
				//execute in Chrome
				
				
				
				 
				 
				
				 
				
				  			
			}			
			else if(browsername.equals("firefox"))
			{
				System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\firefoxdriver.exe");
				driver = new FirefoxDriver();				
			}			
			else if(browsername.equals("IE"))
			{
				System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\geckodriver.exe");
				driver = new InternetExplorerDriver();					
			}
			//to manage out the time to load image and graphics
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;		
	}	
	
	public void gettext()
	{
		
	}
	
	

	
}
