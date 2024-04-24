package com.epam.training.yuliya_azovtseva.webdriver.task3.test;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.GoogleCloudMainPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.GoogleCloudSearchResultsPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.cloudCalculator.GoogleCloudPricingCalculatorPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail.YopmailEmailGeneratorPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.cloudCalculator.EmailEstimateFormPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail.YopmailMailboxPage;
import com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail.YopmailMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(driver);
    GoogleCloudSearchResultsPage googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
    GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);
    EmailEstimateFormPage emailEstimateFormPage = new EmailEstimateFormPage(driver);
    YopmailEmailGeneratorPage yopmailEmailGeneratorPage = new YopmailEmailGeneratorPage(driver);
    YopmailMainPage yopmailMainPage = new YopmailMainPage(driver);
    YopmailMailboxPage yopmailMailboxPage = new YopmailMailboxPage(driver);

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