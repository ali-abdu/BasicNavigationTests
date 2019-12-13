package com.cbt.tests.TestCase4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase6 {

    WebDriver driver;
    Actions actions;

    WebDriverWait wait;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }

    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test4() throws InterruptedException {

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
      Thread.sleep(3000);
        WebElement startTime=driver.findElement(By.xpath("//input[@placeholder='time']"));
        startTime.click();

        Thread.sleep(3000);
        WebElement e=driver.findElement(By.xpath("//div/ul/li[text()='9:00 PM']"));
        e.click();

        WebElement endtime=driver.findElement(By.xpath("(//div/ul[@class='ui-timepicker-list'])[2]/li[3]"));
        Assert.assertEquals(endtime,"10:00 PM");
        System.out.println("actual is "+endtime);

    }
}