package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

//     driver.findElement(By.id("first-name")).sendKeys("User");
//        driver.findElement(By.id("last-name")).sendKeys("Name");
//        driver.findElement(By.id("postal-code")).sendKeys("4321");
//        driver.findElement(By.id("continue")).click();
//        driver.findElement(By.id("finish")).click();

     WebDriver driver;

     public CheckoutPage(WebDriver driver){
          this.driver=driver;
          PageFactory.initElements(driver, this);
     }
     @FindBy(id = "first-name")
     WebElement firstname;
     @FindBy(id = "last-name")
     WebElement lastname;
     @FindBy(id = "postal-code")
     WebElement postalcode;
     @FindBy(id = "continue")
     WebElement ctn_btn;
     @FindBy(id = "finish")
     WebElement fn_btn;

     public void checkoutOrder(String fnName, String ltName, String code){
          firstname.sendKeys(fnName);
          lastname.sendKeys(ltName);
          postalcode.sendKeys(code);
          ctn_btn.click();
          fn_btn.click();

     }

}
