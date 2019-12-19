package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage  {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(xpath="(//select[@id='recurrence-repeats-view745'])/option[2]")
    public WebElement Weekly;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath="(//input[@placeholder='Choose a date'])[3]")
    public WebElement byChoosedate;

//    @FindBy(xpath = "//select[@class='ui-datepicker-year']/option[@value='2021']")
    @FindBy(xpath="//select[@data-handler='selectYear']")
    public WebElement byClickOnYear;
    @FindBy(xpath="(//table/tbody/tr/td/a)[18]")
    public WebElement Dates;

//    @FindBy(xpath = "//select[@class='ui-datepicker-month']/option[11]")
    @FindBy(xpath="//select[@data-handler='selectMonth']")
    public WebElement ByMonth;

//    @FindBy(xpath="//a[text()='18']")
    @FindBy(xpath="//tr[3]//td[5]")
    public WebElement date18;

    @FindBy(xpath = "(//input[@type='checkbox'])")
    public WebElement AllDayEvent;

    @FindBy(xpath = "//select/option[@value='daily']")
    public WebElement Daily;

    @FindBy(xpath="//input[@checked='checked']")
    public WebElement RepeatEvery;

    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    public WebElement Summary;

    @FindBy(xpath="(//input[@class='recurrence-subview-control__number'])[7]")
    public  WebElement nOfOccurences;

    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}
