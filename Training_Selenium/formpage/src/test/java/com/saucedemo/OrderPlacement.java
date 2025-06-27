package com.saucedemo;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderPlacement {
	
	
	@Test
	public void placeorder() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	
		LoginPage loginpage = new LoginPage(driver);
		loginpage.logintoapp("standard_user","secret_sauce");
		InventoryPage inventorypage = new InventoryPage(driver);
		inventorypage.addproducttocart("Sauce Labs Backpack");
		inventorypage.clickonshoppincart();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("FirstName");
		driver.findElement(By.id("last-name")).sendKeys("LastName");
		driver.findElement(By.id("postal-code")).sendKeys("1234");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		String sucessmsg = driver.findElement(By.cssSelector(".complete-header")).getText();
		Assert.assertEquals(sucessmsg, "Thank you for your order!");
		driver.close();
	}

	
	@Test
	public void invalidlogin() {
		
	}
	
	@Test
	public void placeorder2() {
//		LoginPage loginpage = new LoginPage(driver);
//		loginpage.logintoapp("standard_user","secret_sauce");
//		InventoryPage inventorypage = new InventoryPage(driver);
//		inventorypage.addproducttocart("Sauce Labs Backpack");
//		inventorypage.clickonshoppincart();
	}
}
