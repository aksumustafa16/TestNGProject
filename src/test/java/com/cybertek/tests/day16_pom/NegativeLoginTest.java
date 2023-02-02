package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Test
    public void wrongPasswordTest() {

        loginPage.usernameInput.sendKeys("User1");
        loginPage.passwordInput.sendKeys("samepassword");
        loginPage.loginBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa3.vytrack.com/user/login"));
    }

    @Test
    public void wrongUsernameTest(){
        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://qa3.vytrack.com/user/login"));
    }
}
