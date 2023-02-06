package com.cybertek.tests.day18_review;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

public class verifyContactInfoPage extends TestBase {

    @Test
    public void contactDetailsTest() throws InterruptedException {

        extentLogger = report.createTest("Contact Info Veriricaiton");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username" + username);
        extentLogger.info("password" + password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        new DashboardPage().navigateToModule("Customers","Contacts");
        extentLogger.info("Navigate to Customers -- Contacts");

        ContactsPage contactsPage = new ContactsPage();

        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

    }
}
