package com.cybertek.tests.day12_action_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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

        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions --> class that contains all the use interactions
        //how to create actions object /passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform() --> perform the action, complete the action
        //moveToElement --> move your mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed(),"verify View profile link is displayed");
    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        Actions actions = new Actions(driver);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        Thread.sleep(1000);

        //actions.dragAndDrop(drag,drop).perform();

        //drag and drop without draganddrop method

        //if we are chaining actions we add build() method before perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();

    }
}
