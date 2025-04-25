package org.assignment.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By electronicsTab = By.xpath("//li[contains(@class,'vl-flyout-nav__js-tab')]//a[text()='Electronics']");
    //private By cellPhonesLink = By.linkText("Cell Phones & Smartphones"); - not available on the page, date: friday 25, april 2025
    private By cellPhonesLink = By.linkText("Smartphones and accessories");




    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openHome(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.urlContains("ebay.com"));
    }

    public void goToCellPhones() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(electronicsTab));
        new Actions(driver).moveToElement(menu).perform();
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesLink)).click();
    }

}
