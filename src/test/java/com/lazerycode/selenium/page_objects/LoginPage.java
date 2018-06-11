package com.lazerycode.selenium.page_objects;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.concurrent.TimeUnit;
import com.lazerycode.selenium.page_objects.LoginException;

public class LoginPage {

    private final RemoteWebDriver driver = DriverBase.getDriver();

    private Query loginPopInBtn = new Query(By.cssSelector(".header_aside"), driver);
    private Query loginField = new Query(By.name("st_username"), driver);
    private Query passwordField = new Query(By.name("st_passwd"), driver);
    private Query submitBtn = new Query(By.cssSelector("section.connexion-form input[type='submit']"), driver);
    private Query loginProfile = new Query(By.xpath("//div[@data-qa-id='profilarea-login']"), driver);
    private Query errorMessage = new Query(By.xpath("//span[@class='YAIEF']"), driver);

    public LoginPage() throws Exception {
    }

    public void openPopInLogin() {
      loginPopInBtn.findWebElement().click();
    }

    public LoginPage setLogin(String loginStr) {
      loginField.findWebElement().clear();
      loginField.findWebElement().sendKeys(loginStr);
      return this;
    }

    public LoginPage setPassword(String passwordStr) {
      passwordField.findWebElement().clear();
      passwordField.findWebElement().sendKeys(passwordStr);
      return this;
    }

    public void submitForm() {
      submitBtn.findWebElement().click();
    }

    public void login(String loginStr, String passwordStr) throws Exception {
      try
      {
        this.openPopInLogin();
        TimeUnit.SECONDS.sleep(2);
        this.setLogin(loginStr);
        TimeUnit.SECONDS.sleep(2);
        this.setPassword(passwordStr);
        TimeUnit.SECONDS.sleep(2);
        this.submitForm();
        TimeUnit.SECONDS.sleep(5);
        loginProfile.findWebElement();
      }
      catch(Exception e)
      {
        throw new LoginException("can't login with userName " + loginStr + " more information : " + e.getMessage());
      }
    }

    public String getErrorMessage() {
      return errorMessage.findWebElement().getText();
    }

}
