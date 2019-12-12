package com.cbt.tests.OldHomeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) throws InterruptedException {
     //   List<String> urls = Arrays.asList("http://practice.cybertekschool.com/", "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(5000);
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(5000);
        driver.navigate().to("http://practice.cybertekschool.com/login");
        Thread.sleep(5000);

        driver.close();
    }
}
