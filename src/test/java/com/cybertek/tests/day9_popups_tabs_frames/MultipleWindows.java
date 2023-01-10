package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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

        //System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("windowHandles.size() = " + windowHandles.size());

        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }
        System.out.println("Title after switching window :" + driver.getTitle());

        driver.switchTo().window(currentWindowHandle);
        System.out.println(driver.getTitle());

    }

    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");

        Set<String> windowHandles = driver.getWindowHandles();
    }
}
