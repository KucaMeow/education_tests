package com.example.tests.test;

import com.example.tests.model.AccountData;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

public class AuthBase extends TestBase {

    @Before
    public void setUp() throws IOException {
        AccountData accountData = AccountData.builder()
                .email(settings.getLogin())
                .password(settings.getPassword())
                .build();
        app.navigation().openHomePage();
        app.login().login(accountData);
    }
}
