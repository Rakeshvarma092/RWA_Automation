package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class MasterDataPage extends DriverUtils {

    private static final String SELECT_DROPDOWN = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[text()=' settings_suggest ']")
    private WebElement icon_Configuration;

    @FindBy(xpath = "//span[text()=' Master Data ']")
    private WebElement option_MasterData;

    @FindBy(xpath = "//p[text()='Master Data']")// Assuming this is the title of the Master Data page
    private WebElement title_MasterData;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Dynamic;

    //====================================== PROJECT TYPE TAB ========================================
    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New;

    @FindBy(xpath = "//p[text()=' New Project Type ']")
    private WebElement title_NewProjectType;

    @FindBy(xpath = "//input[@name='pr']")
    private WebElement txt_Name;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel;

    //====================================== CUSTOMER PROFESSION TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CustomerProfession;

    @FindBy(xpath = "//p[text()=' New Customer Profession ']")
    private WebElement title_NewCustomerProfession;

    @FindBy(xpath = "//input[@name='prof']")
    private WebElement txt_CustomerProfessionName;

    @FindBy(xpath = "//span[text()='Cancel']")
    private WebElement btn_Cancel_CustomerProfession;

    @FindBy(xpath = "//span[text()=' Save ']")
    private WebElement btn_Save_CustomerProfession;

    //====================================== CUSTOMER CLASSIFICATION TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CustomerClassification;

    @FindBy(xpath = "//p[text()=' New Customer Classification ']")
    private WebElement title_NewCustomerClassification;

    @FindBy(xpath = "//input[@name='customer']")
    private WebElement txt_CustomerClassificationName;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_CustomerClassificationDescription;

    @FindBy(xpath = "//span[text()='Cancel']")
    private WebElement btn_Cancel_CustomerClassification;

    @FindBy(xpath = "//span[text()=' Save ']")
    private WebElement btn_Save_CustomerClassification;

   //====================================== CUSTOMER STAGE TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_CustomerStage;

    @FindBy(xpath = "//p[text()=' Add Stage Type ']")
    private WebElement title_NewCustomerStage;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement txt_CustomerStageName;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement txt_CustomerStageDescription;

    @FindBy(xpath = "//span[text()=' Cancel ']")
    private WebElement btn_Cancel_CustomerStage;

    @FindBy(xpath = "//span[text()=' Save ']")
    private WebElement btn_Save_CustomerStage;

    //====================================== DOCUMENT TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_Document;

    @FindBy(xpath = "//p[text()=' Add Document ']")
    private WebElement title_NewDocument;

    @FindBy(xpath = "//input[@name='docName']")
    private WebElement txt_DocumentName;

    @FindBy(xpath = "//mat-select[@name='source']")
    private WebElement drp_DocumentSource;

    @FindBy(xpath = "//mat-select[@name='docFrom']")
    private WebElement drp_CustomerStage;

    @FindBy(xpath = "//label[text()='Yes']")
    private WebElement radio_RequiredYes;

    @FindBy(xpath = "//label[text()='No']")
    private WebElement radio_RequiredNo;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_DocumentDescription;

    @FindBy(xpath = "//span[text()=' Cancel ']")
    private WebElement btn_Cancel_Document;

    @FindBy(xpath = "//span[text()=' Save ']")
    private WebElement btn_Save_Document;

    public MasterDataPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickConfiguration() {
        waitAndClick(icon_Configuration);
    }

    public void clickMasterData() {
        waitAndClick(option_MasterData);
    }

    public boolean isMasterDataTitleDisplayed() {
        waitUntilVisible(title_MasterData);
        return title_MasterData.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath(String.format(SELECT_DROPDOWN, tabName)));
    }

    public void clickNew() {
        waitAndClick(btn_New);
    }

    public boolean isNewProjectTypeTitleDisplayed() {
        waitUntilVisible(title_NewProjectType);
        return title_NewProjectType.isDisplayed();
    }

    public void enterProjectTypeName(String name) {
        sendKeys(txt_Name, name, true);
    }

    public boolean isNewCustomerProfessionTitleDisplayed() {
        waitUntilVisible(title_NewCustomerProfession);
        return title_NewCustomerProfession.isDisplayed();
    }

    public void enterCustomerProfessionName(String name) {
        sendKeys(txt_CustomerProfessionName, name, true);
    }

    public boolean isNewCustomerClassificationTitleDisplayed() {
        waitUntilVisible(title_NewCustomerClassification);
        return title_NewCustomerClassification.isDisplayed();
    }

    public void enterCustomerClassificationName(String name) {
        sendKeys(txt_CustomerClassificationName, name, true);
    }

    public void enterCustomerClassificationDescription(String description) {
        sendKeys(txt_CustomerClassificationDescription, description, true);
    }

    public boolean isNewCustomerStageTitleDisplayed() {
        waitUntilVisible(title_NewCustomerStage);
        return title_NewCustomerStage.isDisplayed();
    }

    public void enterCustomerStageName(String name) {
        sendKeys(txt_CustomerStageName, name, true);
    }

    public void enterCustomerStageDescription(String description) {
        sendKeys(txt_CustomerStageDescription, description, true);
    }

    public boolean isNewDocumentTitleDisplayed() {
        waitUntilVisible(title_NewDocument);
        return title_NewDocument.isDisplayed();
    }

    public void enterDocumentName(String name) {
        sendKeys(txt_DocumentName, name, true);
    }

    public void selectDocumentSource(String source) {
        customDropDownSelection(drp_DocumentSource, By.xpath(String.format(SELECT_DROPDOWN, source)));
    }

    public void selectDocumentCustomerStage(String stage) {
        customDropDownSelection(drp_CustomerStage, By.xpath(String.format(SELECT_DROPDOWN, stage)));
    }

    public void selectDocumentRequired(String isRequired) {
        if (isRequired.equalsIgnoreCase("Yes")) {
            waitAndClick(radio_RequiredYes);
        } else {
            waitAndClick(radio_RequiredNo);
        }
    }

    public void enterDocumentDescription(String description) {
        sendKeys(txt_DocumentDescription, description, true);
    }

    public void clickSave() {
        waitAndClick(btn_Save);
    }

    public void clickCancel() {
        waitAndClick(btn_Cancel);
    }

    /**
     * Common method to set details based on field name for any Master Data tab
     */
    public void setMasterDataDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "NAME":
            case "PROJECT TYPE NAME":
                enterProjectTypeName(value);
                break;
            case "CUSTOMER PROFESSION NAME":
                enterCustomerProfessionName(value);
                break;
            case "CUSTOMER CLASSIFICATION NAME":
                enterCustomerClassificationName(value);
                break;
            case "CUSTOMER CLASSIFICATION DESCRIPTION":
            case "DESCRIPTION":
                // This might be tricky if both name and desc are "DESCRIPTION" on different tabs
                // But usually we can distinguish by field name in feature file
                if (txt_CustomerClassificationDescription.isDisplayed()) {
                    enterCustomerClassificationDescription(value);
                } else if (txt_CustomerStageDescription.isDisplayed()) {
                    enterCustomerStageDescription(value);
                } else if (txt_DocumentDescription.isDisplayed()) {
                    enterDocumentDescription(value);
                }
                break;
            case "CUSTOMER STAGE NAME":
                enterCustomerStageName(value);
                break;
            case "CUSTOMER STAGE DESCRIPTION":
                enterCustomerStageDescription(value);
                break;
            case "DOCUMENT NAME":
                enterDocumentName(value);
                break;
            case "DOCUMENT SOURCE":
                selectDocumentSource(value);
                break;
            case "STAGE":
                selectDocumentCustomerStage(value);
                break;
            case "IS REQUIRED":
                selectDocumentRequired(value);
                break;
            case "DOCUMENT DESCRIPTION":
                enterDocumentDescription(value);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }
}