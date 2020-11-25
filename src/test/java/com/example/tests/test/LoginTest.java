package com.example.tests.test;

import com.example.tests.model.AccountData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Service;

@Service
public class LoginTest extends TestBase{

    @Test
    public void loginTestWithValid() {
        AccountData accountData = AccountData.builder()
                .email("sa@pon.ru")
                .password("a123123")
                .build();
        app.navigation().openHomePage();
        app.login().login(accountData);
        Assert.assertTrue(app.login().isLoggedIn(accountData.getEmail()));
    }

    @Test
    public void loginTestWithInvalid() {
        AccountData accountData = AccountData.builder()
                .email("sa@pon.u")
                .password("a12323")
                .build();
        app.navigation().openHomePage();
        app.login().login(accountData);
        Assert.assertFalse(app.login().isLoggedIn());
    }
}
