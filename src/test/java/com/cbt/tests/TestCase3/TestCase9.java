package com.cbt.tests.TestCase3;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class TestCase9 {
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("https://practice-cybertekschool.herokuapp.com/");
//        driver.findElement(By.linkText("Status Codes")).click();
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException{
        Thread.sleep(2000);
       driver.quit();
    }

//    @DataProvider
//    public Object[] getData(){
//        Object[] data = {200,301,404,500};
//        return data;
//    }
//    @DataProvider
//    public Object[][] dataProv1(){
//        Object[][] data = {{200,"This page returned a 200 status code"}, {301,"This page returned a 301 status code"}, {404,"This page returned a 404 status code"},{500,"This page returned a 500 status code"}};
//
//        return data;

    //  }



//        @Test
//        public void Method1(int num)
//        {
//            driver.findElement(By.linkText(Integer.toString(num))).click();
//            String expected= "This page returned a "+num+" status code";
//            String Actual= driver.findElement(By.xpath("//p")).getText();
//            Assert.assertTrue(Actual.startsWith(expected));
//
//        }

    @DataProvider(name = "data-provider")
    public Object[] dataProviderMethod() {

        return new Object[] { "200" ,  "301" , "404", "500" };
    }
    @Test(dataProvider = "data-provider")
    public void test9(String data){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Status Codes']")).click();
        driver.findElement(By.xpath("//a[.='"+data+"']")).click();
        String expected = driver.findElement(By.xpath("//p")).getText();
        String actual = "This page returned a "+data+" status code";
        Assert.assertTrue(expected.contains(actual));
        System.out.println(actual+" actual");
        System.out.println(expected +" expected");

    }



}

