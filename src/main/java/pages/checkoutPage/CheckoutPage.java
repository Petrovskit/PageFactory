package pages.checkoutPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;

    String firstName = "Teodor";
    String lastName = "Petrovski";
    String street = "Mariborska";
    String identityNumber = "123456789";
    String taxNumber = "90439139";
    String birthPlace = "Maribor";
    String mobileNumber = "040190930";
    String email = "petrovskiiteo@gmail.com";

    @FindBy(how = How.ID, using = "contractTypeNewRadio")
    WebElement newContractRadioBtn;

    @FindBy(how = How.ID, using = "contractTypeExistingRadio")
    WebElement existingContractRadioBtn;

    @FindBy(how = How.ID, using = "mobileNumberNewRadio")
    WebElement newMobileNumberRadioBtn;

    @FindBy(how = How.ID, using = "simCardTypeSimRadio")
    WebElement simCardTypeRadioBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='sexTypeFemaleRadio']")
    WebElement femaleRadioBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='sexTypeMaleRadio']")
    WebElement maleRadioBtn;

    @FindBy(how = How.ID, using = "inputName")
    WebElement nameInputField;

    @FindBy(how = How.ID, using = "inputSurname")
    WebElement surnameInputField;

    @FindBy(how = How.ID, using = "inputFullStreet")
    WebElement streetInputField;

    @FindBy(how = How.ID, using = "inputHouseNumber")
    WebElement houseNumberInputField;

    @FindBy(how = How.ID, using = "inputIdentityNumber")
    WebElement identityNumberInputField;

    @FindBy(how = How.ID, using = "inputTaxNumber")
    WebElement taxNumberInputField;

    @FindBy(how = How.ID, using = "inputBirthPlace")
    WebElement birthPlaceInputField;

    @FindBy(how = How.ID, using = "inputMobileContactNumber")
    WebElement mobileNumberInputField;

    @FindBy(how = How.ID, using = "inputEmail")
    WebElement emailInputField;

    @FindBy(how = How.ID, using = "inputEmailAgain")
    WebElement emailConfirmInputField;

    @FindBy(how = How.NAME, using = "_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet_continue")
    WebElement submitBtn;

    @FindBy(how = How.XPATH, using = "(//div[@class='card-body'])[2]")
    WebElement inputFieldsBody;

    @FindBy(how = How.NAME, using = "_com_liferay_commerce_checkout_web_internal_portlet_CommerceCheckoutPortlet__differentAddressCheck")
    WebElement chooseDifferentAddressBtn;

    @FindBy(how = How.ID, using = "inputDifferentAddressName")
    WebElement differentAddressInputFieldName;

    @FindBy(how = How.ID, using = "inputDifferentAddressSurname")
    WebElement differentAddressInputFieldSurname;

    @FindBy(how = How.ID, using = "inputDifferentAddressFullStreet")
    WebElement differentAddressInputFieldFullAddress;

    @FindBy(how = How.ID, using = "inputDifferentAddressHouseNumber")
    WebElement differentAddressInputFieldHouseNumber;

    @FindBy(how = How.ID, using = "gdprTermsAgreeCheckbox")
    WebElement notificationsAllowedBtn;

    @FindBy(how = How.ID, using = "gdprTermsDisagreeCheckbox")
    WebElement notificationsNotAllowedBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='checkNews']")
    WebElement newsCheckBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='checkCall']")
    WebElement callCheckBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='checkEmail']")
    WebElement emailCheckBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='checkPost']")
    WebElement postCheckBtn;

    @FindBy(how = How.XPATH, using = "//label[@for='checkSms']")
    WebElement smsCheckBox;

    @FindBy(how = How.XPATH, using = "//label[@for='checkDigitalChanel']")
    WebElement socialCheckBox;

    @FindBy(how = How.XPATH, using = "//label[@for='checkOffer']")
    WebElement checkOfferBtn;

    @FindBy(how = How.CLASS_NAME, using = "summary")
    WebElement summaryWindow;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newContractFlow() throws InterruptedException {
        Actions a = new Actions(driver);
        if (newContractRadioBtn.isSelected()) {
            newMobileNumberRadioBtn.isDisplayed();
            newMobileNumberRadioBtn.click();
            a.moveToElement(nameInputField).build().perform();
            simCardTypeRadioBtn.isDisplayed();
            simCardTypeRadioBtn.click();
            a.moveToElement(chooseDifferentAddressBtn).build().perform();
            inputFieldsBody.isDisplayed();
            clickOnMaleRadioBtn();
            inputFirstAndLastName(firstName, lastName);
            inputStreet(street);
            inputHouseNumber("4");
            inputIdentityNumber(identityNumber);
            inputTaxNumber(taxNumber);
            inputBirthPlace(birthPlace);
            inputMobileNumber(mobileNumber);
            inputEmailAndEmailConfirm(email);
        }
    }

    public void existingContractFlow() throws InterruptedException {
        Actions a = new Actions(driver);
        existingContractRadioBtn.click();
        if (existingContractRadioBtn.isSelected()) {
            a.moveToElement(chooseDifferentAddressBtn).build().perform();
            inputFieldsBody.isDisplayed();
            clickOnFemaleRadioBtn();
            inputFirstAndLastName(firstName, lastName);
            inputStreet(street);
            inputHouseNumber("4");
            inputIdentityNumber(identityNumber);
            inputTaxNumber(taxNumber);
            inputBirthPlace(birthPlace);
            inputMobileNumber(mobileNumber);
            inputEmailAndEmailConfirm(email);
        }
    }

    public void clickOnMaleRadioBtn() {
        maleRadioBtn.click();
    }

    public void clickOnFemaleRadioBtn() {
        femaleRadioBtn.click();
    }

    public void inputFirstAndLastName(String firstName, String lastName) {
        nameInputField.clear();
        surnameInputField.clear();
        nameInputField.sendKeys(firstName);
        surnameInputField.sendKeys(lastName);
    }

    public void inputStreet(String streetAddress) throws InterruptedException {
        streetInputField.clear();
        streetInputField.sendKeys(streetAddress);
        Thread.sleep(1000);
        streetInputField.sendKeys(Keys.ARROW_DOWN);
        streetInputField.sendKeys(Keys.ENTER);
    }

    public void inputHouseNumber(String houseNumber) {
        houseNumberInputField.clear();
        houseNumberInputField.sendKeys(houseNumber);
    }

    public void inputIdentityNumber(String identityNumber) {
        identityNumberInputField.clear();
        identityNumberInputField.sendKeys(identityNumber);
    }

    public void inputTaxNumber(String taxNumber) {
        taxNumberInputField.clear();
        taxNumberInputField.sendKeys(taxNumber);
    }

    public void inputBirthPlace(String birthPlace) {
        birthPlaceInputField.clear();
        birthPlaceInputField.sendKeys(birthPlace);
    }

    public void inputMobileNumber(String mobileNumber) {
        mobileNumberInputField.clear();
        mobileNumberInputField.sendKeys(mobileNumber);
    }

    public void inputEmailAndEmailConfirm(String email) {
        emailInputField.clear();
        emailConfirmInputField.clear();
        emailInputField.sendKeys(email);
        emailConfirmInputField.sendKeys(email);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleIs("Checkout | A1"));
        return driver.getTitle();
    }

    public boolean clickOnDifferentAddressBtn() {
        chooseDifferentAddressBtn.click();
        if (chooseDifferentAddressBtn.isSelected()) {
            return differentAddressInputFieldName.isDisplayed() & differentAddressInputFieldSurname.isDisplayed()
                   & differentAddressInputFieldFullAddress.isDisplayed() & differentAddressInputFieldHouseNumber.isDisplayed();
        } else return false;
    }

    public boolean clickOnNotifyMeCheckBox() {
        Actions a = new Actions(driver);
        notificationsAllowedBtn.click();
        a.moveToElement(notificationsNotAllowedBtn).build().perform();
        if (notificationsAllowedBtn.isSelected()) {
            return newsCheckBtn.isDisplayed() && callCheckBtn.isDisplayed() && emailCheckBtn.isDisplayed() && postCheckBtn.isDisplayed() && smsCheckBox.isDisplayed() &&
                   socialCheckBox.isDisplayed() && checkOfferBtn.isDisplayed();
        } else return false;
    }

    public boolean verifyIfSummaryWindowIsDisplayed() {
        chooseDifferentAddressBtn.click();
        return summaryWindow.isDisplayed();
    }
}
