package com.example.tests.service;

import com.example.tests.ApplicationManager;

public class NavigationService extends ServiceBase {

    public NavigationService (ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void openHomePage() {
        driver.get(settings.getBasicUrl() + "/hello");
    }
}
