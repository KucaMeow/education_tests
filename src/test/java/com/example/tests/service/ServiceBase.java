package com.example.tests.service;

import com.example.tests.ApplicationManager;
import com.example.tests.Settings;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class ServiceBase {

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;
    protected Settings settings;

    public ServiceBase(ApplicationManager applicationManager) {
        driver = applicationManager.getDriver();
        vars = applicationManager.getVars();
        js = applicationManager.getJs();
        settings = new Settings();
    }
}
