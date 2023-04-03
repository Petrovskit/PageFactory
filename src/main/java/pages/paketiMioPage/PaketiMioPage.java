package pages.paketiMioPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaketiMioPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@data-product-id='11904193']")
    WebElement miniMioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-product-id='11904129']")
    WebElement midiMioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-product-id='11904064']")
    WebElement maksiMioBtn;

    @FindBy(how = How.ID, using = "a1secom-moga-goto-checkout-1")
    WebElement checkoutBtn;

    @FindBy(how = How.XPATH, using = "//span[@class='package-name']")
    WebElement packageName;

    @FindBy(how = How.CSS, using = ".a1breadcrumb")
    WebElement breadCrumb;

    @FindBy(how = How.XPATH, using = "//div[@class='card-header']")
    WebElement scroll;

    public PaketiMioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
    }

    public void clickOnMiniMioBtn() {
        miniMioBtn.click();
    }

    public void clickOnMidiMioBtn() {
        midiMioBtn.click();
    }

    public void clickOnMaksiMioBtn() {
        maksiMioBtn.click();
    }

    public void clickOnCheckoutBtn() {
        checkoutBtn.click();
    }

    public boolean bodyTextEqualsTariffSelection() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(packageName, "miniMIO"));
        String packageName1 = packageName.getText();
        return packageName1.equals("miniMIO");
    }

    public String verifyBreadcrumb() {
        return breadCrumb.getText();
    }

    public boolean verifyAllTariffsArePresent() {
        return miniMioBtn.isDisplayed() && midiMioBtn.isDisplayed() && maksiMioBtn.isDisplayed();
    }


}
