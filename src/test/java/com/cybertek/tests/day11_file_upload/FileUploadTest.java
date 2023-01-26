package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys("C:\\Users\\aksumustafa16\\Desktop\\file.txt");

        driver.findElement(By.id("file-submit")).click();

        WebElement text = driver.findElement(By.id("uploaded-files"));

        String actualText = text.getText();

        Assert.assertEquals(actualText,"file.txt");
    }
}
