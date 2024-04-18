package com.epam.training.yuliya_azovtseva.webdriver.task2.test;

import com.epam.training.yuliya_azovtseva.webdriver.task2.page.PasteBinMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;
    protected PasteBinMainPage pasteBinMainPage = new PasteBinMainPage(driver);

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
