package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private final By cartProductTitle = By.xpath("//h3[@class='item-title text-truncate-multiline black-link lines-2']");
    private final By cartProductPrice = By.xpath("//div[@class='item-price font-title-3']//span");
    private final By totalPrice = By.xpath("//div[@class='val-col total-row']//span");
    private final By checkout = By.xpath("//button[@data-test-id='cta-top']");
    private final By guestButton = By.id("gxo-btn");
    private final By authiframe = By.id("auth-iframe");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public String verifyProductName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductTitle));
        String productTitle = driver.findElement(cartProductTitle).getText();
        return productTitle.trim();
    }

    public String verifyProductPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductPrice));
        String productPrice = driver.findElement(cartProductPrice).getText();
        return productPrice.trim();
    }

    public void getSubtotalPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        String subtotal = driver.findElement(totalPrice).getText();
        System.out.println("Subtotal Price: " + subtotal.trim());
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    //there are two buttons 'Continue as guest' & 'Checkout as guest' appeared randomly on the checkout page.
    //although buttons has a stable ID ('gxo-btn'), the continue as.. button can directly click but Checkout cannot because its appeared in another iframe html
    //so i had build this function to work for both scenarios

    public void clickGuestButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(guestButton)).click();

        } catch (Exception mainPageError) {
            try {
                WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(authiframe));
                driver.switchTo().frame(iframe);

                wait.until(ExpectedConditions.elementToBeClickable(guestButton)).click();
                driver.switchTo().defaultContent();

            } catch (Exception iframeError) {
                throw new RuntimeException("Guest button not found in either main page or iframe.");
            }
        }
    }


}
