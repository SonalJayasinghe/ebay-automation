package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstName = By.xpath("//input[@name='firstName']");
    private final By lastName = By.xpath("//input[@name='lastName']");
    private final By addressLine1 = By.xpath("//input[@name='addressLine1']");
    private final By addressLine2 = By.xpath("//input[@name='addressLine2']");
    private final By city = By.xpath("//input[@name='city']");
    private final By state = By.xpath("//input[@name='stateOrProvince']");
    private final By zipCode = By.xpath("//input[@name='postalCode']");
    private final By email = By.xpath("//input[@name='email']");
    private final By confirmEmail = By.xpath("//input[@name='emailConfirm']");
    private final By contactNumber = By.xpath("//input[@name='phoneNumber']");
    private final By doneButton = By.xpath("//button[@data-action-name='ADD_ADDRESS_SUBMIT']");

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);
    }
    public void enterLastName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(name);
    }
    public void enterAddressLine1(String addr) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine1)).sendKeys(addr);
    }
    public void enterAddressLine2(String addr) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressLine2)).sendKeys(addr);
    }
    public void enterCity(String cityName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys(cityName);
    }
    public void enterState(String stateName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(state)).sendKeys(stateName);
    }
    public void enterZipCode(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zip);
    }
    public void enterEmail(String mail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(mail);
    }
    public void enterEmailConfirm(String mail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmail)).sendKeys(mail);
    }
    public void enterContactNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNumber)).sendKeys(phone);
    }
    public void clickDoneButton() {
        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
    }



}
