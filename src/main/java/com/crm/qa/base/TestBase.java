package com.crm.qa.base;

import com.crm.qa.pages.HomePageAE;
import com.crm.qa.pages.MilesCar4;
import com.crm.qa.pages.MilesCarRental;
import com.crm.qa.pages.ProductsAE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
        HomePageAE homePageAE = new HomePageAE(driver);
        homePageAE.homepage();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/"); //DOUBLE CHECK
        }

    public void product() {

        ProductsAE productsAE = new ProductsAE(driver);
        productsAE.products();

    }

    public void setUp3() throws InterruptedException {
        driver.navigate().to("https://milescarrental.com/");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://milescarrental.com/es/");
    }

    public void fillI() throws InterruptedException {
        MilesCarRental milesCarRental = new MilesCarRental(driver);
        milesCarRental.fillIformation();
    }

    public void milesCar() throws InterruptedException {
        MilesCar4 milesCar4 = new MilesCar4(driver);
        milesCar4.Template();
    }

    public void closedBrowser() {
        driver.quit();
    }



}
