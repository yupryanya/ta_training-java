package com.epam.training.yuliya_azovtseva.webdriver.task1.test;

import org.junit.jupiter.api.Test;

public class PasteBinTask extends TestBase {

    @Test
    void fillTheFormWithValues() {
        pasteBinMainPage
                .openPage()
                .setPasteText("Hello from WebDriver")
                .setPasteName("helloweb")
                .setPasteExpiration("10 Minutes")
                .submitButtonClick();
    }
}
