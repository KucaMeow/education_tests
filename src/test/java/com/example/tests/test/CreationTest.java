package com.example.tests.test;

import com.example.tests.model.CourseData;
import com.example.tests.model.GroupData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreationTest extends AuthBase {

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
