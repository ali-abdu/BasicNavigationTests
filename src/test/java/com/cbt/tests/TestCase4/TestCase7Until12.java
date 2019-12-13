package com.cbt.tests.TestCase4;

import com.cbt.pages.*;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class TestCase7Until12 extends TestBase{


    @BeforeMethod
    public void before(){
        LoginPage loginPage = new LoginPage();

        String username= ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

    }
    @Test
    public  void test7() {

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.AllDayEvent.click();
        Assert.assertTrue(createCalendarEventsPage.AllDayEvent.isDisplayed());

        Assert.assertFalse(createCalendarEventsPage.startTime.isDisplayed());
        Assert.assertFalse(createCalendarEventsPage.endTime.isDisplayed());

        Assert.assertTrue(createCalendarEventsPage.startDate.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.endDate.isDisplayed());
    }

    @Test
    public void test8(){

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        Assert.assertTrue(createCalendarEventsPage.Daily.isSelected());

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeatOptions.click();

        Select stateList = new Select(createCalendarEventsPage.repeatOptions);
        List<WebElement> options = stateList.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
            createCalendarEventsPage.waitUntilLoaderScreenDisappear();
            Assert.assertTrue(option.isDisplayed());
        }
    }
    @Test
    public void test9(){

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
        Assert.assertTrue(createCalendarEventsPage.RepeatEvery.isSelected());
        Assert.assertTrue(createCalendarEventsPage.never.isSelected());
        Assert.assertTrue(createCalendarEventsPage.Summary.isDisplayed());
        System.out.println(createCalendarEventsPage.Summary.getText());
    }

    @Test
    public void test10(){
        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        createCalendarEventsPage.after.click();
        createCalendarEventsPage.nOfOccurences.sendKeys("10");
        createCalendarEventsPage.nOfOccurences.click();

        Assert.assertTrue(createCalendarEventsPage.Summary.isDisplayed());
        System.out.println(createCalendarEventsPage.Summary.getText());

    }
    @Test
    public  void test11(){

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        createCalendarEventsPage.by.click();
        createCalendarEventsPage.byChoosedate.click();

        Select year=new Select(createCalendarEventsPage.byClickOnYear);
        year.selectByVisibleText("2021");
        System.out.println(year.getFirstSelectedOption().getText());
        Select month=new Select(createCalendarEventsPage.ByMonth);
        month.selectByVisibleText("Nov");
        System.out.println(month.getFirstSelectedOption().getText());



    }


}
