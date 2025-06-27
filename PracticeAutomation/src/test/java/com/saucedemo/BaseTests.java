package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    WebDriver driver;

    public WebDriver initialiaseDriver(){
        //WebdriverManager.chrome
            driver= new ChromeDriver();
            driver.manage().window().maximize();

            return driver;
        }

        @BeforeMethod
    public void lauchapplication(){
        driver=initialiaseDriver();
            driver.get("https://www.saucedemo.com/");

        }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
