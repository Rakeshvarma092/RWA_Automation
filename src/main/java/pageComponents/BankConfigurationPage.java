package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class BankConfigurationPage extends DriverUtils {

    private static final String DYNAMIC_TAB = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[text()=' Bank Configuration ']")
    private WebElement option_BankConfiguration;

    @FindBy(xpath = "//p[text()='Bank']")// Assuming this is the title of the Bank Configuration page
    private WebElement title_BankConfiguration;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Dynamic;

    //====================================== COMPANY BANK TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CompanyBank;

    @FindBy(xpath = "//p[text()=' Add Company Bank ']")
    private WebElement title_AddCompanyBank;

    @FindBy(xpath = "//input[@name='bname']") // Assuming this is the input field for Bank Name
    private WebElement txt_BankName;

    @FindBy(xpath = "//input[@name='anum']") // Assuming this is the input field for Account Number
    private WebElement txt_AccountNumber;

    @FindBy(xpath = "//input[@name='baddress']") // Assuming this is the input field for Branch Address
    private WebElement txt_BranchAddress;

    @FindBy(xpath = "//input[@name='ifsc']") // Assuming this is the input field for IFSC Code
    private WebElement txt_IFSCCode;

    @FindBy(xpath = "//input[@name='upiID']") // Assuming this is the input field for UPI ID
    private WebElement txt_UPIID;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_CompanyBank;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_CompanyBank;

    //====================================== CUSTOMER BANK TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CustomerBank;

    @FindBy(xpath = "//p[text()=' Add Customer Bank ']")
    private WebElement title_AddCustomerBank;

    @FindBy(xpath = "//input[@name='bname1']") // Assuming this is the input field for Customer Bank Name
    private WebElement txt_CustomerBankName;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_CustomerBank;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_CustomerBank;

    public BankConfigurationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBankConfiguration() {
        waitAndClick(option_BankConfiguration);
    }

    public boolean isBankConfigurationTitleDisplayed() {
        waitUntilVisible(title_BankConfiguration);
        return title_BankConfiguration.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath(String.format(DYNAMIC_TAB, tabName)));
    }

    public void clickNew() {
        // Since both tabs have "+ New", we rely on which one is visible or use a general one if they are identical
        if (btn_New_CompanyBank.isDisplayed()) {
            waitAndClick(btn_New_CompanyBank);
        } else {
            waitAndClick(btn_New_CustomerBank);
        }
    }

    public boolean isAddCompanyBankTitleDisplayed() {
        waitUntilVisible(title_AddCompanyBank);
        return title_AddCompanyBank.isDisplayed();
    }

    public boolean isAddCustomerBankTitleDisplayed() {
        waitUntilVisible(title_AddCustomerBank);
        return title_AddCustomerBank.isDisplayed();
    }

    public void setCompanyBankDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "BANK NAME":
                sendKeys(txt_BankName, value, true);
                break;
            case "ACCOUNT NUMBER":
                sendKeys(txt_AccountNumber, value, true);
                break;
            case "BRANCH ADDRESS":
                sendKeys(txt_BranchAddress, value, true);
                break;
            case "IFSC CODE":
                sendKeys(txt_IFSCCode, value, true);
                break;
            case "UPI ID":
                sendKeys(txt_UPIID, value, true);
                break;
        }
    }

    public void setCustomerBankDetails(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("BANK NAME")) {
            sendKeys(txt_CustomerBankName, value, true);
        }
    }

    public void clickSave() {
        if (btn_Save_CompanyBank.isDisplayed()) {
            waitAndClick(btn_Save_CompanyBank);
        } else {
            waitAndClick(btn_Save_CustomerBank);
        }
    }

    public void clickCancel() {
        if (btn_Cancel_CompanyBank.isDisplayed()) {
            waitAndClick(btn_Cancel_CompanyBank);
        } else {
            waitAndClick(btn_Cancel_CustomerBank);
        }
    }
}