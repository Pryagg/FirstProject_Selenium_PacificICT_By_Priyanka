package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class excelDataDrivenTesting 
{
	
	@Test
	public void callexcel()
	{
		try
		{
			String methodvalue = DataDrivenTestingg("Guest user","Billing address");
			System.out.println( "Methodvalue: " + methodvalue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}	
	
	// scanning the Testcases by scanning th efirst
	public String DataDrivenTestingg(String testcasenme, String methodname) 
	{
		String functionvalue = null;
		String testcasename = null;
		 String functionname = null;
		try {
			FileInputStream fis = new FileInputStream("C://Users//priyanka//Desktop//Selenium//DatadriventestingwithSelenium.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheetcount = workbook.getNumberOfSheets();
			System.out.println("Number of sheets: " + sheetcount);
			for (int i = 0; i < sheetcount; i++) {

				String sheetname = workbook.getSheetName(i);
				// System.out.println(sheetname);

			
				  if (sheetname.equalsIgnoreCase("sample")) 
				  {
				  
				  XSSFSheet sheet = workbook.getSheetAt(i); 				  
				  int rowcount = sheet.getLastRowNum(); 
				 
				 
					  
					  
					  //System.out.println("functionName: " + functionname + " Functionvalue: " + functionvalue);
					  
					  int colcount = sheet.getRow(0).getLastCellNum();
						
						  for(int k=0;k<colcount;k++) 
						  {
							  testcasename = sheet.getRow(0).getCell(k).getStringCellValue();
							  
							  if (testcasename.equalsIgnoreCase(testcasenme))
							  {
								  //System.out.println("row: " + j + " col: " + k + " value is: "+ row.getCell(k).getStringCellValue());
								  for(int j=0;j<=rowcount;j++) 
								  {
									  //Row row =  sheet.getRow(j); 
									  functionname = sheet.getRow(j).getCell(0).getStringCellValue();
									  if (functionname.equalsIgnoreCase(methodname))
									  {									  
										 functionvalue = sheet.getRow(j).getCell(k).getStringCellValue();
										// String functionaval = sheet.getRow(j).getCell(k).getStringCellValue();
									//	  System.out.println("functionName: " + functionname + " Functionvalue: " + functionvalue);	
										  
										  //System.out.println(functionvalue);
										  break;									  
									  }  		  									
								  }
								  break;					 
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
