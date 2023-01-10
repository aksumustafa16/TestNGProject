package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch frames
        //1.Switch by USING NAME OR ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        //goes back to first frame(main html)
        //goes back to first frame, useful when
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        //2. USING INDEX
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith WITH INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.USING WEBELEMENT
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith WITH WEBELEMENT");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 children left middle right
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to right  frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
