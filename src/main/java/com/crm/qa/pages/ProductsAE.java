package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ProductsAE {

    WebDriver driver;

    @FindBy(xpath="(//A[@href='/products'])")
    WebElement product;

    //Initializing the page Objects
    public ProductsAE(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void products()  {

        product.click();
        driver.navigate().to("https://automationexercise.com/products");
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://automationexercise.com/products"); //DOUBLE CHECK
        driver.findElement(By.id("search_product")).sendKeys("Men Tshirt");
        driver.findElement(By.id("submit_search")).click();
        String product = driver.findElement(By.xpath("//div[@class='single-products']/div/p")).getText();
        Assert.assertEquals(product,"Men Tshirt");
        WebDriverWait wait =  new WebDriverWait(driver,4);

    }



}
