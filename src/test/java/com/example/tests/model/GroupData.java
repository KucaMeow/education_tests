package com.example.tests.model;

import com.example.tests.ApplicationManager;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

public class GroupData {

    public static CourseData getLast() {
        ApplicationManager.app.getDriver().get("http://localhost/courses");
        String href = ApplicationManager.app.getDriver().findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]/a")).getAttribute("href");
        ApplicationManager.app.getDriver().get(href);
        String name = ApplicationManager.app.getDriver().findElement(By.xpath("/html/body/h3")).getText();
        String desc = ApplicationManager.app.getDriver().findElement(By.xpath("/html/body/small")).getText();
        return CourseData.builder().description(desc).name(name).build();
    }
}
