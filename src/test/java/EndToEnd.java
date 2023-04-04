import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.checkoutLastPage.CheckoutLastPage;
import pages.checkoutPage.CheckoutPage;
import pages.landingPage.LandingPage;
import pages.orderCompletedPage.OrderCompletedPage;
import pages.paketiMioPage.PaketiMioPage;

import java.util.concurrent.TimeUnit;

public class EndToEnd {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://test-webshop.a1.si/");
    }

    @Test(description = "Verify that cookies window is displayed and click accept on it ", priority = 1)
    public void verifyThatCookiesWindowIsDisplayed() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.acceptCookies());
    }

    @Test(description = "Verify that the user is on the right page", priority = 2)
    public void verifyLandingPageTitle() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.landingPageTitle(), "A1 Slovenija | A1");
    }

    @Test(description = "Verify that the navbar is present and click on Mobilni Paketi MIO", priority = 3)
    public void verifyNavbarPresentAndClickOnMIO() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.hoverAndClickOnPaketiMio();
    }

    @Test(description = "Verify that the proper pages are displayed on the breadcrumb", priority = 4)
    public void verifyProperPagesAreDisplayedOnBreadcrumb() {
        PaketiMioPage paketiMioPage = new PaketiMioPage(driver);
        Assert.assertEquals(paketiMioPage.verifyBreadcrumb(), """
                Domov
                Naročniški paketi
                Paketi MIO""");
    }

    @Test(description = "Verify that Mini , Midi and Maksi products are present on the page", priority = 5)
    public void verifyAllTariffsArePresent() {
        PaketiMioPage paketiMioPage = new PaketiMioPage(driver);
        paketiMioPage.scrollToElement();
        Assert.assertTrue(paketiMioPage.verifyAllTariffsArePresent());
    }

    @Test(description = "Verify that Tariff selection is displayed on the popup window", priority = 6)
    public void verifyTariffSelectionIsDisplayed() {
        PaketiMioPage paketiMioPage = new PaketiMioPage(driver);
        paketiMioPage.clickOnMiniMioBtn();
        Assert.assertTrue(paketiMioPage.bodyTextEqualsTariffSelection());
    }

    @Test(description = "Click on Checkout button and verify the title of the Checkout page", priority = 7)
    public void verifyTitleOfCheckoutPage() {
        PaketiMioPage paketiMioPage = new PaketiMioPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        paketiMioPage.clickOnCheckoutBtn();
        String expectedTitle = "Checkout | A1";
        Assert.assertEquals(checkoutPage.getTitle(), expectedTitle);
    }

    @Test(description = "Verify if New Contract is selected and enter data in the input fields", priority = 8)
    public void newContractFlow() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.newContractFlow();
    }

    @Test(description = "Verify if Existing Contract is selected and enter data in the input fields", priority = 9)
    public void existingContractFlow() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.existingContractFlow();
    }

    @Test(description = "Verify when Different Address Button is clicked optional input fields are displayed", priority = 10)
    public void clickOnDifferentAddressBtn() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.clickOnDifferentAddressBtn());
    }

    @Test(description = "Verify that when Notify me button is pressed optional checkboxes are displayed", priority = 11)
    public void clickOnNotifyMeButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.clickOnNotifyMeCheckBox());
    }

    @Test(description = "Verify if Summary window is displayed", priority = 12)
    public void verifyIfSummaryWindowIsDisplayed() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.verifyIfSummaryWindowIsDisplayed());
        checkoutPage.clickOnSubmitBtn();
    }

    @Test(description = "Verify the user landed on Checkout page", priority = 13)
    public void verifyCheckoutPage() {
        CheckoutLastPage checkoutLastPage = new CheckoutLastPage(driver);
        String expectedTitle = "Naročniška pogodba";
        Assert.assertEquals(checkoutLastPage.getStepTitle(), expectedTitle);
    }

    @Test(description = "Verify that if checkbox is not ticked the submit button is disabled", priority = 14)
    public void verifySubmitBtnIsDisabled() {
        CheckoutLastPage checkoutLastPage = new CheckoutLastPage(driver);
        Assert.assertFalse(checkoutLastPage.verifyIfCheckBtnIsSelected());
    }

    @Test(description = "Click on check button and then click on submit button", priority = 15)
    public void clickOnCheckAndSubmitBtn() throws InterruptedException {
        CheckoutLastPage checkoutLastPage = new CheckoutLastPage(driver);
        checkoutLastPage.clickOnCheckBtn();
        checkoutLastPage.clickOnSubmitBtn();
    }

    @Test(description = "Get the ID from the purchase printed in console", priority = 16)
    public void getAndPrintTheId() {
        OrderCompletedPage orderCompletedPage = new OrderCompletedPage(driver);
        orderCompletedPage.getTheIdFromThePurchase();
    }

    @Test(description = "Click on To Home button and verify the Title of the new landing page", priority = 17)
    public void clickOnToHomeBtnAndVerifyNewLandingPage() {
        OrderCompletedPage orderCompletedPage = new OrderCompletedPage(driver);
        orderCompletedPage.clickOnToHomeBtn();
        String expectedTitle = "A1 Slovenija | A1";
        Assert.assertEquals(orderCompletedPage.getTitle(),expectedTitle);
    }


    @AfterClass
    public void quit() {
        driver.quit();
    }
}
