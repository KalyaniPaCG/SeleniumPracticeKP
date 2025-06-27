package org.example;

import com.saucedemo.InventoryPage;
import com.saucedemo.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MainTest{
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void orderplacement() throws InterruptedException {
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
        LoginPage login_pg =new LoginPage(driver);
        login_pg.loginapp("standard_user","secret_sauce");

        String title=driver.getTitle();
        System.out.println("Page Title: "+title);
        Assert.assertEquals(title,"Swag Labs");

        //Select shopping items
//        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//
//        List<WebElement> inventory_list=driver.findElements(By.xpath("(//div[@class='inventory_item'])"));
//        WebElement select_product = inventory_list.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);
//
//        select_product.findElement(By.cssSelector(".btn_inventory ")).click();
//        // Got to cart
//        driver.findElement(By.className("shopping_cart_container")).click();
        InventoryPage inv_page= new InventoryPage(driver);
        inv_page.addProductToCart();

        Thread.sleep(2000);
        String title2=driver.getTitle();
        System.out.println("Page Title: "+title2);
        //Assert.assertEquals(title,"Swag Labs");

        driver.findElement(By.id("checkout")).click();

        //Checkout info
        driver.findElement(By.id("first-name")).sendKeys("User");
        driver.findElement(By.id("last-name")).sendKeys("Name");
        driver.findElement(By.id("postal-code")).sendKeys("4321");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        String message= driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(message,"Thank you for your order!");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}

