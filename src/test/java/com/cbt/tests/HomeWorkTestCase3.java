package com.cbt.tests;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWorkTestCase3 {

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

    @Test(enabled = false)
    public void test1() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();
        System.out.println(target);

        String actual = driver.findElement(By.xpath("//div[@class='btn btn-link dropdown-toggle']")).getText();
        String expected = "Options";
        Assert.assertEquals(actual, expected, "Did not match!");
        System.out.println("actual result is: " + actual);
        System.out.println("expected result is: " + expected);

    }

    @Test(enabled = false)
    public void test2() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();

        String act = driver.findElement(By.xpath("//input[@value='1']")).getAttribute("value");
        String exp = "1";
        Assert.assertEquals(act, exp, "Did not match!");
        System.out.println("actual result: " + act);
        System.out.println("expected result: " + exp);

    }

    @Test(enabled = false)
    public void test3() {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();

        WebElement element = driver.findElement(By.xpath("(//div[@class='btn-group'])[2]"));
        String actual = element.getText();
        Assert.assertEquals(actual, "25");
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).build().perform();
        target.click();
Thread.sleep(3000);
         List<WebElement> allRows = driver.findElements(By.xpath("//tbody/tr"));
         String Rowsize="Total Of "+allRows.size()+" Records";
         String actual=driver.findElement(By.xpath("//label[contains(@class,'dib')][3]")).getText();

        Assert.assertEquals(actual,Rowsize);
        //Assert.assertTrue(actual.contains(Rowsize));
        System.out.println("actual is: "+actual);
        System.out.println("expected is "+Rowsize);

        }
        @Test
    public void test5() throws InterruptedException {
            driver.get("https://qa1.vytrack.com/user/login");
            driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
            driver.findElement(By.id("_submit")).click();

            WebElement source = driver.findElement(By.xpath("(//span)[27]"));
            WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
            actions.moveToElement(target).perform();
            target.click();

           Thread.sleep(2000);
           WebElement dr=driver.findElement(By.xpath("//button/input[@type='checkbox']"));
           dr.click();
           Assert.assertTrue(dr.isSelected());
           System.out.println("All calender events were selected "+dr.isSelected());
    }

    @Test(enabled = false)
    public void test6() throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();

        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath("//tr[@class='grid-row row-click-action'][13]"));
        element.click();
        System.out.println(element.getText());

         Thread.sleep(2000);

        String actual=driver.findElement(By.xpath("//div[@class='section-content']")).getText();
        String expected="Title\n" +
              "Testers Meeting\n" +
              "Description\n" +
              "This is a a weekly testers meeting\n" +
              "Start\n" +
              "Nov 27, 2019, 9:30 PM\n" +
              "End\n" +
              "Nov 27, 2019, 10:30 PM\n" +
              "All-day Event\n" +
              "No\n" +
              "Organizer\n" +
              "Stephan Haley\n" +
              "Guests\n" +
              "Tom Smith - Required\n" +
              "Recurrence\n" +
              "Weekly every 1 week on Wednesday\n" +
              "Call Via Hangout\n" +
              "No";
        Assert.assertEquals(actual,expected);
        System.out.println("actual is: \n"+actual);
        System.out.println("expected is: \n"+expected);

    }

    }








