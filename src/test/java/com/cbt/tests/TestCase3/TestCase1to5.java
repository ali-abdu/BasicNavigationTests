package com.cbt.tests.TestCase3;

import com.cbt.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase1to5 {

   WebDriver driver;
   @BeforeMethod
    public void setupMethod() {
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
@Test(enabled = false)
public void TestCase1(){
       driver.get("https://practice-cybertekschool.herokuapp.com/");
       driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

       driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");

String DateOfBirth=driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]")).getText();
Assert.assertEquals(DateOfBirth,"The date of birth is not valid","Not valid date of birth");
}
@Test(enabled = false)
    public void TestCase2() throws InterruptedException {
    driver.get("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
Thread.sleep(2000);

   String CPlus = driver.findElement(By.xpath("//label[contains(text(),'C++')]")).getText();
    Assert.assertEquals(CPlus,"C+","Did not match Joder");

    String Java=driver.findElement(By.xpath("//label[text()='Java']")).getText();
    Assert.assertEquals(Java,"Java","Did not match Ostio");

    String JavaScript=driver.findElement(By.xpath("//label[text()='JavaScript']")).getText();
    Assert.assertEquals(JavaScript,"JavaScript","Did not Pass");
}
@Test(enabled = false)
    public void TestCase3() {
    driver.get("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("A");
    String firstname = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
    Assert.assertEquals(firstname, "first name must be more than 2 and less than 64 characters long", "Did not pass");
}
        @Test(enabled = false)
        public void TestCase4(){
            driver.get("https://practice-cybertekschool.herokuapp.com/");
            driver.findElement(By.xpath("//a[@href='/registration_form']")).click();

            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("B");
            String lastname=driver.findElement(By.xpath("//small[contains(text(),'The last name must be more than 2 and less than 64 characters long')]")).getText();
            Assert.assertEquals(lastname,"The last name must be more than 2 and less than 64 characters long","Did not pass :(");
}
         @Test
          public void TestCase5() throws InterruptedException {
           driver.get("https://practice-cybertekschool.herokuapp.com/");
           driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
            driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ali");
            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Abdullayev");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Aabdul");
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ali.abdu-@hotmail.com");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("202-555-1123");

             WebElement female=driver.findElement(By.xpath("//input[@value='female']"));
             female.click();
             System.out.println("female is selected"+female.isSelected());
             Assert.assertTrue(female.isSelected());

             driver.findElement(By.xpath("//input[@placeholder='MM/DD/YYYY']")).sendKeys("05/05/1991");

             Select select=new Select(driver.findElement(By.name("department")));
             select.selectByValue("AO");
             String expected="Accounting Office";
             String actual=select.getFirstSelectedOption().getText();
             System.out.println("Expected "+expected);
             System.out.println("Actual "+actual);

             Select JobTitle=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
             JobTitle.selectByIndex(2);
             JobTitle.selectByVisibleText("Manager");
             String Expected="Manager";
             String Actual=select.getFirstSelectedOption().getText();
             System.out.println("Expected "+Expected);
             System.out.println("Actual "+Actual);

             WebElement javaLanguage=driver.findElement(By.xpath("//input[@value='java']"));
             javaLanguage.click();
             System.out.println("Java language is selected "+javaLanguage.isSelected());
         //    Assert.assertTrue(javaLanguage.isSelected());

             driver.findElement(By.xpath("//button[@id='wooden_spoon']")).click();

             String VerifyMessage=driver.findElement(By.xpath("//p")).getText();
             Assert.assertEquals(VerifyMessage,"You've successfully completed registration!","Joder");


}

}
