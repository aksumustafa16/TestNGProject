package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    @BeforeMethod
    public void setUpMethod(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit;
    }

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=4c754");
        driver.quit();
    }
}
