
  package A_Testcode;
  
  import org.testng.annotations.Test; import org.openqa.selenium.By; import
  org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
  org.openqa.selenium.chrome.ChromeDriver; import
  org.openqa.selenium.support.FindBy; import
  org.openqa.selenium.support.PageFactory; import org.testng.annotations.Test;
  
  public class testcode {
  
  
  
  
  
	/*
	 * @FindBy(xpath = "//*[@id=\"CategoryNav_25\"]/a") WebElement generallink;
	 * 
	 * @FindBy(xpath = "//*[@id=\"SubName\"]//a//b)[1]") WebElement productlink;
	 * 
	 * @FindBy(xpath = "//*[@id='ctl00_ctl13_tsfSearch_Input']") WebElement
	 * searchbox;
	 * 
	 * @FindBy(xpath = "//*[@id='ctl00_ctl13_tsfSearch']/span/button/span")
	 * WebElement SearchButton;
	 */
  
  

  
  
  public static void main(String[] args)
  
  { 
  
  
  try {
  
  System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe"); 
  WebDriver driver = new ChromeDriver();
  driver.get("http://inhousepharmacy.biz/");
  driver.manage().window().maximize(); //search for a product in search box
  driver.findElement(By.xpath("//*[@id=\"ctl00_ctl13_tsfSearch_Input\"]")).sendKeys("Finpecia"); //SearchButton.click();  
  
  } 
  
  catch (Exception e) 
  {
	  e.printStackTrace(); 
  }
  
  
  }
  
  
  
  @Test 
  public void Searchbox()
{ 
	  try 
	  {  
	  System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();     
  
      driver.get("http://inhousepharmacy.biz/"); 
      testcode tc = new testcode();  
      driver.manage().window().maximize(); //search for a product in search box
      driver.findElement(By.xpath("//*[@id=\"ctl00_ctl13_tsfSearch_Input\"]")).
      sendKeys("Finpecia"); //tc.searchbox.sendKeys("Finpecia");
      //tc.SearchButton.click();  
  } 
	  catch(Exception e) 
	  { 
		  e.printStackTrace(); 
	   } 
}
  
  
  
  @Test public void search() {
  
  
  try 
  {
	  System.setProperty("webdriver.chrome.driver",".\\resources\\drivers\\chromedriver.exe"); 
	  WebDriver driver = new ChromeDriver();  
	  driver.get("http://inhousepharmacy.biz/");
	  driver.manage().window().maximize(); 
	  System.out.println(driver.getTitle());
	  Thread.sleep(1000);  
      //By clicking on General link and click on sub link
	  driver.findElement(By.xpath("//*[@id=\"CategoryNav_25\"]/a")).click();
	  driver.findElement(By.xpath("( //*[@id=\"SubName\"]//a//b)[1]")).click(); 
	  //search for a product in search box
	  driver.findElement(By.xpath("//*[@id=\"ctl00_ctl13_tsfSearch_Input\"]")).sendKeys("Finpecia"); 
	  //clcik on search button 
	  driver.findElement(By.xpath(  "//*[@id='ctl00_ctl13_tsfSearch']/span/button/span")).click();
	  Thread.sleep(2000);
	 // click on the first link
	  driver.findElement(By.xpath("//*[@id='ctl00_PageContent_pnlContent']/div[1]/div[1]/div[1]/div[2]")).click();  
  
  } 
  
  catch (Exception e)
  {
	  e.printStackTrace();
  }
 }
  
  
  }
 
