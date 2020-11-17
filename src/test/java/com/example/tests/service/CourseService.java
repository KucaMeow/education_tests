package com.example.tests.service;

import com.example.tests.ApplicationManager;
import com.example.tests.model.CourseData;
import org.openqa.selenium.By;

public class CourseService extends ServiceBase{

    public CourseService (ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addNewCourse(CourseData courseData) {
        driver.findElement(By.linkText("Редактор")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(courseData.getName());
        driver.findElement(By.id("desc")).clear();
        driver.findElement(By.id("desc")).sendKeys(courseData.getDescription());
        driver.findElement(By.cssSelector(".btn:nth-child(4)")).click();
    }
}
