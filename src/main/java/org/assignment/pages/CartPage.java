package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;


    private By cartProductTitle = By.xpath("//h3[@class='item-title text-truncate-multiline black-link lines-2']");
    private By cartProductPrice = By.xpath("//div[@class='item-price font-title-3']//span");
    private By totalPrice = By.xpath("//div[@class='val-col total-row']//span");
    private By checkout = By.xpath("//button[@data-test-id='cta-top']");
    private By userIDInput = By.xpath("//input[@id='userid']");
    private By guestButton = By.xpath("//button[@id='gxo-btn']");

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

    //there is an issue with this input textbox, thats why i cleared things first
    public void enterGuestEmail(String guestEmail) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(userIDInput));
        input.clear();
        input.click();
        input.sendKeys(guestEmail);
    }

    public void clickGuestButton() {
        wait.until(ExpectedConditions.elementToBeClickable(guestButton)).click();
    }


}
