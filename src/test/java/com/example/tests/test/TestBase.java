package com.example.tests.test;

import com.example.tests.ApplicationManager;
import com.example.tests.Settings;
import com.example.tests.TestsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestsApplication.class)
public class TestBase {

    @Autowired
    protected ApplicationManager app;
    @Autowired
    Settings settings;

    @Test
    public void doNothing(){}

}
