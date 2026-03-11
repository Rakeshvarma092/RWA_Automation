package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class ProjectOnboardingPage extends DriverUtils {

    private static final String DRP_OPTION = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[text()=' Project Onboarding ']")
    private WebElement option_ProjectOnboarding;

    @FindBy(xpath = "//p[text()='Project Management']") // Assuming this is the title of the Project Management page
    private WebElement title_ProjectManagement;

    @FindBy(xpath = "//span[contains(text(),' + New ')]")
    private WebElement btn_New_Project;

    //=============================== Project Details Section ===============================//
    @FindBy(xpath = "//input[@name='pr']")
    private WebElement txt_ProjectName;

    @FindBy(xpath = "//mat-select[@name='prjType']")
    private WebElement drp_ProjectType;

    @FindBy(xpath = "//input[@name='towers']")
    private WebElement txt_Towers;

    @FindBy(xpath = "//p[contains(text(),'prtype')]")
    private WebElement txt_LandArea;

    @FindBy(xpath = "//mat-select[@name='docType']")
    private WebElement drp_DocumentType;

    @FindBy(xpath = "//input[@name='gst']")
    private WebElement txt_GSTNumber;

    @FindBy(xpath = "(//button[contains(@type,'button')])[1]")
    private WebElement btn_GSTINEffectiveDate;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_Date;

    @FindBy(xpath = "//input[@name='rera']")
    private WebElement txt_RERANumber;

    @FindBy(xpath = "(//button[contains(@type,'button')])[2]")
    private WebElement btn_RERAEffectiveDate;

    //=============================== Communication Details Section ===============================//

    @FindBy(xpath = "(//input[@name='countryCode'])[1]")
    private WebElement drp_CountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[1]")
    private WebElement txt_MobileNumber;

    @FindBy(xpath = "(//input[@name='countryCode'])[2]")
    private WebElement drp_AlternateCountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[2]")
    private WebElement txt_AlternateMobileNumber;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement txt_EmailID;

    @FindBy(xpath = "//input[@name='alteremail']")
    private WebElement txt_AlternateEmailID;

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

    @FindBy(xpath = "//input[@name='gml']")
    private WebElement txt_GoogleMapLink;

    //=============================== Key Contact Person Section ===============================//

    @FindBy(xpath = "//input[@name='name_0']")
    private WebElement txt_KeyContactPersonName;

    @FindBy(xpath = "//input[@name='role_0']")
    private WebElement txt_KeyContactPersonDesignation;

    @FindBy(xpath = "//input[@name='emailID_0']")
    private WebElement txt_KeyContactPersonEmail;

    @FindBy(xpath = "(//input[@name='countryCode'])[3]")
    private WebElement drp_KeyContactPersonCountryCode;

    @FindBy(xpath = "(//input[@name='mobileNumber'])[3]")
    private WebElement txt_KeyContactPersonMobileNumber;

    @FindBy(xpath = "//input[@name='identificationNumber_0']")
    private WebElement txt_KeyContactPersonIdentificationNumber;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_Project;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_Project;

    public ProjectOnboardingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProjectOnboarding() {
        waitAndClick(option_ProjectOnboarding);
    }

    public boolean isProjectManagementTitleDisplayed() {
        waitUntilVisible(title_ProjectManagement);
        return title_ProjectManagement.isDisplayed();
    }

    public void clickAddNew() {
        waitAndClick(btn_New_Project);
    }

    public void setProjectDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "PROJECT NAME":
                sendKeys(txt_ProjectName, value, true);
                break;
            case "PROJECT TYPE":
                customDropDownSelection(drp_ProjectType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "TOWERS":
                sendKeys(txt_Towers, value, true);
                escButton();
                break;
            case "LAND AREA":
                sendKeys(txt_LandArea, value, true);
                break;
            case "DOCUMENT TYPE":
                customDropDownSelection(drp_DocumentType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "GST NUMBER":
                sendKeys(txt_GSTNumber, value, true);
                break;
            case "GSTIN EFFECTIVE DATE":
                waitAndClick(btn_GSTINEffectiveDate);
                waitAndClick(select_Date);
                break;
            case "RERA NUMBER":
                sendKeys(txt_RERANumber, value, true);
                break;
            case "RERA EFFECTIVE DATE":
                waitAndClick(btn_RERAEffectiveDate);
                waitAndClick(select_Date);
                break;
        }
    }

    public void setCommunicationDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "COUNTRY CODE":
                sendKeys(drp_CountryCode, value, true);
                break;
            case "MOBILE NUMBER":
                sendKeys(txt_MobileNumber, value, true);
                break;
            case "ALTERNATE COUNTRY CODE":
                sendKeys(drp_AlternateCountryCode, value, true);
                break;
            case "ALTERNATE MOBILE NUMBER":
                sendKeys(txt_AlternateMobileNumber, value, true);
                break;
            case "EMAIL ID":
                sendKeys(txt_EmailID, value, true);
                break;
            case "ALTERNATE EMAIL ID":
                sendKeys(txt_AlternateEmailID, value, true);
                break;
            case "LANDLINE NUMBER":
                sendKeys(txt_LandlineNumber, value, true);
                break;
            case "WEBSITE":
                sendKeys(txt_Website, value, true);
                break;
        }
    }

    public void enterAddressLine1(String value) {
        sendKeys(txt_AddressLine1, value, true);
    }

    public void enterAddressLine2(String value) {
        sendKeys(txt_AddressLine2, value, true);
    }

    public void clickPincode() {
        waitAndClick(txt_Pincode);
    }

    public void clickSelectedPincode() {
        waitAndClick(selected_Pincode);
    }

    public void enterGoogleMapLink(String value) {
        sendKeys(txt_GoogleMapLink, value, true);
    }

    public void setKeyContactDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "NAME":
                sendKeys(txt_KeyContactPersonName, value, true);
                break;
            case "DESIGNATION":
                sendKeys(txt_KeyContactPersonDesignation, value, true);
                break;
            case "EMAIL":
                sendKeys(txt_KeyContactPersonEmail, value, true);
                break;
            case "COUNTRY CODE":
                sendKeys(drp_KeyContactPersonCountryCode, value, true);
                break;
            case "MOBILE NUMBER":
                sendKeys(txt_KeyContactPersonMobileNumber, value, true);
                break;
            case "IDENTIFICATION NUMBER":
                sendKeys(txt_KeyContactPersonIdentificationNumber, value, true);
                break;
        }
    }

    public void clickSave() {
        waitAndClick(btn_Save_Project);
    }

    public void clickCancel() {
        waitAndClick(btn_Cancel_Project);
    }
}
