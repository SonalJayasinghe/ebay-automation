package tests;

import org.assignment.pages.HomePage;
import org.testng.annotations.Test;

public class TestRunner extends InitTest{

    @Test
    public void testFlow(){
        String url = "https://www.ebay.com/";
        HomePage homePage = new HomePage(driver, wait);
        homePage.openHome(url);
        homePage.clickElectronicsTab();
    }
}
