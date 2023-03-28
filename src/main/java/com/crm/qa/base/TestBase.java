package com.crm.qa.base;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {

    public static WebDriver driver = new ChromeDriver();
    static Properties prop;

    public TestBase(){
            try{
                prop = new Properties();
                FileInputStream ip = new FileInputStream("C:\\Users\\user\\Desktop\\JAVA\\seleniumproject\\src\\main\\java\\com\\crm" +
                        "\\qa\\config\\config.properties");
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public void setUp() throws InterruptedException {

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // dynamic wait
        HomePage homePage = new HomePage(driver);
        homePage.homepage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/"); //DOUBLE CHECK
        }

    public void product() {

        Products products = new Products(driver);
        products.products();

    }

    public void setUp3() throws InterruptedException {

        driver.navigate().to("https://milescarrental.com/");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://milescarrental.com/es/"); //DOUBLE CHECK
    }

    public void closedBrowser() {
        driver.quit();
    }



}
