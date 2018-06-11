package com.lazerycode.selenium.tests;

import java.lang.System;
import com.lazerycode.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.lazerycode.selenium.page_objects.LoginPage;
import com.lazerycode.selenium.page_objects.LoginException;

public class LoginIT extends DriverBase {

    @Test
    public void loginSuccess() throws Exception {
      WebDriver driver = getDriver();
      driver.get("https://www.leboncoin.fr");
      LoginPage loginPage = new LoginPage();
      loginPage.login("digitalrys@gmail.com", "abcdefg1");
    }

    @Test(expectedExceptions = LoginException.class)
    public void loginFail() throws Exception {
      WebDriver driver = getDriver();
      driver.get("https://www.leboncoin.fr");
      LoginPage loginPage = new LoginPage();
      loginPage.login("digitalrys@gmail.com", "abcd");
    }

    @Test(expectedExceptions = LoginException.class)
    public void loginInvalidMail() throws Exception {
      WebDriver driver = getDriver();
      driver.get("https://www.leboncoin.fr");
      LoginPage loginPage = new LoginPage();
      loginPage.login("wrongMail", "abcd");
      Assert.assertEquals(loginPage.getErrorMessage(), "Cette adresse email n'est pas valide");
    }
}
