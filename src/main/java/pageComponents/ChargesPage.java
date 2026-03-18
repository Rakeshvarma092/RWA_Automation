package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class ChargesPage extends DriverUtils {

    public ChargesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Charge Master']")
    private WebElement option_ChargeMaster;

    @FindBy(xpath = "//span[text()=' Charges ']")
    private WebElement option_Charges;

    @FindBy(xpath = "//p[text()='Charges']")
    private WebElement title_Charges;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Option;

    //====================================== PLC Charge Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_PLCCharge;

    @FindBy(xpath = "//p[text()=' Add PLC Charge ']")
    private WebElement title_AddPLCCharge;

    @FindBy(xpath = "//mat-select[@name='prj']")
    private WebElement drp_ProjectName_PLCCharge;

    @FindBy(xpath = "//input[@name='charge']")
    private WebElement txt_ChargeName_PLCCharge;

    @FindBy(xpath = "//label[text()='in %']")
    private WebElement radio_Percentage_PLCCharge;

    @FindBy(xpath = "//label[text()='Per Area']")
    private WebElement radio_PerArea_PLCCharge;

    @FindBy(xpath = "//label[text()='Fixed']")
    private WebElement radio_Fixed_PLCCharge;

    @FindBy(xpath = "(//button[contains(@type,'button')])[7]")
    private WebElement btn_EffectiveDate;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_Date;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_Description_PLCCharge;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_PLCCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_PLCCharge;

    //====================================== Other Charges Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_OtherCharge;

    @FindBy(xpath = "//p[text()=' Add Other Charges ']")
    private WebElement title_AddOtherCharge;

    @FindBy(xpath = "//mat-select[@name='prj']")
    private WebElement drp_ProjectName_OtherCharge;

    @FindBy(xpath = "//input[@name='charge']")
    private WebElement txt_ChargeName_OtherCharge;

    @FindBy(xpath = "//label[text()='in %']")
    private WebElement radio_Percentage_OtherCharge;

    @FindBy(xpath = "//label[text()='Per Area']")
    private WebElement radio_PerArea_OtherCharge;

    @FindBy(xpath = "//label[text()='Fixed']")
    private WebElement radio_Fixed_OtherCharge;

    @FindBy(xpath = "(//button[contains(@type,'button')])[7]")
    private WebElement btn_EffectiveDate_OtherCharge;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_Date_OtherCharge;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_Description_OtherCharge;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_OtherCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_OtherCharge;

    //====================================== IFMS Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_IFMS;

    @FindBy(xpath = "//p[text()=' Add IFMS ']")
    private WebElement title_AddIFMS;

    @FindBy(xpath = "//mat-select[@name='prj']")
    private WebElement drp_ProjectName_IFMS;

    @FindBy(xpath = "//input[@name='charge']")
    private WebElement txt_ChargeName_IFMS;

    @FindBy(xpath = "//label[text()='in %']")
    private WebElement radio_Percentage_IFMS;

    @FindBy(xpath = "//label[text()='Per Area']")
    private WebElement radio_PerArea_IFMS;

    @FindBy(xpath = "//label[text()='Fixed']")
    private WebElement radio_Fixed_IFMS;

    @FindBy(xpath = "(//button[contains(@type,'button')])[7]")
    private WebElement btn_EffectiveDate_IFMS;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_Date_IFMS;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_Description_IFMS;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_IFMS;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_IFMS;

    //====================================== Add On Charges Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_AddOnCharge;

    @FindBy(xpath = "//p[text()=' Add Add on ']")
    private WebElement title_AddAddOnCharge;

    @FindBy(xpath = "//mat-select[@name='prj']")
    private WebElement drp_ProjectName_AddOnCharge;

    @FindBy(xpath = "//input[@name='charge']")
    private WebElement txt_ChargeName_AddOnCharge;

    @FindBy(xpath = "//mat-select[@name='chtype']")
    private WebElement drp_ChargeType_AddOnCharge;

    @FindBy(xpath = "//mat-select[@name='calculateAt']")
    private WebElement drp_CalculateAt_AddOnCharge;

    @FindBy(xpath = "//label[text()='in %']")
    private WebElement radio_Percentage_AddOnCharge;

    @FindBy(xpath = "//label[text()='Per Area']")
    private WebElement radio_PerArea_AddOnCharge;

    @FindBy(xpath = "//label[text()='Fixed']")
    private WebElement radio_Fixed_AddOnCharge;

    @FindBy(xpath = "(//button[contains(@type,'button')])[7]")
    private WebElement btn_EffectiveDate_AddOnCharge;

    @FindBy(xpath = "//button[contains(@class,'mat-calendar-body-active')]")
    private WebElement select_Date_AddOnCharge;

    @FindBy(xpath = "//button[@name='mandate']")
    private WebElement toggle_Mandatory_AddOnCharge;

    @FindBy(xpath = "//button[@name='alter']")
    private WebElement toggle_Negotiations_AddOnCharge;

    @FindBy(xpath = "//button[@name='base']")
    private WebElement toggle_InventoryLinkedBase_AddOnCharge;

    @FindBy(xpath = "//textarea[@name='desc']")
    private WebElement txt_Description_AddOnCharge;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_AddOnCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_AddOnCharge;

    public void clickChargeMaster() {
        waitAndClick(option_ChargeMaster);
    }

    public void clickCharges() {
        waitAndClick(option_Charges);
    }

    public boolean isChargesTitleDisplayed() {
        waitUntilVisible(title_Charges);
        return title_Charges.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath("//span[contains(text(),'" + tabName + "')]"));
    }

    public void clickNew(String chargeType) {
        switch (chargeType.toUpperCase()) {
            case "PLC CHARGE":
                waitAndClick(btn_New_PLCCharge);
                break;
            case "OTHER CHARGES":
                waitAndClick(btn_New_OtherCharge);
                break;
            case "IFMS":
                waitAndClick(btn_New_IFMS);
                break;
            case "ADD ON CHARGES":
                waitAndClick(btn_New_AddOnCharge);
                break;
        }
    }

    public boolean isAddChargeTitleDisplayed(String chargeType) {
        WebElement element = null;
        switch (chargeType.toUpperCase()) {
            case "PLC CHARGE":
                element = title_AddPLCCharge;
                break;
            case "OTHER CHARGES":
                element = title_AddOtherCharge;
                break;
            case "IFMS":
                element = title_AddIFMS;
                break;
            case "ADD ON CHARGES":
                element = title_AddAddOnCharge;
                break;
        }
        if (element != null) {
            waitUntilVisible(element);
            return element.isDisplayed();
        }
        return false;
    }

    public void setPLCChargeDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                customDropDownSelection(drp_ProjectName_PLCCharge, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CHARGE NAME":
                sendKeys(txt_ChargeName_PLCCharge, value, true);
                break;
            case "CHARGE TYPE":
                if (value.equalsIgnoreCase("in %")) {
                    waitAndClick(radio_Percentage_PLCCharge);
                } else if (value.equalsIgnoreCase("Per Area")) {
                    waitAndClick(radio_PerArea_PLCCharge);
                } else if (value.equalsIgnoreCase("Fixed")) {
                    waitAndClick(radio_Fixed_PLCCharge);
                }
                break;
            case "EFFECTIVE DATE":
                waitAndClick(btn_EffectiveDate);
                waitAndClick(select_Date);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_PLCCharge, value, true);
                break;
        }
    }

    public void setOtherChargeDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                customDropDownSelection(drp_ProjectName_OtherCharge, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CHARGE NAME":
                sendKeys(txt_ChargeName_OtherCharge, value, true);
                break;
            case "CHARGE TYPE":
                if (value.equalsIgnoreCase("in %")) {
                    waitAndClick(radio_Percentage_OtherCharge);
                } else if (value.equalsIgnoreCase("Per Area")) {
                    waitAndClick(radio_PerArea_OtherCharge);
                } else if (value.equalsIgnoreCase("Fixed")) {
                    waitAndClick(radio_Fixed_OtherCharge);
                }
                break;
            case "EFFECTIVE DATE":
                waitAndClick(btn_EffectiveDate_OtherCharge);
                waitAndClick(select_Date_OtherCharge);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_OtherCharge, value, true);
                break;
        }
    }

    public void setIFMSDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                customDropDownSelection(drp_ProjectName_IFMS, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CHARGE NAME":
                sendKeys(txt_ChargeName_IFMS, value, true);
                break;
            case "CHARGE TYPE":
                if (value.equalsIgnoreCase("in %")) {
                    waitAndClick(radio_Percentage_IFMS);
                } else if (value.equalsIgnoreCase("Per Area")) {
                    waitAndClick(radio_PerArea_IFMS);
                } else if (value.equalsIgnoreCase("Fixed")) {
                    waitAndClick(radio_Fixed_IFMS);
                }
                break;
            case "EFFECTIVE DATE":
                waitAndClick(btn_EffectiveDate_IFMS);
                waitAndClick(select_Date_IFMS);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_IFMS, value, true);
                break;
        }
    }

    public void setAddOnChargeDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                customDropDownSelection(drp_ProjectName_AddOnCharge, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CHARGE NAME":
                sendKeys(txt_ChargeName_AddOnCharge, value, true);
                break;
            case "CHARGE TYPE CATEGORY":
                customDropDownSelection(drp_ChargeType_AddOnCharge, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CALCULATE AT":
                customDropDownSelection(drp_CalculateAt_AddOnCharge, By.xpath("//span[contains(text(),'" + value + "')]"));
                break;
            case "CHARGE TYPE":
                if (value.equalsIgnoreCase("in %")) {
                    waitAndClick(radio_Percentage_AddOnCharge);
                } else if (value.equalsIgnoreCase("Per Area")) {
                    waitAndClick(radio_PerArea_AddOnCharge);
                } else if (value.equalsIgnoreCase("Fixed")) {
                    waitAndClick(radio_Fixed_AddOnCharge);
                }
                break;
            case "EFFECTIVE DATE":
                waitAndClick(btn_EffectiveDate_AddOnCharge);
                waitAndClick(select_Date_AddOnCharge);
                break;
            case "MANDATORY":
                if (value.equalsIgnoreCase("Yes")) waitAndClick(toggle_Mandatory_AddOnCharge);
                break;
            case "NEGOTIATIONS":
                if (value.equalsIgnoreCase("Yes")) waitAndClick(toggle_Negotiations_AddOnCharge);
                break;
            case "INVENTORY LINKED BASE":
                if (value.equalsIgnoreCase("Yes")) waitAndClick(toggle_InventoryLinkedBase_AddOnCharge);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_AddOnCharge, value, true);
                break;
        }
    }

    public void clickSave(String chargeType) {
        switch (chargeType.toUpperCase()) {
            case "PLC CHARGE":
                waitAndClick(btn_Save_PLCCharge);
                break;
            case "OTHER CHARGES":
                waitAndClick(btn_Save_OtherCharge);
                break;
            case "IFMS":
                waitAndClick(btn_Save_IFMS);
                break;
            case "ADD ON CHARGES":
                waitAndClick(btn_Save_AddOnCharge);
                break;
        }
    }

    public void clickCancel(String chargeType) {
        switch (chargeType.toUpperCase()) {
            case "PLC CHARGE":
                waitAndClick(btn_Cancel_PLCCharge);
                break;
            case "OTHER CHARGES":
                waitAndClick(btn_Cancel_OtherCharge);
                break;
            case "IFMS":
                waitAndClick(btn_Cancel_IFMS);
                break;
            case "ADD ON CHARGES":
                waitAndClick(btn_Cancel_AddOnCharge);
                break;
        }
    }
}