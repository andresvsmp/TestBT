package com.crm.qa.base;

import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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


    public void setUp(){

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // dynamic wait
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","serenity");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");

    }

    public void closedBrowser() {
        driver.quit();
    }

}
