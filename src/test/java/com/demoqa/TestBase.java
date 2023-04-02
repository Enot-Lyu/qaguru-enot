package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.timeout = 8000;
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true; //браузер не закрывать
    }
}
