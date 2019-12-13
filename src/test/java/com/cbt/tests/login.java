package com.cbt.tests;


import com.cbt.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login {
    //As a user, i should able to login
    /*
    1. login successfully with valid credential
            1.login page --> enter credential --> click login bbt --> verify login
    2. user cannot login with Invalid credential
            1.login page --> enter invalid credential --> click login bt --> verify error mes
    3. user cannot login without any credentials
            1. login page --> click login bbt --> error message
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void loginSuccessfully() {
        WebElement username = driver.findElement(By.name("USER_LOGIN"));
        username.sendKeys("helpdesk7@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
//        if(expectedTitle.equals(actualTitle)){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAIL");
//            System.out.println("Expected titile " + expectedTitle);
//            System.out.println("Actual titile " + expectedTitle);
//        }
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(driver.getTitle(), "por");
    }

    @Test
    public void inValidLogin() {
        WebElement username=driver.findElement(By.name("USER_LOGIN"));

        Faker dommyData=new Faker();

        String name=dommyData.name().firstName();
        username.sendKeys(name);

        driver.findElement(By.name("USER_PASSWORD")).sendKeys(dommyData.animal().name());
        driver.findElement(By.className("login-btn")).click();

        String expectedMessage="Incorrect login or password";
        WebElement errormessage =driver.findElement(By.className("errortext"));

        String actualMesaage=errormessage.getText();

        Assert.assertEquals(actualMesaage,expectedMessage);


        System.out.println("Invalid ");
    }
}





