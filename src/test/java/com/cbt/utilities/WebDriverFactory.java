package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

WebDriver driver=null;
switch (browserType.toLowerCase()) {
    case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
    case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;

    case "ie":
        WebDriverManager.iedriver().setup();
        driver=new InternetExplorerDriver();
        break;

    case "safari":
         driver=null;


}
        return driver;


    }
}