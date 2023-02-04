package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RepeatOptionTest extends TestBase {
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage = new DashboardPage();
        BrowserUtils.waitFor(3);
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(10);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify days rb is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify days is NOT checked");
    }


}
