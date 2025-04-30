package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartPhonePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By filterOption =  By.xpath("//button[@type='button' and contains(@class,'filter-button') and contains(@class,'brwr__all-filters')]");
    private final By screenSizeFilter = By.xpath("//button[h3[@aria-label='Screen Size']]");
    private final By screenSizeCheckBox = By.xpath("//label[normalize-space()='6 in or More']/preceding-sibling::span");
    private final By applyButton = By.xpath("//button[contains(@class,'btn-submit') and contains(normalize-space(),'Apply')]");
    private final By firstItem = By.xpath("(//a[contains(@class,'brwrvr__item-card__image-link')])[1]");

    public SmartPhonePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickFilterOption() {
        wait.until(ExpectedConditions.elementToBeClickable(filterOption)).click();
    }

    public void clickScreenSizeFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(screenSizeFilter)).click();
    }

    public void clickScreenSizeCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(screenSizeCheckBox)).click();
    }

    public void clickApplyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    public void clickFirstItem() {
        wait.until(ExpectedConditions.elementToBeClickable(firstItem)).click();
    }



}

