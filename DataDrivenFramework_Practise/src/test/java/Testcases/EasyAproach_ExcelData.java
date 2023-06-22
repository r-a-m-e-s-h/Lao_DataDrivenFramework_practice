package Testcases;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EasyAproach_ExcelData {


	@DataProvider(name="LoginData")
	public Object[][] test() throws IOException
	{
		String fpath = System.getProperty("user.dir")+"/Excel-Data/TestData1.xlsx";
		
		FileInputStream fis = new FileInputStream(fpath);
		
		//FileInputStream fis = new FileInputStream("C://Users//rames//OneDrive//Documents//TestData1.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(fis);

		XSSFSheet sheet = book.getSheet("Sheet1");

		int rowcount = 	sheet.getLastRowNum();

		int colCount =	sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowcount][colCount];

		for(int i=1;i<=rowcount;i++)
		{
			Row row = sheet.getRow(i);

			for(int j=0;j<colCount;j++)
			{
				Cell cell = row.getCell(j);

				data[i-1][j] = cell.getStringCellValue();
			}

		}

		return data;

	}
	
	
	@Test(dataProvider = "LoginData")
	public void logintest(String uname, String pwd) throws InterruptedException
	{
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys(uname);
		
		driver.findElement(By.name("password")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		
		Thread.sleep(2000);
		
		String WebpageTitle = driver.getTitle();
		System.out.println(" The title is : " +WebpageTitle);
		
		driver.quit();
		
	}

}
