package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartPhonePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By seeAllLink = By.xpath("//span[@class='section-title__cta-text' and text()='See All']/parent::a");
    private By firstProduct = By.cssSelector(".x-prp-top-products_grid .x-card-flex:nth-of-type(1) a.ux-action");
    public SmartPhonePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSeeAll(){
        wait.until(ExpectedConditions.elementToBeClickable(seeAllLink)).click();
    }

    //No sidebar to select screen sizes in the ebay page results, date: friday 25, april 2025

    public void clickFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }
}

