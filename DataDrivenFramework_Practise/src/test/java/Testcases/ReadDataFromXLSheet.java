package Testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromXLSheet {
	
	
	
	@Test
	public void test1() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C://Users//rames//OneDrive//Documents//TestData1.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheetAt(1);
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("row count is : "+rowCount);
		
		int colCount =  sheet.getRow(0).getLastCellNum();
		
		for(int i =0;i<=rowCount;i++)
		{
			XSSFRow currentRow = sheet.getRow(i);
			
			for(int j=0;j<colCount;j++)
			{
				String value =	currentRow.getCell(j).toString();
				
				System.out.print("  "  +value);
				
			}
			System.out.println();
		}
		
		
	}

}
