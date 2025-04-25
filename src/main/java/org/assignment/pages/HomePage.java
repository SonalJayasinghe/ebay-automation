package org.assignment.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By electronicsTab = By.xpath("//li[contains(@class,'vl-flyout-nav__js-tab')]//a[text()='Electronics']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openHome(String url) {
        driver.get(url);
        wait.until(ExpectedConditions.urlContains("ebay.com"));
    }

    public void goToElectronicsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsTab)).click();
    }

}
