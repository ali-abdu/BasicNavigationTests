package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name="_submit")
    public WebElement submit;

    public void login(String usernameStr,String passwordStr){
        userName.sendKeys(usernameStr);
        password.sendKeys(passwordStr);
        submit.click();
    }
}
