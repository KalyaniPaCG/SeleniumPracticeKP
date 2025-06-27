package com.saucedemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
	WebDriver driver;
	
//	List<WebElement> inventory_list=driver.findElements(By.xpath("(//div[@class='inventory_item'])"));
//	
//	WebElement select_product = inventory_list.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);
//	
//	select_product.findElement(By.cssSelector(".btn_inventory ")).click();
//	
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
//	driver.findElement(By.className("shopping_cart_link")).click();

	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	
	
	@FindBy(xpath="(//div[@class='inventory_item'])")
	List<WebElement> inventory_list;
	
	By inventoryList = By.xpath("(//div[@class='inventory_item'])");
	By addtocartbutton = By.cssSelector(".btn_inventory ");
	
	@FindBy(className="shopping_cart_link")
	WebElement shoppingcartbadge;
	
	public void addproducttocart(String productname ) {
		WebElement selectedproducted = selectproduct(productname);
		selectedproducted.findElement(addtocartbutton).click();
	}
	
	public WebElement selectproduct(String productname) {
		WebElement select_product = inventory_list.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productname)).findFirst().orElse(null);
		return select_product;
	}
	
	public void clickonshoppincart() {
		shoppingcartbadge.click();
	}
	
}
