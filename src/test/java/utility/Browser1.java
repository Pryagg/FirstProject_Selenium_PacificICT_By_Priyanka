package utility;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser1 extends Property
{
	WebDriver driver;
	public WebDriver getbrowser(String browsername)
	{
		try 
		{
			//chrome
			//IE
			//Firefox
			/*Properties prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\E2EProject\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			String browsername= prop.getProperty("browser");
			System.out.println(browsername);*/
			
			if(browsername.equalsIgnoreCase("chrome")||browsername.equalsIgnoreCase("GoogleChrome")||browsername.equalsIgnoreCase("Google"))
			{
				//execute in Chrome
				System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();					
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
}
