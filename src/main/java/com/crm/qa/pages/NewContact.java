package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class NewContact {

    WebDriver driver;

    //Initializing the page Objects
    public NewContact(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void newContact(){

        driver.get("https://demo.serenity.is/Account/Login/?ReturnUrl=%2F");
        driver.navigate().to("https://demo.serenity.is/Organization/Contact");
        driver.findElement(By.xpath("//*[@class='tool-button add-button icon-tool-button']")).click();

        driver.findElement(By.name("Title")).sendKeys("Mr");
        driver.findElement(By.name("FirstName")).sendKeys("Andres");
        driver.findElement(By.name("LastName")).sendKeys("Vasquez");
        driver.findElement(By.name("Email")).sendKeys("andresvasquez@gmail.com");
        driver.findElement(By.name("IdentityNo")).sendKeys("12345678");

        driver.findElement(By.xpath("//*[@class='fa fa-check-circle text-purple']")).click();

    }



}
