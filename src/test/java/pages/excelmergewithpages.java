package pages;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Core;

public class excelmergewithpages extends Core
{ 	 
	private WebDriver driver;

	
	
	  public excelmergewithpages() 
	  { this.driver=driver;	  
	  PageFactory.initElements(driver, this); 
	  }
	  
	 
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")
	WebElement Loginbtn;
	
	@FindBy(id="ctl00_PageContent_ctl00_ctrlLogin_UserName")
	WebElement useremail;
	
	@FindBy(id="ctl00_PageContent_ctl00_ctrlLogin_Password")
	WebElement pswrd;
	
	@FindBy(xpath="//*[@id=\"ctl00_PageContent_ctl00_ctrlLogin_LoginButton\"]" )
	WebElement Login;
	

	
	
	@Test	
	public void Loginn()
	{
		try
		{			
			//test1 = extent.createTest("Login", "test case 1");
			
			//excelmergewithpages exc = PageFactory.initElements(driver, excelmergewithpages.class);
			
			String methodvalue = DataDrivenTesting("usertype");
			 if (methodvalue.equalsIgnoreCase("signedin user")) 
			 {
				
				  Loginbtn.click(); 
				  useremail.sendKeys(DataDrivenTesting("username"));
				  pswrd.sendKeys(DataDrivenTesting("password")); Thread.sleep(20);
				  Login.click();
				 
				 
				// driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[9]/div[1]/header/div[9]/div[2]/div[2]/a[1]")).click();
				 //driver.findElement(By.xpath("//*[@id=\"ctl00_PageContent_ctl00_ctrlLogin_UserName\"]")).sendKeys(DataDrivenTesting("username"));
				 
					Thread.sleep(1000);						
					//Report1og("testcase1", "end to end test case", "Logged in successfully",htmlReporter, extent);
			 }			
		}
		catch(Exception e)
		{			
			e.printStackTrace();
		}		
	}	
	
	
	
	
	public String DataDrivenTesting(String methodname) 
	{
		String functionvalue = null;
		try {
			FileInputStream fis = new FileInputStream(".\\resources\\DatadriventestingwithSelenium.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetcount = workbook.getNumberOfSheets();
			System.out.println("Number of sheets: " + sheetcount);
			for (int i = 0; i < sheetcount; i++) {

				String sheetname = workbook.getSheetName(i);
				// System.out.println(sheetname);

				
				//XSSFSheet sheet = workbook.getSheetAt(i);
				/*
				 * XSSFSheet sheet = workbook.getSheet("testdata");
				 * int rowcount = sheet.getLastRowNum(); for(int j=0;j<rowcount;j++) { Row row =
				 * sheet.getRow(j); for(int k=0;k<row.getLastCellNum();k++) {
				 * System.out.println("row: " + j + " col: " + k + " value is: "+
				 * row.getCell(k).getStringCellValue()); } }
				 */
				
				  if (sheetname.equalsIgnoreCase("sample")) 
				  {
				  
				  XSSFSheet sheet = workbook.getSheetAt(i); 
					/*
					 * Iterator<Row> rows = sheet.iterator(); Row firstrow = rows.next();
					 * Iterator<Cell> cells= firstrow.cellIterator();
					 */
				  
				 // XSSFSheet sheet = workbook.getSheetAt(i);
				  
				  int rowcount = sheet.getLastRowNum(); 
				  for(int j=0;j<=rowcount;j++) 
				  {
					  Row row =  sheet.getRow(j); 
					  String functionname = row.getCell(0).getStringCellValue();
					  
					  
					  //System.out.println("functionName: " + functionname + " Functionvalue: " + functionvalue);
					  
					  
						/*
						 * for(int k=0;k<row.getLastCellNum();k++) { System.out.println("row: " + j +
						 * " col: " + k + " value is: "+ row.getCell(k).getStringCellValue()); }
						 * 
						 */
					  
					  if (functionname.equalsIgnoreCase(methodname))
					  {
						  functionvalue = row.getCell(1).getStringCellValue();
					//	  System.out.println("functionName: " + functionname + " Functionvalue: " + functionvalue);						  
						  
					  }
				  }
				  }
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return functionvalue;
	}
}
