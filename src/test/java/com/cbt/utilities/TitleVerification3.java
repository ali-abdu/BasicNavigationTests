package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) throws InterruptedException {

List<String> urls= Arrays.asList("http://practice.cybertekschool.com/","http://practice.cybertekschool.com/dropdown","http://practice.cybertekschool.com/login",
        "https://luluandgeorgia.com");

        for(String url:urls){
            test(url);
        }


    }

    public static void test(String url){
        WebDriver driver=BrowserFactory.getDriver("chrome");
        driver.get(url);

        System.out.println(driver.getTitle());
        driver.close();
    }

}
