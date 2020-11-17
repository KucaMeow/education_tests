package com.example.tests.test;

import com.example.tests.model.AccountData;
import com.example.tests.model.CourseData;
import com.example.tests.model.GroupData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginAndCourseCreationTest extends TestBase{

    public LoginAndCourseCreationTest() {
        super();
    }

    @Test
    public void loginTest() {
        AccountData accountData = AccountData.builder()
                .email("sa@pon.ru")
                .password("a123123")
                .build();
        app.navigation().openHomePage();
        app.login().login(accountData);

    }

    @Test
    public void creationTest() {
        CourseData courseData = CourseData.builder()
                .name("TASK 4 TEST")
                .description("TEST_DESCRIPTION")
                .build();
        app.navigation().openHomePage();
        app.course().addNewCourse(courseData);

        CourseData created = GroupData.getLast();

        Assert.assertEquals(courseData, created);
    }

    @Test
    public void secondTest() {
        CourseData courseData = CourseData.builder()
                .name(UUID.randomUUID().toString())
                .description("TEST_DESCRIPTION")
                .build();

        app.navigation().openHomePage();
        app.course().addNewCourse(courseData);

        CourseData created = GroupData.getLast();

        Assert.assertEquals(courseData, created);
    }
}
