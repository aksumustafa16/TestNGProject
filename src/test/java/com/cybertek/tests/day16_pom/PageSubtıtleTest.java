package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtıtleTest extends TestBase {

    /**
     * Test case
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Lanchpad
     * Go to activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        //Same thing with Thread.sleep(second: 3000)
        //BrowserUtils.waitFor(3);
        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();

        BrowserUtils.waitFor(2);
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(2);

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(2);
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events");

    }
}
