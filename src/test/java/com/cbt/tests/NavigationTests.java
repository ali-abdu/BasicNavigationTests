package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class NavigationTests {
    public static void main(String[] args) throws InterruptedException {


       // WebDriver driver = BrowserFactory.getDriver("ie");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.navigate().to("https://etsy.com");
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.navigate().back();
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.navigate().forward();
        System.out.println(driver.getTitle());

        String  expected = "http://google.com";
        String actual = driver.getCurrentUrl();

        if (expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println();
        }

driver.close();

    }
}