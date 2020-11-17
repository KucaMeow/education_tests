package com.example.tests;

import com.example.tests.service.CourseService;
import com.example.tests.service.LoginService;
import com.example.tests.service.NavigationService;
import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
@Component
@Scope("singleton")
public class ApplicationManager {

    public static ApplicationManager app;

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    private NavigationService navigationService;
    private LoginService loginService;
    private CourseService courseService;

    public ApplicationManager() {
        app = this;
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        navigationService = new NavigationService(this);
        loginService = new LoginService(this);
        courseService = new CourseService(this);
    }

    public NavigationService navigation() {
        return navigationService;
    }

    public LoginService login() {
        return loginService;
    }

    public CourseService course() {
        return courseService;
    }

    @PreDestroy
    public void stop() {
        driver.quit();
    }
}
