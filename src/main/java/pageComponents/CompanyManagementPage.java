package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class CompanyManagementPage extends DriverUtils {

    private static final String SELECT_DROPDOWN = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(),' add_business ')]")

    private WebElement lbl_CompanyManagement;

    @FindBy(xpath = "//p[contains(text(),'Onboard Company ')]")
    private WebElement verify_OnboardCompany;

    @FindBy(xpath = "//span[contains(text(),' + New ')]")
    private WebElement btn_AddNew;

    @FindBy(xpath = "//p[contains(text(),'Onboard Company')]")
    private WebElement verify_OnboardCompanyPage;

    //=============================== Company Details Section ===============================//

    @FindBy(xpath = "//input[@name='cname']")
    private WebElement txt_CompanyName;

    @FindBy(xpath = "//mat-select[@name='ctype']")
    private WebElement select_CompanyType;

    @FindBy(xpath = "//input[@name='cgroup']")
    private WebElement txt_CompanyGroup;

    @FindBy(xpath = "//span[contains(text(),' Choose File ')]")
    private WebElement btn_ChooseFile;

    //=============================== Communication Details Section ===============================//

    @FindBy(xpath = "(//input[@name='countryCode'])[1]")
    private WebElement select_CountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[1]")
    private WebElement txt_MobileNumber;

    @FindBy(xpath = "//input[@name='email1']")
    private WebElement txt_EmailID;

    @FindBy(xpath = "//input[@name='land']")
    private WebElement txt_LandlineNumber;

    @FindBy(xpath = "//input[@name='website']")
    private WebElement txt_Website;

    //=============================== Address Details Section ===============================//

    @FindBy(xpath = "//input[@name='caddress1']")
    private WebElement txt_AddressLine1;

    @FindBy(xpath = "//input[@name='caddress2']")
    private WebElement txt_AddressLine2;

    @FindBy(xpath = "//input[@name='pincode']")
    private WebElement txt_Pincode;

    @FindBy(xpath = "//p[contains(text(),'Pincode Lookup')]")
    private WebElement verify_PincodesLookup;

    @FindBy(xpath = "(//mat-icon[contains(text(),'chevron_right')])[1]")
    private WebElement selected_Pincode;

    @FindBy(xpath = "//input[@name='link']")
    private WebElement txt_GoogleMapLink;

    //=============================== Tax & Compliance Section ===============================//

    @FindBy(xpath = "//input[@name='ciNum']")
    private WebElement txt_CINumber;

    @FindBy(xpath = "//input[@name='gst']")
    private WebElement txt_GSTNumber;

    @FindBy(xpath = "(//button[contains(@type,'button')])[1]")
    private WebElement btn_GSTINEffectiveDate;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_GSTINEffectiveDate;

    @FindBy(xpath = "//input[@name='panNumber']")
    private WebElement txt_PANNumber;

    @FindBy(xpath = "//input[@name='ciso']")
    private WebElement txt_ISO;

    @FindBy(xpath = "//input[@name='rera1']")
    private WebElement txt_RERA;

    //============================== Key Contact Details Section ===============================//

    @FindBy(xpath = "//input[@name='name_0']")
    private WebElement txt_ContactPersonName;

    @FindBy(xpath = "//input[@name='role_0']")
    private WebElement txt_Designation;

    @FindBy(xpath = "//input[@name='emailID_0']")
    private WebElement txt_ContactEmailID;

    @FindBy(xpath = "(//input[@name='countryCode'])[2]")
    private WebElement select_ContactCountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[2]")
    private WebElement txt_ContactMobileNumber;

    @FindBy(xpath = "//input[@placeholder='Enter PAN/Aadhar']")
    private WebElement txt_ContactIdentificationNumber;

    //============================== Buttons ===============================//

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel;

    @FindBy(xpath = "//span[contains(text(),' Save ')]")
    private WebElement btn_Save;

    public CompanyManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCompanyManagementMenu() {
        waitAndClick(lbl_CompanyManagement);
    }

    public boolean isOnboardCompanyDisplayed() {
        waitUntilVisible(verify_OnboardCompany);
        return verify_OnboardCompany.isDisplayed();
    }

    public void clickAddNew() {
        waitAndClick(btn_AddNew);
    }

    public boolean isOnboardCompanyPageDisplayed() {
        waitUntilVisible(verify_OnboardCompanyPage);
        return verify_OnboardCompanyPage.isDisplayed();
    }

    public void setCompanyDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "COMPANY NAME":
                value = generateName() + value;
                sendKeys(txt_CompanyName, value, true);
                break;
            case "COMPANY TYPE":
                customDropDownSelection(select_CompanyType, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "COMPANY GROUP":
                value = generateName() + value;
                sendKeys(txt_CompanyGroup, value, true);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }

    public void setCommunicationDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "COUNTRY CODE":
                customDropDownSelection(select_CountryCode, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "MOBILE NUMBER":
                value = generateValidPhoneNumber() + value;
                sendKeys(txt_MobileNumber, value, true);
                break;
            case "EMAIL ID":
                value = generateName() + value;
                sendKeys(txt_EmailID, value, true);
                break;
            case "LANDLINE NUMBER":
                sendKeys(txt_LandlineNumber, value, true);
                break;
            case "WEBSITE":
                sendKeys(txt_Website, value, true);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }

    public void clickChooseFile() {
        waitAndClick(btn_ChooseFile);
    }

    public void enterAddressLine1(String address) {
        sendKeys(txt_AddressLine1, address, false);
    }

    public void enterAddressLine2(String address) {
        sendKeys(txt_AddressLine2, address, false);
    }

    public void clickPincode() {
        waitAndClick(txt_Pincode);
    }

    public void enterPincode(String pincode) {
        sendKeys(txt_Pincode, pincode, false);
    }

    public boolean isPincodeLookupVisible() {
        waitUntilVisible(verify_PincodesLookup);
        return verify_PincodesLookup.isDisplayed();
    }

    public void clickSelectedPincode() {
        waitAndClick(selected_Pincode);
    }

    public void enterGoogleMapLink(String link) {
        sendKeys(txt_GoogleMapLink, link, false);
    }

    public void setTaxAndComplianceDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "CI NUMBER":
                sendKeys(txt_CINumber, value, false);
                break;
            case "GST NUMBER":
                sendKeys(txt_GSTNumber, value, false);
                break;
            case "GSTIN EFFECTIVE DATE":
                clickGSTINEffectiveDate();
                selectGSTINEffectiveDate();
                break;
            case "PAN NUMBER":
                sendKeys(txt_PANNumber, value, false);
                break;
            case "ISO":
                sendKeys(txt_ISO, value, false);
                break;
            case "RERA":
                sendKeys(txt_RERA, value, false);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }

    public void clickGSTINEffectiveDate() {
        waitAndClick(btn_GSTINEffectiveDate);
    }

    public void selectGSTINEffectiveDate() {
        waitAndClick(select_GSTINEffectiveDate);
    }

    public void setKeyContactDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "CONTACT PERSON NAME":
                value = generateName() + value;
                sendKeys(txt_ContactPersonName, value, false);
                break;
            case "DESIGNATION":
                sendKeys(txt_Designation, value, false);
                break;
            case "CONTACT EMAIL ID":
                value= generateName() + value;
                sendKeys(txt_ContactEmailID, value, false);
                break;
            case "CONTACT COUNTRY CODE":
                customDropDownSelection(select_ContactCountryCode, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "CONTACT MOBILE NUMBER":
                value = generateValidPhoneNumber() + value;
                sendKeys(txt_ContactMobileNumber, value, false);
                break;
            case "CONTACT IDENTIFICATION NUMBER":
                sendKeys(txt_ContactIdentificationNumber, value, false);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }


    public void clickCancel() {
        waitAndClick(btn_Cancel);
    }

    public void clickSave() {
        waitAndClick(btn_Save);
    }
}