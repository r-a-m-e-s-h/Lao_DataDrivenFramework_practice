package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XlDataLoginUsing_ChatGPT {
	
	WebDriver driver;
	
	
	@Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        // Set the path to the ChromeDriver executable
		
		WebDriverManager.chromedriver().setup();
		
        // Create a new instance of the Chrome driver
         driver = new ChromeDriver();

        try {
            // Perform the login using the obtained credentials
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(2000);
            driver.findElement(By.name("username")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.xpath("//*[text()=' Login ']")).click();
            Thread.sleep(2000);

            // Add your logic here to verify if the login was successful or not

            // Clear the input fields for the next iteration
//            driver.findElement(By.id("username")).clear();
//            driver.findElement(By.id("password")).clear();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        Object[][] data = null;

        try {
            // Load the Excel file
        	
        	File file = new File("C://Users//rames//OneDrive//Documents//TestData1.xlsx");
           
        	FileInputStream  fis = new FileInputStream(file);
          
        	Workbook workbook = new XSSFWorkbook(fis);
          
        	
            Sheet sheet = workbook.getSheetAt(0);

            // Determine the number of rows
            int rowCount = sheet.getLastRowNum(); //int rowCount = sheet.getLastRowNum() + 1;

            data = new Object[rowCount][2];

            // Iterate through the rows of the Excel file
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                
                /*
                data[i][0] = row.getCell(0).getStringCellValue(); // Username
                data[i][1] = row.getCell(1).getStringCellValue(); // Password
                
                */
                
                Cell usernameCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);

                String username = usernameCell.getStringCellValue();
                String password = passwordCell.getStringCellValue();

                data[i - 1][0] = username;
                data[i - 1][1] = password;

            }

            // Close the workbook and input stream
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }


}
