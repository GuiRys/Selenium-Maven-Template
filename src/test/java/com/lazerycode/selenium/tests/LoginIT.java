package com.lazerycode.selenium.tests;

import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.lazerycode.selenium.page_objects.LoginPage;

public class LoginIT extends DriverBase {

    @Test
    public void loginSuccess() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://www.leboncoin.fr");
        driver.manage().window().setSize(new Dimension(1680, 1050));
        LoginPage loginPage = new LoginPage();
        loginPage.login("digitalrys@gmail.com", "abcdefg1");
    }
}
