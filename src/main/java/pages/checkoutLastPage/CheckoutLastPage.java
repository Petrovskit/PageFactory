package pages.checkoutLastPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutLastPage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "agreeCheck")
    WebElement checkBtn;

    @FindBy(how = How.NAME, using = "_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet_continue")
    WebElement submitBtn;

    @FindBy(how = How.CLASS_NAME, using = "step-title")
    WebElement textElement;

    @FindBy(how = How.CLASS_NAME, using = "summary-title")
    WebElement summaryTitle;

    @FindBy(how = How.CSS,using = ".step-title")
    WebElement stepTitle;

    public CheckoutLastPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCheckBtn() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkBtn);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public String getStepTitle() {
        return stepTitle.getText();
    }

    public boolean verifyIfCheckBtnIsSelected() {
        if (checkBtn.isSelected()) {
            return submitBtn.isEnabled();
        } else return false;
    }
}
