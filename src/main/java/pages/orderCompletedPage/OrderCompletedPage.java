package pages.orderCompletedPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderCompletedPage {

    WebDriver driver;

    @FindBy(how = How.CLASS_NAME, using = "SandSIV_Feedback_Modal-background")
    WebElement yourOpinionWindow;

    @FindBy(how = How.CSS, using = "h2[class$='fs-2x my-3']")
    WebElement orderID;

    @FindBy(how = How.CSS, using = "a.btn.btn-primary.btn-block.btn-arrow-right.btn-spaced")
    WebElement toHomeBtn;

    public OrderCompletedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getTheIdFromThePurchase() {
        String[] orderId = orderID.getText().split(":");
        String formattedId = orderId[1].trim();
        System.out.println("The order ID for your purchase is:" + " " + formattedId);
    }

    public void clickOnToHomeBtn() {
        toHomeBtn.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
