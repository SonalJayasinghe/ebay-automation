package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartPhonePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By seeAllLink = By.xpath("//span[@class='section-title__cta-text' and text()='See All']/parent::a");

    public SmartPhonePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSeeAll(){
        wait.until(ExpectedConditions.elementToBeClickable(seeAllLink)).click();
    }
}
