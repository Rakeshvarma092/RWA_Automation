package pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverUtils;

public class CompanyManagementPage extends DriverUtils {

    //====================== Locators ======================//
    private static final String SELECT_DROPDOWN = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(),' add_business ')]")
    private WebElement lbl_CompanyManagement;

    @FindBy(xpath = "//p[contains(text(),'Onboard Company ')]")
    private WebElement verify_OnboardCompany;

    @FindBy(xpath = "//span[contains(text(),' + New ')]")
    private WebElement btn_AddNew;

    @FindBy(xpath = "//h1[contains(text(),' Onboard Company ')]")
    private WebElement verify_OnboardCompanyPage;

    //==== Company Details ====

    @FindBy(xpath = "//input[@name='cname']")
    private WebElement txt_CompanyName;

    @FindBy(xpath = "//mat-select[@name='ctype']")
    private WebElement select_CompanyType;

    @FindBy(xpath = "//input[@name='cgroup']")
    private WebElement txt_CompanyGroup;

    @FindBy(xpath = "//span[contains(text(),'Choose File')]")
    private WebElement btn_ChooseFile;

    @FindBy(xpath = "(//span[contains(text(),' Next ')])[1]")
    private WebElement btn_Next_CompanyDetails;

    //=== Communication Details ====

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

    @FindBy(xpath = "(//span[contains(text(),' Next ')])[2]")
    private WebElement btn_Next_CommunicationDetails;

    //==== Address Details ====

    @FindBy(xpath = "//input[@name='caddress1']")
    private WebElement txt_AddressLine1;

    @FindBy(xpath = "//input[@name='caddress2']")
    private WebElement txt_AddressLine2;

    //=== PINCODE===
    @FindBy(xpath = "//input[@name='pincode']")
    private WebElement txt_Pincode;

    @FindBy(xpath = "//h2[contains(text(),'Pincode Lookup')]")
    private WebElement verify_PincodesLookup;

    @FindBy(xpath = "//input[@placeholder='Search by pincode, city, state...']")
    private WebElement search_Pincode;

    @FindBy(xpath = "(//mat-icon[contains(text(),'chevron_right')])[1]")
    private WebElement selected_Pincode;

    @FindBy(xpath = "//input[@name='link']")
    private WebElement txt_GoogleMapLink;

    @FindBy(xpath = "(//span[contains(text(),' Next ')])[3]")
    private WebElement btn_Next_AddressDetails;

    //==== Tax & Compliance ====

    @FindBy(xpath = "//input[@name='ciNum']")
    private WebElement txt_CINumber;

    @FindBy(xpath = "//input[@name='gst']")
    private WebElement txt_GSTNumber;

    @FindBy(xpath = "(//button[contains(@type,'button')])[7]")
    private WebElement btn_GSTINEffectiveDate;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_GSTINEffectiveDate;

    @FindBy(xpath = "//input[@name='panNumber']")
    private WebElement txt_PANNumber;

    @FindBy(xpath = "//input[@name='ciso']")
    private WebElement txt_ISO;

    @FindBy(xpath = "//input[@name='rera1']")
    private WebElement txt_RERA;

    @FindBy(xpath = "(//button[contains(@type,'button')])[8]")
    private WebElement btn_RERAEffectiveDate;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_RERAEffectiveDate;

    @FindBy(xpath = "(//span[contains(text(),' Next ')])[4]")
    private WebElement btn_Next_TaxCompliance;

    //==== Social Media Links ====

    @FindBy(xpath = "//input[@name='social1']")
    private WebElement txt_SocialMediaLink1;

    @FindBy(xpath = "//input[@name='social2']")
    private WebElement txt_SocialMediaLink2;

    @FindBy(xpath = "//input[@name='social3']")
    private WebElement txt_SocialMediaLink3;

    @FindBy(xpath = "(//span[contains(text(),' Next ')])[5]")
    private WebElement btn_Next_SocialMediaLinks;

    //==== Key Contact Details ====

    @FindBy(xpath = "//input[@name='name_0']")
    private WebElement txt_ContactPersonName;

    @FindBy(xpath = "//input[@name='role_0']")
    private WebElement txt_Designation;

    @FindBy(xpath = "//input[@name='emailID_0']")
    private WebElement txt_ContactEmailID;

    @FindBy(xpath = "(//input[@name='countryCode'])[3]")
    private WebElement select_ContactCountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[3]")
    private WebElement txt_ContactMobileNumber;

    @FindBy(xpath = "//mat-select[@placeholder='-- Select Identification Type --']")
    private WebElement select_IdentificationType;

    @FindBy(xpath = "//input[@name='identificationNumber_0']")
    private WebElement txt_IdentificationNumber;

    //=== Buttons ===

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel;

    @FindBy(xpath = "//span[contains(text(),' Save ')]")
    private WebElement btn_Save;

    //======================= Constructor =====================//

    public CompanyManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //======================= PAGE ACTIONS ==========================//

    public void clickCompanyManagement(){
        waitAndClick(lbl_CompanyManagement);
    }

    public void clickAddNew() {
        waitAndClick(btn_AddNew);
    }

    public boolean isOnboardCompanyPageDisplayed() {
        waitUntilVisible(verify_OnboardCompanyPage);
        return verify_OnboardCompanyPage.isDisplayed();
    }

    public void enterCompanyDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "COMPANY NAME":
                sendKeys(txt_CompanyName, generateName(), true);
                break;
            case "COMPANY TYPE":
                customDropDownSelection(select_CompanyType, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "COMPANY DETAILS":
                sendKeys(txt_CompanyGroup, generateName(), true);
                break;
            case "NEXT":
                waitAndClick(btn_Next_CompanyDetails);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. Valid values: 'Company Name', 'Company Type', 'Company Details'");
        }
    }

    public void enterCommunicationDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "COUNTRY CODE":
                customDropDownSelection(select_CountryCode, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "MOBILE NUMBER":
                sendKeys(txt_MobileNumber, generatePhoneNumber(), true);
                break;
            case "EMAIL ID":
                value = generateName() + value;
                sendKeys(txt_EmailID, value, true);
                break;
            case "LANDLINE NUMBER":
                sendKeys(txt_LandlineNumber, generatePhoneNumber(), true);
                break;
            case "WEBSITE":
                sendKeys(txt_Website, value, true);
                break;
            case "NEXT":
                waitAndClick(btn_Next_CommunicationDetails);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. values: 'Country Code', 'Mobile Number', 'Email ID', 'Landline Number', 'Website'");
        }
    }

    public void enterAddressDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "ADDRESS LINE 1":
                sendKeys(txt_AddressLine1, value, true);
                break;
            case "ADDRESS LINE 2":
                sendKeys(txt_AddressLine2, value, true);
                break;
            case "PINCODE":
                selectPincode(value);
                break;
            case "GOOGLE MAP LINK":
                sendKeys(txt_GoogleMapLink, value, true);
                break;
            case "NEXT":
                waitAndClick(btn_Next_AddressDetails);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. values: 'Address Name', 'pincode', 'Google Map Link'");
        }
    }

    public void enterTaxComplianceDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "CI NUMBER":
                sendKeys(txt_CINumber, generateCINumber(), true);
                break;
            case "GST NUMBER":
                sendKeys(txt_GSTNumber, generateGSTIN(), true);
                break;
            case "GSTIN EFFECTIVE DATE":
                waitAndClick(btn_GSTINEffectiveDate);
                waitAndClick(select_GSTINEffectiveDate);
                tabButton();
                break;
            case "PAN NUMBER":
                sendKeys(txt_PANNumber, generatePAN(), true);
                break;
            case "ISO":
                sendKeys(txt_ISO, value, true);
                break;
            case "RERA":
                sendKeys(txt_RERA, value, true);
                break;
            case "RERA EFFECTIVE DATE":
                waitAndClick(btn_RERAEffectiveDate);
                waitAndClick(select_RERAEffectiveDate);
                tabButton();
                break;
            case "NEXT":
                waitAndClick(btn_Next_TaxCompliance);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. values: 'CI Number', 'GST Number', 'PAN Number', 'ISO','RERA'");
        }
    }

    public void enterSocialMediaLinks(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "SOCIAL MEDIA LINK 1":
                sendKeys(txt_SocialMediaLink1, value, true);
                break;
            case "SOCIAL MEDIA LINK 2":
                sendKeys(txt_SocialMediaLink2, value, true);
                break;
            case "SOCIAL MEDIA LINK 3":
                sendKeys(txt_SocialMediaLink3, value, true);
                break;
            case "NEXT":
                waitAndClick(btn_Next_SocialMediaLinks);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. values: 'Social Media Link 1', 'Social Media Link 2', 'Social Media Link3'");
        }
    }

    public void enterKeyContactDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "CONTACT PERSON NAME":
                sendKeys(txt_ContactPersonName, generateName(), true);
                break;
            case "DESIGNATION":
                sendKeys(txt_Designation, value, true);
                break;
            case "CONTACT EMAIL ID":
                sendKeys(txt_ContactEmailID, value, true);
                break;
            case "CONTACT COUNTRY CODE":
                sendKeys(select_ContactCountryCode, value, true);
                break;
            case "CONTACT MOBILE NUMBER":
                sendKeys(txt_ContactMobileNumber, generatePhoneNumber(), true);
                break;
            case "IDENTIFICATION TYPE":
                customDropDownSelection(select_IdentificationType, By.xpath(String.format(SELECT_DROPDOWN, value)));
                break;
            case "IDENTIFICATION NUMBER":
                sendKeys(txt_IdentificationNumber, value, true);
                break;
            default:
                throw new IllegalArgumentException("Unknown field: '" + fieldName + "'. values: 'Contact Person Name', 'Designation', 'Contact Email ID', 'Contact Mobile Number', 'Identification Type', 'Identification Number'");
        }
    }

    public void clickSave() {
        waitAndClick(btn_Save);
    }

    public void clickCancel() {
        waitAndClick(btn_Cancel);
    }

    public void selectPincode(String value) {
        waitAndClick(txt_Pincode);
        waitUntilVisible(verify_PincodesLookup);
        sendKeys(search_Pincode, value, true);
        waitAndClick(selected_Pincode);
    }
}
