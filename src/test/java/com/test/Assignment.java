package com.test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Assignment extends TestBase {

    @BeforeClass
    public void setUp(){

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); // delete all the cookies
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); // dynamic wait
    }

    //Test cases --- Starting with @test
    @Test
    public void Login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","serenity");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");
    }

    @Test
    public void createContact() {
        Login();
        NewContact contact = new NewContact(driver);
        contact.newContact();
    }

    @Test
    public void createCustomer() {
        Login();
        NewCustomer customer = new NewCustomer(driver);
        customer.createCustomer();

    }

    //Post conditions
    @AfterClass
    public void closedBrowser() {
        driver.quit();
    }

}
