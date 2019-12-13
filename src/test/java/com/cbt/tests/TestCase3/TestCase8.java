package com.cbt.tests.TestCase3;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase8 {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
       driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
      WebElement element= driver.findElement(By.id("myCountry"));
      element.sendKeys("United States of America");
       driver.findElement(By.xpath("//input[@value='Submit']")).click();

      String actual=driver.findElement(By.xpath("//p[text()='You selected: United States of America']")).getText();
        Assert.assertEquals(actual,"You selected: United States of America","Wrong code");
        String expected="You selected: United States of America";
        System.out.println("actual result: "+actual);
        System.out.println("expected result: "+expected);
    }
}
