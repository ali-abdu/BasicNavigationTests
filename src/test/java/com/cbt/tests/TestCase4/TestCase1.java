package com.cbt.tests.TestCase4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class TestCase1 {

    WebDriver driver;
    Actions actions;

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
    public void test1() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        target.click();
       Thread.sleep(3000);

       WebElement element= driver.findElement(By.xpath("//table/tbody/tr[14]/td[9]"));
       actions.moveToElement(element).build().perform();

       WebElement view= driver.findElement(By.xpath("//a[@title='View']"));
       actions.moveToElement(view).build().perform();

       Assert.assertTrue(view.isDisplayed());
        System.out.println("View is available: "+view.isDisplayed());

         WebElement edit= driver.findElement(By.xpath("//a[@title='Edit']"));
         actions.moveToElement(edit).build().perform();

         Assert.assertTrue(edit.isDisplayed());
         System.out.println("Edit is available: "+edit.isDisplayed());

            WebElement delete = driver.findElement(By.xpath("(//i[@class='fa-trash-o hide-text'])[1]"));

            actions.moveToElement(delete).build().perform();

            Assert.assertTrue(delete.isDisplayed());
            System.out.println("Delete is available: " + delete.isDisplayed());


        }


    }
