package com.cbt.tests.OldHomeworks;

import com.cbt.utilities.WebDriverFactory;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    private static WebDriverFactory WebdriverFactory;

    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/", "https://walmart.com",
                "https://westelm.com/");

        for(String url : urls){
            test1(url);

        }

    }




    public static void test1(String url) throws InterruptedException {
        WebDriver driver = WebdriverFactory.getDriver("chrome");
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
