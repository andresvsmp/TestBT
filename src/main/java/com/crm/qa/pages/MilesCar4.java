package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Calendar;
import java.util.List;

public class MilesCar4 {

    WebDriver driver;


    //Initializing the page Objects
    public MilesCar4(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




    public void Template() throws InterruptedException {

        //UPDATE DATES
        Calendar c = Calendar.getInstance();
        String day = Integer.toString(c.get(Calendar.DATE));
        String month = 0+Integer.toString(c.get(Calendar.MONTH)+1);
        String date = "2023"+month+day;

        //NAMES LOCATORS
        WebElement pickupLocationInput = driver.findElement(By.xpath("//*[contains(@id,'pickupLocation"+date+"')]"));
        WebElement pickupDateInput = driver.findElement( By.xpath("//*[contains(@id,'from-input"+date+"')]")  );
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@id,'btnQS"+date+"')]"));

        pickupLocationInput.sendKeys("Lima");
        pickupLocationInput.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Lihue, Lihue, Hawaii, Estados Unidos']")));

        //When the element is not clicleable
        WebElement ele = driver.findElement(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Lihue, Lihue, Hawaii, Estados Unidos']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        pickupDateInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@class='container__months columns-2']")));

        //SCROLL DOWN TO CALENDAR
        scrollIntoView(driver.findElement(By.xpath("//DIV[@class='day-item'][text()='28']")) , driver);

        //When the element is not clicleable
        WebElement date1 = driver.findElement(By.xpath("//DIV[@class='day-item'][text()='10']"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", date1);

        // Obtain all elements
        List<WebElement> resultados = driver.findElements(By.xpath("//DIV[@class='day-item'][text()='1']"));
        // Select the second one and click
        resultados.get(1).click();

        //When the element is not clicleable
        WebElement butto = driver.findElement(By.xpath("//*[contains(@id,'inpDiferentLocation"+date+"')]"));
        JavascriptExecutor execut = (JavascriptExecutor)driver;
        execut.executeScript("arguments[0].click();", butto);
        driver.findElement(By.xpath("//*[contains(@id,'returnLocation"+date+"')]")).sendKeys("Washington");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto Internacional de Washington Dulles, Dulles, Virginia, Estados Unidos']")));

        //When the element is not clicleable
        WebElement retur = driver.findElement(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto Internacional de Washington Dulles, Dulles, Virginia, Estados Unidos']"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click();", retur);
        searchButton.click();
        WebDriverWait wait1 = new WebDriverWait(driver, 25);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@class='alert alert--info ds-mb-XS']")));

       // Assert.assertEquals(Alert,"Tarifas agotadas");
        Assert.assertTrue(driver.findElement(By.xpath("//DIV[@class='alert alert--info ds-mb-XS']")).isDisplayed(),"No available");

    }

    //scroll until view something
    public void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
