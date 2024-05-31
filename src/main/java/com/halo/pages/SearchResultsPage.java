package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private By elementsOnSearchResult = By.xpath("//div[@class='ui-search-result__wrapper']//a[1]");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    protected WebElement filterSearchResult(By locator, int elementIndex, String propertyValue, String attributeProperty) {
        List<WebElement> elements = findElements(locator);
        List<WebElement> displayedElements = elements.stream()
                .filter(element -> !propertyValue.equals(element.getAttribute(attributeProperty)))
                .toList();

        return displayedElements.get(elementIndex);
    }

    public void selectElementByIndex(int elementIndex, String propertyValue, String attributeProperty) {
        clickByJs(filterSearchResult(elementsOnSearchResult, elementIndex, propertyValue, attributeProperty));
    }

}
