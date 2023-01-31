package com.cybertek.tests.day13_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExamples {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() {
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jsmith@gmail.com"));
    }
    @Test
    public void getAllHeaders() {
        //How many column we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printTableSize(){
        //How many column we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());

        //number of rows with headers
       List<WebElement> allRawsWithHeader =  driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRawsWithHeader.size());

        //number of rows without header (we prefer this)
        List<WebElement> allRawsWithoutHeader =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRawsWithoutHeader.size());
    }

    @Test
    public void getRow(){
        WebElement firstRow =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        //System.out.println(firstRow.getText());

        List<WebElement> allRaws =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= allRaws.size(); i++) {
            WebElement row =  driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
            System.out.println(row.getText());
        }



    }
}
