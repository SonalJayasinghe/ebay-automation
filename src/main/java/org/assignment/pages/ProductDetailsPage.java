package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String productTitleText;
    private String productPriceText;

    private final By productTitle =  By.xpath("//div[@data-testid='x-item-title']//span");
    private final By productPrice = By.xpath("//div[@data-testid='x-price-primary']//span");
    private final By addToCartButton = By.xpath("//a[@id='atcBtn_btn_1' and @data-testid='ux-call-to-action']");
    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        String title = driver.findElement(productTitle).getText();
        productTitleText = title.trim();
        System.out.println("Product Title: " + productTitleText);
        return productTitleText;
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        String price = driver.findElement(productPrice).getText();
        productPriceText = price.trim();
        System.out.println("Product Price: " + productPriceText);
        return productPriceText;
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getProductTitleText() {
        return productTitleText;
    }

    public String getProductPriceText() {
        return productPriceText;
    }


}
