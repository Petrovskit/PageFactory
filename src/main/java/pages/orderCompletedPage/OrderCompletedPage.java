package pages.orderCompletedPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderCompletedPage {

    @FindBy(how = How.CLASS_NAME,using = "SandSIV_Feedback_Modal-background")
    WebElement yourOpinionWindow;


}
