package com.example.tests;

import com.example.tests.model.CourseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Generator {

    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException, InterruptedException {
        XmlMapper xmlMapper = new XmlMapper();

        List<CourseData> list = new ArrayList<>(10);

        for(int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            list.add(CourseData.builder()
                    .name((new Date()).toString())
                    .description(UUID.randomUUID().toString())
                    .build());
        }

        File out = new File("output.xml");
        PrintWriter pw = new PrintWriter(new FileOutputStream(out));
        pw.println(xmlMapper.writeValueAsString(list));
        pw.flush();
        pw.close();
    }


}
