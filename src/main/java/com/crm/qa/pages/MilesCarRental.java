package com.crm.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Calendar;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

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
        System.out.println(date);

        //NAMES LOCATORS
      //  String pickupLocationInput = "//*[contains(@id,'pickupLocation"+date+"')]";

        WebElement pickupLocationInput = driver.findElement(By.xpath("//*[contains(@id,'pickupLocation"+date+"')]"));
        WebElement pickupDateInput = driver.findElement( By.xpath("//*[contains(@id,'from-input"+date+"')]")  );
        WebElement dropoffDateInput = driver.findElement(By.xpath("//*[contains(@id,'to-input"+date+"')]"));
        WebElement searchButton = driver.findElement(By.xpath("//*[contains(@id,'btnQS"+date+"')]"));


        pickupLocationInput.sendKeys("Florida");
        pickupLocationInput.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Florida Keys Marathon, Marathon, Florida, Estados Unidos']")));
     //   driver.findElement(By.xpath("//*[text()='Aeropuerto de Florida Keys Marathon, Marathon, Florida, Estados Unidos']")).click();
        driver.findElement(By.xpath("//SPAN[@class='item-autocomplete__label'][text()='Aeropuerto de Florida Keys Marathon, Marathon, Florida, Estados Unidos']")).click();

        pickupDateInput.sendKeys("03/04/2023");
        dropoffDateInput.sendKeys("03/05/2023");

        searchButton.click();

        /*



        // Espera a que se carguen los resultados de la búsqueda
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("car-rental-item")));

        // Recupera los resultados de la búsqueda
        WebElement searchResults = driver.findElement(By.className("search-results"));

        // Imprime los resultados de la búsqueda
        System.out.println(searchResults.getText());
        synchronized (driver){
        driver.wait();
        }
        driver.findElement(By.xpath("//div[@class='form-qa_button']/a ")).click(); */
      //  driver.navigate().to("https://milescarrental.com/car/index/search/searchkey/ZW5lcmdpemVlLTE2Nzk5NzgzOTkuNzYxOS0zMjgy/pickup_location_code/MTHT01/return_location_code/MTHT01/pickup_date/" +
       //"04-28-2023/pickup_time/12%3A00/return_date/05-04-2023/return_time/12%3A00/vehicle_type_id/0/total_days/6/country_destination/US");

       // driver.navigate().to("https://milescarrental.com/detail/ZW5lcmdpemVlLTE2Nzk5NzgzOTkuNzYxOS0zMjgy/b2aad9f4-e7a9-4510-b7d0-4ff03d0e15ec/tSqo3JWIZ9kkrTgAB%2FP666mHtUu2jvrC5BE84v55BMc%3D/1A/ZI/CCAR");

       /* driver.findElement(By.id("inpName")).sendKeys("Andres Vasquez");
        driver.findElement(By.id("phoneCustom")).sendKeys("3017714826");
        driver.findElement(By.id("inpEmail")).sendKeys("3017714826");

*/

        // buttom.click();
       // location.click();
       // location.sendKeys("Florida Key Marathon");
       // firstDate.click();
      /*  Date1.click();
        SecondDate.click();
        Date2.click();
        search.click(); */


        /*
       scrollIntoView(driver.findElement(By.xpath("//*[starts-with(@class, 'panel-titlebar-text') ]")) , driver);
        elementToBeClickable( By.xpath("//*[starts-with(@class, 'fa fa-check-circle text-purple') ]"));
*/
    }


    //scroll until view something
    public void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }






}
