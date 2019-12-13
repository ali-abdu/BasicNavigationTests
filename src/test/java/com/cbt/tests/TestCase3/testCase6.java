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

public class testCase6 {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {

      driver.quit();
    }

    @Test
    public void TestCase6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
       WebElement element=driver.findElement(By.id("email"));
        String email=element.getText();
        System.out.println(email);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();


//        String signup=driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
//        Assert.assertEquals(signup,"Thank you for signing up. Click the button below to return to the home page.","Did not match!");

        WebElement message=driver.findElement(By.name("signup_message"));

        Assert.assertEquals(message.getText(),"Thank you for signing up. Click the button below to return to the home page.");

        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.navigate().refresh();
        WebElement verify=driver.findElement(By.xpath("//tbody/tr/td[@class='from']"));
        String actualemail = verify.getText();
       // System.out.println(actualemail);
        actualemail = actualemail.trim();
        String expectedeail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualemail,expectedeail);
        verify.click();


         String verify2=driver.findElement(By.xpath("//*[.='do-not-reply@practice.cybertekschool.com']")).getText();
         Assert.assertEquals(verify2,"do-not-reply@practice.cybertekschool.com","Did not match");
       //String expected="do-not-reply@practice.cybertekschool.com";

        String verify3=driver.findElement(By.xpath("//span[@id='predmet']")).getText();
        Assert.assertEquals(verify3,"Thanks for subscribing to practice.cybertekschool.com!","Did not match");

//
  }

}
