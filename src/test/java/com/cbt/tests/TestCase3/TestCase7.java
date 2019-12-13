package com.cbt.tests.TestCase3;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase7 {
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
        driver.findElement(By.xpath("//a[text()='File Upload']")).click();
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\Ali\\Desktop\\file.txt");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        String verify=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        Assert.assertEquals(verify,"File Uploaded!","did not macth");

        String verify2=driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(verify2,"file.txt","Did not match!");
    }


}
