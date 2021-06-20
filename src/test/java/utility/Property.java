package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property 
{
	public static  String getPropertyvalue(String name)
	{
		String value =null;
		
		try
		{			
			//FileInputStream fis = new FileInputStream("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\E2EProject\\src\\main\\java\\resources\\data.properties");
			//FileInputStream fis = new FileInputStream(".\\src\\test\\java\\resources\\config.properties");
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
}
