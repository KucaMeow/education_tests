package com.example.tests.test;

import com.example.tests.model.AccountData;
import com.example.tests.model.CourseData;
import com.example.tests.model.GroupData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
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

//    @Test
//    public void creationTest() {
//        CourseData courseData = CourseData.builder()
//                .name((new Date()).toString())
//                .description("TEST_DESCRIPTION")
//                .build();
//        app.navigation().openHomePage();
//        app.course().addNewCourse(courseData);
//
//        CourseData created = GroupData.getLast();
//
//        Assert.assertEquals(courseData, created);
//    }
//
//    @Test
//    public void secondTest() {
//        CourseData courseData = CourseData.builder()
//                .name((new Date()).toString()+UUID.randomUUID().toString())
//                .description("TEST_DESCRIPTION")
//                .build();
//
//        app.navigation().openHomePage();
//        app.course().addNewCourse(courseData);
//
//        CourseData created = GroupData.getLast();
//
//        Assert.assertEquals(courseData, created);
//    }



    @Test
    public void generatedTest() throws IOException {
        for(CourseData cd : getCousesFromFile("output.xml")) {
            app.navigation().openHomePage();
            app.course().addNewCourse(cd);

            CourseData created = GroupData.getLast();
            Assert.assertEquals(cd, created);
        }
    }

    private List<CourseData> getCousesFromFile(String filename) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        List<CourseData> list = xmlMapper.readValue(new File(filename), new TypeReference<List<CourseData>>() {});

        return list;
    }
}
