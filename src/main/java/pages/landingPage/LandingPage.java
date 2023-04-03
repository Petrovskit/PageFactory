package pages.landingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "acceptAllCookiesBtn")
    WebElement acceptCookiesBtn;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/main[1]/header[1]/div[2]/nav[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/div[1]")
    WebElement mobilePacketBtn;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Za vse (MIO)']")
    WebElement paketiMioBtn;

    @FindBy(how = How.ID, using = "exampleModalLongTitle")
    WebElement cookiesWindowTitle;

    @FindBy(how = How.CSS, using = ".navigation")
    WebElement navigationBar;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean acceptCookies() {
        if (cookiesWindowTitle.isDisplayed()) {
            acceptCookiesBtn.click();
            return true;
        } else return false;
    }

    public boolean hoverAndClickOnPaketiMio() {
        if (navigationBar.isDisplayed()) {
            Actions action = new Actions(driver);
            action.moveToElement(mobilePacketBtn).perform();
            paketiMioBtn.click();
            return true;
        } else return false;

    }

    public String landingPageTitle() {
        return driver.getTitle();
    }
}
