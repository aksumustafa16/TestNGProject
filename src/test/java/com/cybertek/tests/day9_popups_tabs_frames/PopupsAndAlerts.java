package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=4c754");

        //locate and click Confirm button
        driver.findElement(By.id("j_idt343:j_idt344")).click();
        driver.findElement(By.xpath("//button[.='Yes']")).click();
    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //locate click the Click For JS alert button
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert windows
        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);
        //click OK button on the alert
        alert.accept();

        //locate and Click For JS Confirm button
        driver.findElement(By.xpath("//button[2]")).click();

        Thread.sleep(2000);
        alert.dismiss();

        //Click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Mike Smith");
        Thread.sleep(5000);
        alert.accept();
    }
}
