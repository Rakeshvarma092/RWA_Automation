package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class OnboardCompanyPage extends DriverUtils {
    private WebDriver driver;
    @FindBy(xpath = "//p[text()='Onboard Company']")
    private WebElement header_OnboardCompany;
    @FindBy(xpath = "//input[@name='cname']")
    private WebElement txt_CompanyName;
    @FindBy(xpath = "//mat-select[@name='ctype']")
    private WebElement drp_CompanyType;
    public String selectDropdown = "//span[contains(text(),'%s')]";
    @FindBy(xpath = "//input[@name='cgroup']")
    private WebElement txt_CompanyGroup;
    @FindBy(xpath = "(//input[@name='countryCode'])[1]")
    public WebElement txt_CountryCode;
    @FindBy(xpath = "(//input[@name='mobileNumber'])[1]")
    public WebElement txt_MobileNumber;
    @FindBy(xpath = "(//input[@name='countryCode'])[2]")
    public WebElement txt_AlternateCountryCode;
    @FindBy(xpath = "//input[@name='mobileNumber']")
    public WebElement txt_AlternateMobileNumber;
    @FindBy(xpath = "//input[@name='email1']")
    public WebElement txt_Email1;
    @FindBy(xpath = "//input[@name='alteremail']")
    public WebElement txt_AlternateEmail1;
    @FindBy(xpath = "//input[@name='land']")
    public WebElement txt_Landline;
    @FindBy(xpath = "//input[@name='website']")
    public WebElement txt_Website;
    @FindBy(xpath = "//input[@name='caddress1']")
    private WebElement txt_AddressLine1;
    @FindBy(xpath = "//input[@name='caddress2']")
    private WebElement txt_AddressLine2;
    @FindBy(xpath = "//span[normalize-space()='search']")
    private WebElement btn_pincode;
    @FindBy(xpath = "(//mat-icon[@role='img'][normalize-space()='chevron_right'])[1]")
    public WebElement selectPincode;
    @FindBy(xpath = "//input[@name='gst']")
    public WebElement txt_GSTIN;
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement btn_GstinEffectiveDate;
    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement selectDate;
    @FindBy(xpath = "//input[@name='panNumber']")
    public WebElement txt_PanNumber;
    @FindBy(xpath = "//input[@name='name_0']")
    public WebElement txt_Name;
    @FindBy(xpath = "//input[@name='role_0']")
    public WebElement txt_Designation;
    @FindBy(xpath = "//input[@name='emailID_0']")
    public WebElement txt_Email;
    @FindBy(xpath = "//input[@name='countryCode']")
    public WebElement drp_CountryCode;
    @FindBy(xpath = "//input[@name='mobileNumber']")
    public WebElement txt_PhoneNumber;

    public OnboardCompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyPage(){
        waitUntilVisible(header_OnboardCompany);
    }
    public void setCompanyDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "COMPANY NAME":
                value = generateValidName()+value;
                sendKeys(txt_CompanyName, value, true);
                tabButton();
                break;
            case "COMPANY TYPE":
                customDropDownSelection(drp_CompanyType, By.xpath(String.format(selectDropdown, value)));
                break;
            case "COMPANY GROUP":
                value = generateName() + value;
                sendKeys(txt_CompanyGroup, value, true);
                break;
            default:
                throw new IllegalArgumentException("Invalid data is supplied ::" + fieldName);
        }
    }
    public void setCommunicationDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "COUNTRY CODE":
                customDropDownSelection(txt_CountryCode, By.xpath(String.format(selectDropdown, value)));
                break;
            case "MOBILE NUMBER":
                value = generateValidPhoneNumber()+value;
                sendKeys(txt_MobileNumber, value, true);
                break;
            case "EMAIL ID":
                value = generateName() + value;
                sendKeys(txt_Email1, value, true);
                break;
            default:
                throw new IllegalArgumentException("Invalid data is supplied ::" + fieldName);
        }
    }
    public void setAddressDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "ADDRESS LINE 1":
                value = generateValidName()+value;
                sendKeys(txt_AddressLine1, value, true);
                break;
            case "PINCODE":
                waitAndClick(btn_pincode);
                waitAndClick(selectPincode);
                break;
            default:
                throw new IllegalArgumentException("Invalid data is supplied ::" +fieldName);
        }
    }
    public void setTaxAndComplianceDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "GSTIN":
                sendKeys(txt_GSTIN, value, true);
                break;
            case "GSTIN EFFECTIVE DATE":
                waitAndClick(btn_GstinEffectiveDate);
                waitAndClick(selectDate);
                break;
            case "PAN NUMBER":
                sendKeys(txt_PanNumber, value, true);
                break;
            default:
                throw new IllegalArgumentException("Invalid data is supplied ::" + fieldName);
        }
    }
    public void setKeyContactDetails(String fieldName, String value){
        switch (fieldName.toUpperCase()){
            case "NAME":
                value = generateName() + value;
                sendKeys(txt_Name, value, true);
                break;
            case "DESIGNATION":
                value = generateName() + value;
                sendKeys(txt_Designation, value, true);
                break;
            case "EMAIL":
                value = generateName()+value;
                sendKeys(txt_Email, value, true);
                break;
            case "COUNTRY CODE":
                sendKeys(drp_CountryCode, value, true);
                break;
            case "PHONE NUMBER":
                sendKeys(txt_PhoneNumber, value, true);
                break;
            default:
                throw new IllegalArgumentException("Invalid data is supplied ::" + fieldName);
        }
    }
}