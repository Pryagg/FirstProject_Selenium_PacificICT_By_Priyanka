package core;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.maven.mercury.spi.http.client.deploy.FilePutExchange;
import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.plexus.component.annotations.Component;
import org.mortbay.jetty.client.webdav.WebdavListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.ScreenCapture;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.xml.bind.v2.runtime.output.Encoded;

import BaseClass.base;
import jdk.jfr.events.FileWriteEvent;
import utility.Browser1;
import utility.Property;

public class Core extends base {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentReports extentrep;
	public ExtentTest test1;
	public ExtentTest parenttest;
	public ExtentTest childtest;
	public WebDriverWait wait;
	
	
	

	// @BeforeSuite
	// @BeforeTest
	@BeforeMethod
	public void init() {
		try 
		{
 			String browsername = getPropertyvalue("browser");
			driver = getbrowser(browsername); // take the browser name from config file and open the respective browser
			//browserSettings();
			deletecookies(); // It will delete all the cookies
			navigate(); // Navigate to the URL taken from config file
			browserSettings(); // maximise the browser

		} 
		catch (Exception e) 
		{
			System.err.println("got error while initilaising");
		}
	}

	public void deletecookies() {
		try {
			driver.manage().deleteAllCookies();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigate() {
		try {
			// driver.get(Property.getPropertyvalue("url"));
			// devurl is coming from Jenkins

			String Devurl = System.getProperty("devurl");
			if (Devurl != null) {
				// if Jenkins devurl is not present then it would take the value from config file
				driver.get(Devurl);
				Thread.sleep(1000);
			} 
			else 
			{
				driver.get(Property.getPropertyvalue("url"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void browserSettings() 
	{		
		  try {
			  
			  //driver.manage().window().maximize();
			  //driver.manage().window().fullscreen();
			  Dimension initial_size = driver.manage().window().getSize();
			  int ini_height = initial_size.getHeight();
			  int ini_width = initial_size.getWidth();
			  System.out.println(" initial height: " + ini_height + "initial width:  " + ini_width);
			
			/*
			 * Dimension d = new Dimension(3840,2400); 
			 * driver.manage().window().setSize(d);			 */	 
		  
		  //WebElement cookieclsebtn = driver.findElement(By.xpath("//*[@class=\"cookie_buttons\"]/span[2]"));
		  WebElement cookieclsebtn =driver.findElement(By.xpath("//*[@id=\"btnClose\"]"));		  
		  
		  if(cookieclsebtn.isDisplayed()) 
		  {
			  if(cookieclsebtn.getText().equalsIgnoreCase("CLOSE")) 
			  {
			  cookieclsebtn.click(); 
			  }	  	  
		  }  
		  
		  }
		  catch (Exception e) 
		  {
			  e.printStackTrace(); 
		}		 
	}

	public void cookiebtndelete() {
		try {
			WebElement cookieclsebtn = driver.findElement(By.xpath("//*[@class=\"cookie_buttons\"]/span[2]"));
			if (cookieclsebtn.isDisplayed()) 
			{
				cookieclsebtn.click();
			} 
			else 
			{
				System.out.println("no cookie button");
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}
	}

	@BeforeSuite
	public ExtentReports extentinstance() {

		// absolute path for the reports
		String Path = "C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Results\\extentReports.html";
		// String Path = ".\\Results\\extentReports.html";
		// String Path = System.getProperty("user.dir")+
		// "\\Results\\extentReports.html";
		htmlReporter = new ExtentHtmlReporter(Path);
		// extent = new ExtentReports();
		extent = new ExtentReports();
		// create ExtentReports and attach reporter(s)
		// extent.attachReporter(htmlReporter); //
		// extent.setSystemInfo("Tester Name", "Priyanka A");
		return extent;
	}

	public ExtentTest Report_Level1(String parenttestname, ExtentReporter htmlReporter, ExtentReports extent) 
	{
		extent.attachReporter(htmlReporter);
		parenttest = extent.createTest(parenttestname);
		// ScreenCapture("Testinggoogle",)
		return parenttest;
	}
	
	public void Report_Level2(String testname, String screenshotname, String desc2, ExtentReporter htmlReporter,ExtentReports extent, ExtentTest parenttest) 
	{
		String screenshotpath;
		FileOutputStream outputstream;
		
		try 
		{			
			// create ExtentReports and attach reporter(s)
			extent.attachReporter(htmlReporter); //
			// test1 = extent.createTest("parenttest", desc1);
			childtest = parenttest.createNode(testname);
			// test1.log(Status.INFO, desc2);
			childtest.log(Status.INFO, desc2);
			if (desc2 == "Passed") {
				// test1.pass("testcase executed successfully");
				// childtest.pass("testcase executed successfully");
				childtest.log(Status.PASS, MarkupHelper.createLabel("testcaseexecuted successfully " , ExtentColor.BLUE));

				// additional code to attach screenshot in the report
				//Thread.sleep(2000);

				// Uncomment the code to attach screenshots in reports

				screenshotpath = Capturescreenshots(screenshotname + "_Passed");
				// to encode the imahe by base64

				//Thread.sleep(1000);
				String encodestream = Encodeimage(screenshotpath);
				Thread.sleep(1000); // to encode the image by base64 Thread.sleep(1000);
				//System.out.println("scrheight: " + ini_height + "scrwidth: "+ ini_width);
				childtest.log(Status.PASS, "screenshot below for " + screenshotname	+ ": <img style=\"width:800px; height:400px;\"  src=\"" + encodestream + "\" />");

				// if path is absolute(screenshotpath)
				// childtest.log(Status.PASS, "screenshot below for " + screenshotname + ": " +
				// childtest.addScreenCaptureFromPath(screenshotpath) );

			}

			else if (desc2 == "Failed") {
				// test1.fail("testcase failed");
				// childtest.fail("testcase failed");
				childtest.log(Status.FAIL, MarkupHelper.createLabel("Testcase Failed", ExtentColor.RED));
				
				//Thread.sleep(2000);
				// code to capture the screenshot for failed test cases

				// Uncomment the code to attach screenshots in reports

				screenshotpath = Capturescreenshots(screenshotname + "_Failed");

				//Thread.sleep(1000);
				String encodestream = Encodeimage(screenshotpath);
				//Thread.sleep(1000);
				// childtest.log(Status.PASS, "screenshot below for " + screenshotname + ": "+
				// childtest.addScreenCaptureFromPath("." + screenshotpath) );
				Thread.sleep(1000);
				childtest.log(Status.FAIL, "screenshot below for " + screenshotname
						+ ": <img style=\"width:800px; height:400px;\"  src=\"" + encodestream + "\" />");
			} else {
				// test1.skip("testcase not executed");
				childtest.skip("testcase not executed");
				childtest.log(Status.SKIP, MarkupHelper.createLabel("Testcase skipped", ExtentColor.LIME));
				screenshotpath = Capturescreenshots(screenshotname + "_skipped");
				childtest.log(Status.PASS, "screenshot below for " + screenshotname + ": "
						+ childtest.addScreenCaptureFromPath("." + screenshotpath));
			}
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// extentrep.flush();
		// extent.flush();
	}

	// @AfterMethod
	public void endReport(ITestResult result) {
		test1.log(Status.INFO, "description of the test case");
		if (result.getStatus() == ITestResult.FAILURE) {
			test1.fail(MarkupHelper.createLabel(result.getName() + " Test case is failed", ExtentColor.RED));
			test1.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test1.pass(MarkupHelper.createLabel(result.getName() + " Test case i sPassed ", ExtentColor.GREEN));
		} else {
			test1.skip(MarkupHelper.createLabel(result.getName() + " Test case is skipped ", ExtentColor.YELLOW));
			test1.skip(result.getThrowable());
		}
		// extentrep = extentinstance();
		// extentrep.endTest(test1);
		// extentrep.flush();
	}

	// @BeforeTest
	public void setExtent() {
		/*
		 * htmlReporter = new
		 * ExtentHtmlReporter("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\src\\test\\java\\Reports\\extentreport.html"
		 * ); htmlReporter.config().setDocumentTitle("Automation Report"); //Title of
		 * the Report htmlReporter.config().setReportName("Functional Report"); //Name
		 * of the Report htmlReporter.config().setTheme(Theme.STANDARD);
		 * 
		 * 
		 * // create ExtentReports and attach reporter(s) extent = new ExtentReports();
		 * extent.attachReporter(htmlReporter); extent.setSystemInfo("Hostname",
		 * "Localhost"); extent.setSystemInfo("OS", "win 10");
		 * extent.setSystemInfo("Tester Name", "Priyanka A");
		 */
	}

	public String Capturescreenshots(String screenshotname) {
		String path = null;

		FileInputStream fileinputstream;
		FileInputStream decodestream;
		String imagestring = null;

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// path = ".//Results//Screenshots/"+ screenshotname +
			// System.currentTimeMillis() +".png" ;
			// relative path
			// path = ".//Results//Screenshots/"+ screenshotname +".png" ;
			// absolute path
			// path = "C://Users//priyanka//Desktop//Selenium
			// Projects//FirstProject//Results//Screenshots//"+ screenshotname +".png" ;

			// path = System.getProperty("user.dir")+ "//Results//Screenshots/"+
			// screenshotname +".png" ;

			path = "C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Results\\Screenshots\\"+ screenshotname + ".png";

			File destination = new File(path);
			FileUtils.copyFile(source, destination);

			// extra code to encode the image
			/*
			 * fileinputstream= new FileInputStream(path); byte[] bytes = new
			 * byte[(int)destination.length()]; //int bytes = fileinputstream.read();
			 * fileinputstream.read(bytes);
			 * 
			 * imagestring = Base64.getEncoder().encodeToString(bytes);
			 * 
			 * FileWriter filewriter = new
			 * FileWriter("C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Results\\Convertedimagepath\\img.txt"
			 * ); filewriter.write(imagestring); filewriter.close();
			 * fileinputstream.close(); System.out.println(imagestring);
			 */

			// decode image code is written in seprate function

		} catch (Exception e) {
			e.printStackTrace();

		}
		return path;
		// return imagestring;

	}

	public String Encodeimage(String screenshotpath) {
		String encodedString = null;

		FileInputStream fileinputstream;
		FileInputStream decodestream;
		try {
			byte[] fileContent = FileUtils.readFileToByteArray(new File(screenshotpath));
			encodedString = Base64.getEncoder().encodeToString(fileContent);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "data:image/png;base64, " + encodedString;
	}

	public FileOutputStream decodeimage(String inputpath, String outputpath) {
		FileOutputStream outputstream = null;
		try {
			// String outpathpath = "C:\\Users\\priyanka\\Desktop\\Selenium
			// Projects\\FirstProject\\Results\\Convertedimagepath\\img.txt";
			FileInputStream decodestream = new FileInputStream(inputpath);
			byte[] bytes2 = new byte[(int) inputpath.length()];
			decodestream.read(bytes2);

			byte[] data = Base64.getDecoder().decode(bytes2);

			outputstream = new FileOutputStream(outputpath);
			outputstream.write(data);

			outputstream.close();
			decodestream.close();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return outputstream;
	}

	public void SendEmailmethod(String screenshotpath, String Description, String sendtoemail, String sendfrom) {
		try {

			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(screenshotpath);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription(Description);
			attachment.setName("Pri");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			// need to check the server
			// email.setHostName("mail.myserver.com");
			// server name is taken from IT team
			email.setHostName("et-svr-sid-ex4.siddall.local");
			// email.setSslSmtpPort("465");

			String sendemailfromJenkins = System.getProperty("email");

			if (sendemailfromJenkins == null) {
				// if Jenkins devurl is not present then it would take the value from config
				// file

				email.addTo(sendtoemail, "Priyanka Agg");
				// System.out.println(sendemailfromJenkins);
			} else {
				email.addTo(sendemailfromJenkins, "Priyanka Agg");
			}

			// email.addTo(sendtoemail, "Priyanka Agg");
			email.setFrom(sendfrom, "Automation Test email");
			// email.setAuthentication("automated_testing@pacificict.co.nz",
			// "zxN$qX1RJ3wd");
			email.setSubject("Automatic mail functionality test");
			email.setMsg("Screenshots of test cases");
			// add the attachment
			email.attach(attachment);
			// send the email
			email.send();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String DataDrivenTesting(String testcasenme, String methodname) {

		String functionvalue = null;
		String testcasename = null;
		String functionname = null;
		try {
			// FileInputStream fis = new
			// FileInputStream("C://Users//priyanka//Desktop//Selenium//DatadriventestingwithSelenium.xlsx");
			FileInputStream fis = new FileInputStream(".//resources//DatadriventestingwithSelenium.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetcount = workbook.getNumberOfSheets();
			// System.out.println("Number of sheets: " + sheetcount);
			for (int i = 0; i < sheetcount; i++) {
				String sheetname = workbook.getSheetName(i);
				// System.out.println(sheetname);
				if (sheetname.equalsIgnoreCase("sample")) {
					XSSFSheet sheet = workbook.getSheetAt(i);
					int rowcount = sheet.getLastRowNum();
					// System.out.println("functionName: " + functionname + " Functionvalue: " +
					// functionvalue);
					int colcount = sheet.getRow(0).getLastCellNum();
					for (int k = 0; k < colcount; k++) {
						testcasename = sheet.getRow(0).getCell(k).getStringCellValue();
						if (testcasename.equalsIgnoreCase(testcasenme)) {
							// System.out.println("row: " + j + " col: " + k + " value is: "+
							// row.getCell(k).getStringCellValue());
							for (int j = 0; j <= rowcount; j++) {
								// Row row = sheet.getRow(j);
								functionname = sheet.getRow(j).getCell(0).getStringCellValue();
								if (functionname.equalsIgnoreCase(methodname)) {
									functionvalue = sheet.getRow(j).getCell(k).getStringCellValue();
									// String functionaval = sheet.getRow(j).getCell(k).getStringCellValue();
									// System.out.println("functionName: " + functionname + " Functionvalue: " +
									// functionvalue);
									// System.out.println(functionvalue);
									break;
								}
							}
							break;
						}
					}
					// extra code
					fis.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return functionvalue;
	}

	@AfterMethod
	public void tearDown() 
	{
		try 
		{
			if (driver != null) 
			{
				// driver.quit();
				driver.close();
				driver.quit();
				System.out.println("Test case executed successfully");
				// extent.flush();
				// String Screenshotpath = System.getProperty("user.dir") +
				// "\\Results\\extentReports.html";
				String screenshotpath = "C:\\Users\\priyanka\\Desktop\\Selenium Projects\\FirstProject\\Results\\extentReports.html";
				SendEmailmethod(screenshotpath, "extentReport", "pritpal@pacificict.co.nz","automated_testing@pacificict.co.nz");				
				// SendEmailmethod(".Results\\Screenshots", "extentReport",
				// "priyanka@pacificict.co.nz", "automated_testing@pacificict.co.nz");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	// @AfterSuite
	public void Reportteardown() 
	{
		extent.flush();
	}
}
