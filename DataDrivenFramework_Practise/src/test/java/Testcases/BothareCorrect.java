package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BothareCorrect {

	@Test
	@Parameters({"userName1", "pwd1"})
		public void test1(String uname,String pwd)
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
