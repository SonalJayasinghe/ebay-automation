package tests;

import org.assignment.pages.ElectronicsPage;
import org.assignment.pages.HomePage;
import org.assignment.pages.ProductDetailsPage;
import org.assignment.pages.SmartPhonePage;
import org.testng.annotations.Test;

public class TestRunner extends InitTest{

    @Test
    public void testFlow(){
        String url = "https://www.ebay.com/";
        HomePage homePage = new HomePage(driver, wait);
        homePage.openHome(url);
        homePage.goToElectronicsPage();

        ElectronicsPage electronicsPage = new ElectronicsPage(driver, wait);
        electronicsPage.clickCellPhonesAndAccessories();
        electronicsPage.clickCellPhonesAndSmartPhones();


    }
}
