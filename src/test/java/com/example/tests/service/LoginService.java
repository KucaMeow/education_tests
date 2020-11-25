package com.example.tests.service;

import com.example.tests.ApplicationManager;
import com.example.tests.model.AccountData;
import org.openqa.selenium.By;

public class LoginService extends ServiceBase{

    public LoginService (ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AccountData accountData) {
        if(isLoggedIn()) {
            if(isLoggedIn(accountData.getEmail())) return;
            logout();
        }
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(accountData.getEmail());
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys(accountData.getPassword());
        driver.findElement(By.cssSelector(".btn-dark")).click();
    }

    public void logout() {
        driver.get(settings.getBasicUrl() + "/logout");
        driver.get(settings.getBasicUrl() + "/");
    }

    public boolean isLoggedIn() {
        driver.get(settings.getBasicUrl() + "/login");
        String title = driver.getTitle();
        driver.get(settings.getBasicUrl() + "/");
        return title.equals("Authed");
    }

    public boolean isLoggedIn(String email) {
        driver.get(settings.getBasicUrl() + "/login");
        String email1 = driver.findElement(By.id("email")).getText();
        driver.get(settings.getBasicUrl() + "/");
        return email1.equals(email);
    }
}
