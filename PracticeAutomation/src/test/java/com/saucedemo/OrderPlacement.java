package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrderPlacement extends BaseTests{
    @Test(dataProvider = "getData")
    public void demoOrder(String username, String password) throws InterruptedException {
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
        LoginPage login_pg =new LoginPage(driver);
        login_pg.loginapp(username,password);

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

        /*driver.findElement(By.id("checkout")).click();*/
        CartPage ct_pg=new CartPage(driver);
        ct_pg.checkout();

        //Checkout info
//        driver.findElement(By.id("first-name")).sendKeys("User");
//        driver.findElement(By.id("last-name")).sendKeys("Name");
//        driver.findElement(By.id("postal-code")).sendKeys("4321");
//        driver.findElement(By.id("continue")).click();
//        driver.findElement(By.id("finish")).click();

        CheckoutPage ckout_pg =new CheckoutPage(driver);
        ckout_pg.checkoutOrder("User","Name","4321");

        //Verify the order success message
        String message= driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(message,"Thank you for your order!");
    }

    @DataProvider
     public Object[][] getData(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }


}
