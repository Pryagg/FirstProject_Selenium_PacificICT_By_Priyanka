package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailedPage
{
	WebDriver driver;
	
	public ProductDetailedPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"AddToCartButton_179_502\"]")
	WebElement AddToCart; 
	
	@FindBy(xpath="//*[@id=\"ctl00_PageContent_pnlContent\"]/div[2]/div[1]/div/div[3]/div[2]/div[1]/span[2]/span")
	WebElement ProductPrice;
	
	@FindBy(xpath="//*[@id=\"SubName\"]/a/b[1]")
	WebElement category1link ;	
	
	public void AddToCart()
	{
		
	}
	
	public String GetProductPrice()
	{
		String price = null;
		try
		{
			price = ProductPrice.getText();
		return ProductPrice.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return price;
		
	}
	
	
	
	public void category1linkclick()
	{
		try
		{
			Thread.sleep(50);
			category1link.click();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
