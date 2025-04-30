package org.assignment.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By cellPhonesAndAccessoriesLink = By.linkText("Cell Phones & Accessories");
    private final By cellPhonesAndSmartPhones = By.linkText("Cell Phones & Smartphones");

    public ElectronicsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickCellPhonesAndAccessories() {
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesAndAccessoriesLink)).click();
    }

    public void clickCellPhonesAndSmartPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(cellPhonesAndSmartPhones)).click();
    }
}
