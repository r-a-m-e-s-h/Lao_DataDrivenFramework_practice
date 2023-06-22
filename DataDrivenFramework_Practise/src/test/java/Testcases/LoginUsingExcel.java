//package Testcases;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class LoginUsingExcel {
//	
//	
//	
////	String [][]data = null;
////	
////	@DataProvider(name="LoginData")
////	public String[][] loginDataProvider()
////	{
////		data = getExcelData();
////		return data;
////	}
////	
////	
////	public String[][] getExcelData() throws IOException
////	{
////		String filepath = "C:\\Users\\rames\\TestData.xls.xlsx";
////		
////		FileInputStream fis = new FileInputStream(filepath);
////		
////		Workbook book = new XSSFWorkbook(fis);
////		
////		Sheet sheet = book.getSheet("Sheet1");
////		
////		int rowCount = sheet.getLastRowNum()+1;
////		
////		sheet.getcol
//		
////        for (int i = 0; i < rowCount; i++) {
////            Row row = sheet.getRow(i);
////            int cellCount = row.getLastCellNum();
////            for (int j = 0; j < cellCount; j++) {
////                Cell cell = row.getCell(j);
////                String cellValue = cell.getStringCellValue();
////                System.out.print(cellValue + "\t");
////
////            }
////            System.out.println(); 
////        }
////        book.close();
////		return ;
//	//}
//	
//	
//	@Test(dataProvider = "LoginData")
//	public void Login(String uname,String pwd)
//	{
//		WebDriver driver;
//		
//		WebDriverManager.chromedriver().setup();
//
//		driver = new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//
//		WebElement userName = driver.findElement(By.xpath("//form//div//input[@name='username']"));
//		userName.sendKeys(uname);
//
//		WebElement password  = driver.findElement(By.xpath("//*[@name='password']"));
//		password.sendKeys(pwd);
//
//		WebElement loginBtn = driver.findElement(By.xpath("//*[text()=' Login ']"));
//		loginBtn.click();
//		
//		System.out.println(" The Page Title is : "+driver.getTitle());
//
//		driver.quit();
//	}
//
//}
