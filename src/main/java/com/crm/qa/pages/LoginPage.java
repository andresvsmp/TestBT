package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="LoginPanel0_Username")
    WebElement user;

    @FindBy(id="LoginPanel0_Password")
    WebElement password;

    @FindBy(id="LoginPanel0_LoginButton")
    WebElement button;

    //Initializing the page Objects
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String users, String passwoord){
        driver.get("https://serenity.is/demo/");
        driver.findElement(By.id("LoginPanel0_Username")).clear(); // If you have the password save before
        driver.findElement(By.id("LoginPanel0_Password")).clear(); //With this part delete that.
        user.sendKeys(users);
        password.sendKeys(passwoord);
        button.click();
    }


}
