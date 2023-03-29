package com.crm.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Calendar;

import java.util.List;

public class MilesCarRental {

    WebDriver driver;


    //Initializing the page Objects
    public MilesCarRental(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void fillIformation() throws InterruptedException {

        //UPDATE DATES
        Calendar c = Calendar.getInstance();
        String day = Integer.toString(c.get(Calendar.DATE));
        String month = 0+Integer.toString(c.get(Calendar.MONTH)+1);
        String date = "2023"+month+day;

        //NAMES LOCATORS
        WebElement pickupLocationInput = driver.findElement(By.xpath("//*[contains(@id,'pickupLocation"+date+"')]"));
        WebElement pickupDateInput = driver.findElement( By.xpath("//*[contains(@id,'from-input"+date+"')]")  );
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@id,'btnQS"+date+"')]"));

        pickupLocationInput.sendKeys("Florida");
        pickupLocationInput.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Florida Keys Marathon, Marathon, Florida, Estados Unidos']")));

        //When the element is not clicleable
       WebElement ele = driver.findElement(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Florida Keys Marathon, Marathon, Florida, Estados Unidos']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);

        pickupDateInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@class='container__months columns-2']")));
        //SCROLL DOWN TO CALENDAR
        scrollIntoView(driver.findElement(By.xpath("//DIV[@class='day-item'][text()='28']")) , driver);

        //When the element is not clicleable
        WebElement date1 = driver.findElement(By.xpath("//DIV[@class='day-item'][text()='28']"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", date1);

        // Obtain all elements
        List<WebElement> resultados = driver.findElements(By.xpath("//DIV[@class='day-item'][text()='4']"));
       // Select the second one and click
        resultados.get(1).click();
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'button button-xxl-L | d-none d-lg-grid')]")));
        //When the element is not clicleable
        WebElement ele1 = driver.findElement(By.xpath("//DIV[@id='car_1']/div/div/div/button[@class='button button-xxl-L | d-none d-lg-grid']"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", ele1);
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("selected-flag")));
        scrollIntoView(driver.findElement(By.xpath("//*[contains(@id,'inpName')]")) , driver);
        WebElement nameUser = driver.findElement(By.xpath("//*[@id='inpName']"));
        WebElement phoneUser = driver.findElement( By.xpath("//*[@id='phoneCustom']")  );
        WebElement emailUser = driver.findElement(By.xpath("//*[@id='inpEmail']"));
        WebElement submitB = driver.findElement(By.xpath("//BUTTON[@type='submit']"));
        nameUser.sendKeys("AndresVasquez");
        phoneUser.sendKeys("3017714826");
        emailUser.sendKeys("vasquezandres@javeriana.edu.co");

        submitB.click();
}


    //scroll until view something
    public void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }






}
