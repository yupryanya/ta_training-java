package com.epam.training.yuliya_azovtseva.webdriver.task1.test;

import com.epam.training.yuliya_azovtseva.webdriver.task1.page.PasteBinMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected static WebDriver driver;
    PasteBinMainPage pasteBinMainPage = new PasteBinMainPage(driver);

    @BeforeAll
    static void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void quitBrowser() {
        driver.quit();
    }
}
