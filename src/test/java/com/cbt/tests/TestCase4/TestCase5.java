package com.cbt.tests.TestCase4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class TestCase5 {


    WebDriver driver;
    Actions actions;

    WebDriverWait wait;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test5() throws InterruptedException, ParseException {

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        element.click();

        WebElement startTime=driver.findElement(By.xpath("//input[@placeholder='time']"));
        WebElement endTime=driver.findElement(By.xpath("(//input[@placeholder='time'])[2]"));

        String first = (startTime.getAttribute("value"));
        String second = (endTime.getAttribute("value"));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a");

        //.parse helps us to convert string to actual time and getTime() method returns us time in milliseconds
        //thats why we can use divided in milliseconds

        long actual= (sdf.parse(second).getTime()/3600000) - (sdf.parse(first).getTime()/3600000);
        //System.out.println(elapsed/3600000);
        Assert.assertEquals(actual,1);
        System.out.println("the difference between actual and expected is "+actual+" hour");

            }
        }


