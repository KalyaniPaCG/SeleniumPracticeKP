package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {

//    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//
//    List<WebElement> inventory_list=driver.findElements(By.xpath("(//div[@class='inventory_item'])"));
//    WebElement select_product = inventory_list.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals("Sauce Labs Backpack")).findFirst().orElse(null);
//
//        select_product.findElement(By.cssSelector(".btn_inventory ")).click();

    //driver.findElement(By.className("shopping_cart_container")).click();

    WebDriver driver;

    public InventoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement backpk;

    @FindBy(xpath="(//div[@class='inventory_item'])")
    WebElement inventorylist;

    @FindBy(className = "shopping_cart_container")
    WebElement shoppingcart;

    public void selectproduct(){

    }
    public void addProductToCart(){
        backpk.click();
        shoppingcart.click();

    }
}
