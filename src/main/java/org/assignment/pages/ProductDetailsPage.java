package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By productTitle =  By.xpath("//div[@data-testid='x-item-title']//span");
    private By productPrice = By.xpath("//div[@data-testid='x-price-primary']//span");
    private By addToCartButton = By.xpath("//a[@id='atcBtn_btn_1' and @data-testid='ux-call-to-action']");
    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        String title = driver.findElement(productTitle).getText();
        System.out.println("Product Title: " + title.trim());
        return title.trim();
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        String price = driver.findElement(productPrice).getText();
        System.out.println("Product Price: " + price.trim());
        return price.trim();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }


}
