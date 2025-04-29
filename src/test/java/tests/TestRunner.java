package tests;

import org.assignment.pages.*;
import org.assignment.pages.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestRunner extends InitTest{

    @DataProvider(name = "guestData")
    public Object[][] guestData() {
        return new Object[][] {
                { "Khann", "Jabawi",
                        "No. 101, Binary Road", "Johnson Kanda",
                        "Colombo", "Western", "10600",
                        "abc@abc.com", "abc@abc.com",
                        "71111111111" },
        };
    }

    private HomePage homePage;
    private ElectronicsPage electronicsPage;
    private SmartPhonePage smartPhonePage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUpPages() {
        homePage            = new HomePage(driver, wait);
        electronicsPage     = new ElectronicsPage(driver, wait);
        smartPhonePage      = new SmartPhonePage(driver, wait);
        productDetailsPage  = new ProductDetailsPage(driver, wait);
        cartPage            = new CartPage(driver, wait);
        checkoutPage        = new CheckoutPage(driver, wait);
    }

    @Test(priority = 1)
    public void openHomeTest() {
        homePage.openHome("https://www.ebay.com/");
        Assert.assertTrue(driver.getCurrentUrl().contains("ebay.com"), "URL should be ebay.com");
    }

    @Test(priority = 2)
    public void navigateToElectronicsTest() {
        homePage.goToElectronicsPage();
    }

    @Test(priority = 3)
    public void selectCellPhonesAndSmartPhonesTest() {
        electronicsPage.clickCellPhonesAndAccessories();
        electronicsPage.clickCellPhonesAndSmartPhones();
    }

    //there is no see more button as mentioned in the assignment pdf
    //sometimes this filter button may not visible
    @Test(priority = 4)
    public void applyScreenSizeFilterTest() {
        smartPhonePage.clickFilterOption();
        smartPhonePage.clickScreenSizeFilter();
        smartPhonePage.clickScreenSizeCheckBox();
        smartPhonePage.clickApplyButton();
    }

    @Test(priority = 5)
    public void selectFirstProductTest() {
        smartPhonePage.clickFirstItem();
    }

    @Test(priority = 6)
    public void captureProductDetailsTest() {
        String title = productDetailsPage.getProductTitle();
        String price = productDetailsPage.getProductPrice();
        Assert.assertFalse(title.isEmpty(), "Title should not be empty");
        Assert.assertFalse(price.isEmpty(), "Price should not be empty");
    }

    @Test(priority = 7)
    public void addToCartTest() {
        productDetailsPage.clickAddToCart();
    }

    @Test(priority = 8)
    public void verifyCartTest() {
        String cartTitle = cartPage.verifyProductName();
        String cartPrice = cartPage.verifyProductPrice();
        Assert.assertFalse(cartTitle.isEmpty(), "Cart title should not be empty");
        Assert.assertFalse(cartPrice.isEmpty(), "Cart price should not be empty");

        Assert.assertEquals(cartTitle, productDetailsPage.getProductTitleText(), "Product title in cart should match ");
        Assert.assertEquals(cartPrice, productDetailsPage.getProductPriceText(), "Product price in cart should match");

        cartPage.getSubtotalPrice();
    }


    @Test(priority = 9)
    public void proceedToCheckoutTest() {
        cartPage.clickCheckout();
    }

    //maybe face to captcha screen. if so fill the captcha quickly
    @Test(priority = 10)
        public void clickGuestButtonTest(){
            cartPage.clickGuestButton();
        }


    @Test(priority = 11, dataProvider = "guestData")
    public void fillGuestCheckoutInfoTest(String firstName, String lastName, String addr1, String addr2,  String city, String state, String zip, String email, String emailConfirm, String phone) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterAddressLine1(addr1);
        checkoutPage.enterAddressLine2(addr2);
        checkoutPage.enterCity(city);
        checkoutPage.enterState(state);
        checkoutPage.enterZipCode(zip);
        checkoutPage.enterEmail(email);
        checkoutPage.enterEmailConfirm(emailConfirm);
        checkoutPage.enterContactNumber(phone);
        checkoutPage.clickDoneButton();
    }

}


