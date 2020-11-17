package com.example.tests.service;

import com.example.tests.ApplicationManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class ServiceBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    public ServiceBase(ApplicationManager applicationManager) {
        driver = applicationManager.getDriver();
        vars = applicationManager.getVars();
        js = applicationManager.getJs();
    }
}
