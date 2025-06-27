package dev.selenium.formpage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormPageTests {

public WebDriver driver;

	@BeforeMethod
	//@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/formPage.html");
	}
	
	
@Test
	public void emailform() {
		// TODO Auto-generated method stub
		
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("age")).sendKeys("37");
		driver.findElement(By.id("submitButton")).click();
		String msg = driver.findElement(By.id("greeting")).getText();
		WebElement sucess = driver.findElement(By.id("greeting"));
		//wait.until(ExpectedConditions.visibilityOf(sucess));
		Assert.assertEquals(msg, "Success!");
		
	}
	
	
	@Test
	public void checkbox() throws InterruptedException {
		
		driver.findElement(By.name("checky")).click();	
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.name("checky")).isSelected(), true);
		
		
		
	}
	
	@Test
	public void radiobutton() throws InterruptedException {
		
		driver.findElement(By.id("cheese_and_peas")).click();
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By.id("cheese_and_peas")).isSelected(), true);
		
		
	}
	
	@Test
	public void dropdowns() throws InterruptedException {
		
		
		
		WebElement dropdown = driver.findElement(By.name("selectomatic"));
		Select list = new Select(dropdown);
		list.selectByVisibleText("Four");
		Thread.sleep(5000);
		WebElement dropdown1 = list.getFirstSelectedOption();
		Assert.assertEquals(dropdown1.getText(), "Four");
		
		
	}
	
	@Test
	public void usingCSSSelector() throws InterruptedException {
		
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("test@test.com");
		Thread.sleep(5000);
		
		
	}
	
	@Test
	public void usingXPathSelector() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
		Thread.sleep(5000);
		
		
	}
	
	//@AfterTest
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
