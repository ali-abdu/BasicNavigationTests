package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

    public class DashboardPage extends BasePage {
        //no need to ecplicitly write constructor,cuz it will use it's parent constructor
        public DashboardPage(){

            PageFactory.initElements(Driver.get(),this);
        }
    }


