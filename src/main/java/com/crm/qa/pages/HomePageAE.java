package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageAE {

    WebDriver driver;

    @FindBy(xpath="(//A[@href='https://www.youtube.com/c/AutomationExercise'])")
    WebElement button;

    //Initializing the page Objects
    public HomePageAE(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void homepage() throws InterruptedException {
        driver.get("https://automationexercise.com/");
        String video = button.getText();
        Assert.assertEquals(video,"Video Tutorials"); //FIRST CHECK
    }



}
