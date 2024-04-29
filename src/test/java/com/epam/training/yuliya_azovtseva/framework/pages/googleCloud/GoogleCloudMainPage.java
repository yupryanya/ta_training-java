package com.epam.training.yuliya_azovtseva.framework.pages.googleCloud;

import com.epam.training.yuliya_azovtseva.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.training.yuliya_azovtseva.framework.config.App.config;

public class GoogleCloudMainPage extends BasePage {
    private static final String URL = config.webUrl();

    @FindBy(xpath = "//div[div[span[text()='\uE8B6']]]")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public void searchWithMainSearchInput(String value) {
        waitAndClickElement(searchIcon);
        searchInput.sendKeys(value);
        searchInput.submit();
        searchInput.click();
    }
}
