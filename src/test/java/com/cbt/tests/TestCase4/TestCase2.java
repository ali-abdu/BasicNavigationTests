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

public class TestCase2 {


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
    public void test2() throws InterruptedException {

        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();
        Thread.sleep(3000);

        WebElement grid=driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        grid.click();

        WebElement element2=driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
        element2.click();

        WebElement element3=driver.findElement(By.xpath("//tbody/tr[3]/td[3]"));
        element3.click();

        WebElement element4=driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
        element4.click();

        WebElement element5=driver.findElement(By.xpath("//tbody/tr[5]/td[3]"));
        element5.click();

        WebElement element6=driver.findElement(By.xpath("//tbody/tr[6]/td[3]"));
        element6.click();

        WebElement element7=driver.findElement(By.xpath("//tbody/tr[7]/td[3]"));
        element7.click();

        WebElement actual =driver.findElement(By.xpath("//thead[@class='grid-header']"));

        Assert.assertTrue(actual.isDisplayed());
        System.out.println(actual.getText());

    }
}
