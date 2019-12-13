package com.cbt.tests;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class logOut {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("fire fox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        // driver.quit();
    }

    @Test
    public void TestCase6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(3000);
        WebElement element=driver.findElement(By.id("email"));
        String email=element.getText();
        System.out.println(email);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ali.ab@hotmail.com");
        driver.findElement(By.name("wooden_spoon")).click();


//        String signup=driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
//        Assert.assertEquals(signup,"Thank you for signing up. Click the button below to return to the home page.","Did not match!");

        WebElement message=driver.findElement(By.name("signup_message"));
        Assert.assertEquals(message.getText(),"Thank you for signing up. Click the button below to return to the home page.");

        driver.navigate().to("https://www.tempmailaddress.com/");
//WebElement find=driver.findElement(By.xpath("//th[text()='From']"));


    }

}
