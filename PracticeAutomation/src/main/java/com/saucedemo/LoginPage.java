package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
//    driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement userpassword;

    @FindBy(className="submit-button")
    WebElement login_btn;

    public void loginapp(String user,String password) {
        username.sendKeys(user);
        userpassword.sendKeys(password);
        login_btn.click();
    }

}
