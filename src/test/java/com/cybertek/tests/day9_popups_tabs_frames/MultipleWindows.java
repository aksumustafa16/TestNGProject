package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        // driver.quit();
    }

    @Test
    public void switchWindowsTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println(driver.getTitle());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        Thread.sleep(2000);
        System.out.println(driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
    }
}
