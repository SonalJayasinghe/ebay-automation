package org.assignment.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By electronicsTab = By.linkText("Electronics");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openHome(String url) {
        driver.get(url);
    }

    public void goToElectronicsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(electronicsTab)).click();
    }

}
