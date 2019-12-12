package com.cbt.tests.Homework4;

import com.cbt.pages.DashboardPage;
import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class TestCase1 extends TestBase {

    public  void test1() {

        LoginPage loginPage = new LoginPage();

        String username= ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");


    }
}
