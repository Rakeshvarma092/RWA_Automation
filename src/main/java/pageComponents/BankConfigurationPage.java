package pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class BankConfigurationPage extends DriverUtils {

    //======================= LOCATORS =======================//

    private static final String DYNAMIC_TAB = "//span[contains(text(),'%s')]";

    //**** Navigation ****

    @FindBy(xpath = "//span[contains(text(),' settings_suggest '])")
    private WebElement option_Settings;

    @FindBy(xpath = "//span[text()=' Bank Configuration ']")
    private WebElement option_BankConfiguration;

    //**** Page Titles ****

    @FindBy(xpath = "//p[text()='Bank']")
    private WebElement title_BankConfiguration;

    //**** Dynamic Tab Locator ****

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Dynamic;

    //===== COMPANY BANK TAB =====

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CompanyBank;

    @FindBy(xpath = "//p[text()=' Add Company Bank ']")
    private WebElement title_AddCompanyBank;

    @FindBy(xpath = "//input[@name='bname']")
    private WebElement txt_BankName;

    @FindBy(xpath = "//input[@name='anum']")
    private WebElement txt_AccountNumber;

    @FindBy(xpath = "//textarea[@name='baddress']")
    private WebElement txt_BranchAddress;

    @FindBy(xpath = "//input[@name='ifsc']")
    private WebElement txt_IFSCCode;

    @FindBy(xpath = "//input[@name='upiID']")
    private WebElement txt_UPIID;

    @FindBy(xpath = "//label[contains(text(),'Primary Account')]")
    private WebElement chk_PrimaryAccount;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_CompanyBank;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_CompanyBank;

    //===== CUSTOMER BANK TAB =====

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CustomerBank;

    @FindBy(xpath = "//p[text()=' Add Customer Bank ']")
    private WebElement title_AddCustomerBank;

    @FindBy(xpath = "//input[@name='bname1']")
    private WebElement txt_CustomerBankName;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_CustomerBank;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_CustomerBank;

    //======================= CONSTRUCTOR =======================//

    public BankConfigurationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //======================= PAGE ACTION =========================//

}
