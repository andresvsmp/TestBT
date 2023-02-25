package com.crm.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {

    WebDriver driver;

    @FindBy(xpath="//*[starts-with(@class, 'fa fa-plus-circle text-green') ]")
    WebElement newConsumer;


    //Initializing the page Objects
    public NewCustomer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void createCustomer() {

        driver.get("https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");
        driver.navigate().to("https://demo.serenity.is/Northwind/Customer");
        newConsumer.click();
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CustomerID")).sendKeys("63345");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_CompanyName")).sendKeys("Choucair");

        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_ContactName")).sendKeys("ANDRES VASQUEZ");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_ContactTitle")).sendKeys("Sr");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_Address")).sendKeys("Calle 89 # 20-21");
        driver.findElement(By.id("select2-chosen-5")).click();
        driver.findElement(By.xpath("//*[starts-with(@class, 'select2-result-label') ]")).click();

        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_Region")).sendKeys("Cundinamarca");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_PostalCode")).sendKeys("111111");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_Fax")).sendKeys("5555555");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_Phone")).sendKeys("3203204321");

        driver.findElement(By.name("LastContactDate")).sendKeys("12/12/2022");
        driver.findElement(By.id("Serenity_Demo_Northwind_CustomerDialog9_Email")).sendKeys("andresvasquez@gmail.com");
        scrollIntoView(driver.findElement(By.xpath("//*[starts-with(@class, 'panel-titlebar-text') ]")) , driver);

        driver.findElement(By.xpath("//*[starts-with(@class, 'fa fa-check-circle text-purple') ]")).click();
    }


    //scroll until view something
    public void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }






}
