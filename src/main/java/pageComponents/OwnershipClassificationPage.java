package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class OwnershipClassificationPage extends DriverUtils {

    private static final String DRP_OPTION = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(),' Ownership Classification ')]")
    private WebElement ownershipClassificationTab;

    @FindBy(xpath = "//p[contains(text(),'Ownership Classification')]")
    private WebElement ownershipClassificationHeader;

    //==================================== OWNER TYPE TAB  ===========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_OwnerTower;

    @FindBy(xpath = "//p[contains(text(),' Add Owner Type ')]")
    private WebElement addOwnerTypeHeader;

    @FindBy(xpath = "//mat-select[@name='project']")
    private WebElement drp_Project;

    @FindBy(xpath = "//mat-select[@name='--Select--']")
    private WebElement drp_UnitClassification;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement txt_OwnerTypeName;
    
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_OwnerType;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_OwnerType;

    public OwnershipClassificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOwnershipClassification() {
        waitAndClick(ownershipClassificationTab);
    }

    public boolean isOwnershipClassificationHeaderDisplayed() {
        waitUntilVisible(ownershipClassificationHeader);
        return ownershipClassificationHeader.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath(String.format(DRP_OPTION, tabName)));
    }

    public void clickNew() {
        waitAndClick(btn_New_OwnerTower);
    }

    public boolean isAddOwnerTypeHeaderDisplayed() {
        waitUntilVisible(addOwnerTypeHeader);
        return addOwnerTypeHeader.isDisplayed();
    }

    public void setOwnerTypeDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "PROJECT":
                customDropDownSelection(drp_Project, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "UNIT CLASSIFICATION":
                customDropDownSelection(drp_UnitClassification, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "OWNER TYPE NAME":
                sendKeys(txt_OwnerTypeName, value, true);
                break;
            default:
                System.out.println("Invalid field name: " + fieldName);
        }
    }

    public void clickSave() {
        waitAndClick(btn_Save_OwnerType);
    }

    public void clickCancel() {
        waitAndClick(btn_Cancel_OwnerType);
    }
}