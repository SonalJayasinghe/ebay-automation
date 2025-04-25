package org.assignment.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstName = By.xpath("//input[@name='firstName']");
    private By lastName = By.xpath("//input[@name='lastName']");
    private By addressLine1 = By.xpath("//input[@name='addressLine1']");
    private By addressLine2 = By.xpath("//input[@name='addressLine2']");
    private By city = By.xpath("//input[@name='city']");
    private By state = By.xpath("//input[@name='stateOrProvince']");
    private By zipCode = By.xpath("//input[@name='postalCode']");
    private By email = By.xpath("//input[@name='email']");
    private By confirmEmail = By.xpath("//input[@name='emailConfirm']");
    private By contactNumber = By.xpath("//input[@name='phoneNumber']");
    private By doneButton = By.xpath("//button[@data-action-name='ADD_ADDRESS_SUBMIT']");

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
