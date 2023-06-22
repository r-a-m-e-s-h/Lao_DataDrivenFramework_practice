package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginUsingDataProvider {
	
	
	String [][]data = {
			{"Admin","admin123"},
			{"Admin1","admin123"},
			{"Admin","admin321"},
			{"Im-not-an-Admin","Admin123456678890"}
			
	};
	
	@DataProvider(name="LoginData")
	public String[][] loginDataProvider()
	{
		return data;
	}
	
	
	@Test(dataProvider = "LoginData")
	public void Login(String uname,String pwd)
	{
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		

		WebElement userName = driver.findElement(By.xpath("//form//div//input[@name='username']"));
		userName.sendKeys(uname);

		WebElement password  = driver.findElement(By.xpath("//*[@name='password']"));
		password.sendKeys(pwd);

		WebElement loginBtn = driver.findElement(By.xpath("//*[text()=' Login ']"));
		loginBtn.click();
		
		System.out.println(" The Page Title is : "+driver.getTitle());

		driver.quit();
	}

}
