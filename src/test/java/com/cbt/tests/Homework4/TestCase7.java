package com.cbt.tests.Homework4;

import com.cbt.pages.CalendarEventsPage;
import com.cbt.pages.CreateCalendarEventsPage;
import com.cbt.pages.DashboardPage;
import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase7 extends TestBase {
    @Test
    public  void test7() {

        LoginPage loginPage = new LoginPage();

        String username= ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        // this line is for waiting until the page load completes
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.AllDayEvent.click();
        Assert.assertTrue(createCalendarEventsPage.AllDayEvent.isDisplayed());

        BrowserUtils.waitFor(3);

        Assert.assertFalse(createCalendarEventsPage.startTime.isDisplayed());
        Assert.assertFalse(createCalendarEventsPage.endTime.isDisplayed());

        Assert.assertTrue(createCalendarEventsPage.startDate.isDisplayed());
        Assert.assertTrue(createCalendarEventsPage.endDate.isDisplayed());
    }

    @Test
    public void test8(){

        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("store_manager_username");
        String password=ConfigurationReader.get("store_manager_password");
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());
       Assert.assertTrue(createCalendarEventsPage.Daily.isSelected());

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.Daily.click();
        Assert.assertTrue(createCalendarEventsPage.Repeats.isDisplayed());
        System.out.println(createCalendarEventsPage.Repeats.getText());





    }
}
