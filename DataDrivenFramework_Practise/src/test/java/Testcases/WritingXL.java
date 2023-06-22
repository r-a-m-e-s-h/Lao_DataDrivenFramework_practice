package Testcases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WritingXL {
	
	
	@Test
	public void test() throws FileNotFoundException
	{
		FileOutputStream fos = new FileOutputStream("C://Users//rames//OneDrive//Documents//Test.xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("DataSet1");
		
		for(int i=0;i<=5;i++)
		{
			XSSFRow row = sheet.createRow(i);
			
			for(int j=0;j<=3;j++)
			{
				row.createCell(j).setCellValue("Hello");
			}
		}
		System.out.println(" XL Writing completed");
		
		
	}

}
