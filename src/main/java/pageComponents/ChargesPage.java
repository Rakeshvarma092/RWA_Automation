package pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class ChargesPage extends DriverUtils {

    //====================== Locators ======================//

    @FindBy(xpath = "//span[text()='Charge Master']")
    private WebElement option_ChargeMaster;

    @FindBy(xpath = "//span[text()=' Charges ']")
    private WebElement option_Charges;

    //**** Page Titles ****

    @FindBy(xpath = "//p[text()='Charges']")
    private WebElement title_Charges;

    //**** Dynamic Tab Locator ****

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Option;

    //==== PLC Charge Tab ====

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

    //**** Buttons ****

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_PLCCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_PLCCharge;

    //==== Other Charges Tab ====

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

    //**** Buttons ****

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_OtherCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_OtherCharge;

    //==== IFMS Tab ====

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

    //**** Buttons ****

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_IFMS;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_IFMS;

    //==== Add On Charges Tab ====

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

    //**** Buttons ****

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_AddOnCharge;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_AddOnCharge;

    //====================== Constructor ======================//

    public ChargesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //======================== PAGE ACTIONS ======================//
}
