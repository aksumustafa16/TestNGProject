package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Test
    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");
        
    }

    @Test
    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");

    }


}
