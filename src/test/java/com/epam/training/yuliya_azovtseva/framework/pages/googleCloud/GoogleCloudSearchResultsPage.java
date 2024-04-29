package com.epam.training.yuliya_azovtseva.framework.pages.googleCloud;

import com.epam.training.yuliya_azovtseva.framework.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleCloudSearchResultsPage extends BasePage {
    @FindBy(xpath = "//a[@track-type='search-result']")
    private List<WebElement> searchResultItems;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudSearchResultsPage clickSearchResultItem(int index) {
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(ExpectedConditions.visibilityOfAllElements(searchResultItems));
        searchResultItems.get(index).click();
        return this;
    }
}
