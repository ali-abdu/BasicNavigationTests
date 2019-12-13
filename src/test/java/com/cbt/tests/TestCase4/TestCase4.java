package com.cbt.tests.TestCase4;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase4 {

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
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        element.click();

        if(driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size()>0) {
            WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement cancel = driver.findElement(By.xpath("//a[@data-action='cancel']"));
        cancel.click();

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement element1 = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        Assert.assertTrue(element1.isDisplayed());
        System.out.println(element1.getText());

    }

    }



