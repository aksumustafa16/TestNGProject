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
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement cell : allCellInOneRow) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void getASingleCellByIndex(){
        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[5]"));
        System.out.println(singleCell.getText());
    }

    @Test
    public void PrintAllCellByIndex(){
        int rowNumber = getNumberofRows();
        int colNumber = getNumberofColumns();

        System.out.println("colNumber = " + colNumber);
        System.out.println("rowNumber = " + rowNumber);

        //table[@id='table1']/tbody/tr[1]/td[1]

        //iterate through each row on the table
        for (int i = 1 ; i <= rowNumber ; i++) {
            for (int j = 1; j <= colNumber ; j++) {

                //String cellXpath = "table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]";
                //System.out.println(cellXpath);

                WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
                                                                            //table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"
                System.out.println(cell.getText());
            }
        }
    }

    private int getNumberofColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberofRows() {
        List<WebElement> allRaws =  driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRaws.size();
    }
}
