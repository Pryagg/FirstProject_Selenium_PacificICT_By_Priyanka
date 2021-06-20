/*
 * package pages;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.FindBy; import org.testng.annotations.Test;
 * 
 * import A_Testcode.testcode;
 * 
 * public class A_Test {
 * 
 * @FindBy(xpath = "//*[@id=\"CategoryNav_25\"]/a") WebElement generallink;
 * 
 * @FindBy(xpath = "//*[@id=\"SubName\"]//a//b)[1]") WebElement productlink;
 * 
 * @FindBy(xpath = "//*[@id='ctl00_ctl13_tsfSearch_Input']") WebElement
 * searchbox;
 * 
 * @FindBy(xpath = "//*[@id='ctl00_ctl13_tsfSearch']/span/button/span")
 * WebElement SearchButton;
 * 
 * WebDriver driver;
 * 
 * @Test public void OpenBrowser() { System.setProperty(
 * "webdriver.chrome.driver","C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\resources\\drivers\\chromedriver.exe"
 * ); driver = new ChromeDriver(); driver.get("http://inhousepharmacy.biz/");
 * driver.manage().window().maximize(); driver.close(); driver.quit();
 * 
 * 
 * }
 * 
 * public void Searchp() { searchbox.sendKeys("Finpecia"); SearchButton.click();
 * }
 * 
 * }
 */
