package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest() {
        LoginPage loginPage = new LoginPage();

        extentLogger = report.createTest("Wrong Password Test");

        loginPage.usernameInput.sendKeys("User1");
        extentLogger.info("Enter username");
        loginPage.passwordInput.sendKeys("samepassword");
        extentLogger.info("Enter Password: somepassword");
        loginPage.loginBtn.click();
        extentLogger.info("click login button");

        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa3.vytrack.com/user/login"));
        //we put after assertions if the assertion fails, it will not send pass to report
        extentLogger.info("Wrong Password Test is passed");
    }

    @Test
    public void wrongUsernameTest(){
        //name of the test case
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter Password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("verify page url");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa3.vytrack.com/user/loginN"));

        extentLogger.info("PASS: Wrong Password Test");
    }
}
