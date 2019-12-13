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

public class TestCase3 {

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
    public void test3() throws InterruptedException {

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();
        Thread.sleep(3000);

        WebElement element=driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        element.click();

        Thread.sleep(5000);
        WebElement element1=driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']"));
        element1.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element1));

        WebElement SaveAndClose=driver.findElement(By.xpath("//li/button[@type='submit']"));
        WebElement SaveAndNew=driver.findElement(By.xpath("//ul/li[2]/button"));
        WebElement Save=driver.findElement(By.xpath("//ul/li[3]/button"));

        Assert.assertTrue(SaveAndClose.isDisplayed());
        Assert.assertTrue(SaveAndNew.isDisplayed());
        Assert.assertTrue(Save.isDisplayed());

        System.out.println(SaveAndClose.getText());
        System.out.println( SaveAndNew.getText());
        System.out.println(Save.getText());


    }



}
