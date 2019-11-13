package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/", "https://walmart.com",
                "https://westelm.com/");

        for(String url : urls){
            test1(url);

        }

    }




    public static void test1(String url) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get(url);
     //   String title = driver.getTitle();
//        StringBuffer sb = new StringBuffer();
//        sb.append(" " + title);
      //  System.out.println(title);
        System.out.println(driver.getTitle());
        String expected = "https://lulugandgeorgia.com";
        String actual = driver.getCurrentUrl();

        if (expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.close();


    }
}
