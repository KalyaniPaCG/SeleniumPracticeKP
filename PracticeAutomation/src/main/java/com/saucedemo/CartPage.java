package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

     //driver.findElement(By.id("checkout")).click();
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id ="checkout")
    WebElement chk_btn;

    public void checkout(){
        chk_btn.click();
    }

}
