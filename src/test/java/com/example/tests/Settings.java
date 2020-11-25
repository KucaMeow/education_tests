package com.example.tests;

import com.example.tests.model.AccountData;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Data
@Component
public class Settings {

    public Settings() {
        try {
            Settings s = (new XmlMapper())
                    .readValue(new File("settings.xml"), Settings.class);
            this.basicUrl = s.basicUrl;
            this.login = s.login;
            this.password = s.password;
        } catch (Exception e) {}
    }

    private String basicUrl;
    private String login;
    private String password;
}
