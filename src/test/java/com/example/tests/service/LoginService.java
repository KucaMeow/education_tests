package com.example.tests.service;

import com.example.tests.ApplicationManager;
import com.example.tests.model.AccountData;
import org.openqa.selenium.By;

public class LoginService extends ServiceBase{

    public LoginService (ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData accountData) {
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(accountData.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector(".btn-dark")).click();
    }
}
