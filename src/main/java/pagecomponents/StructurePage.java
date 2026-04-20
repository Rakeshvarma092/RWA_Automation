package pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class StructurePage extends DriverUtils {

    @FindBy(xpath = "//span[text()='Project Setup']")
    private WebElement option_ProjectSetup;

    private static final String DRP_OPTION = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//span[text()=' Structure ']")
    private WebElement option_Structure;

    @FindBy(xpath = "//p[text()='Structure setup']") // Assuming this is the title of the Structure page
    private WebElement title_Structure;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Dynamic;

    //====================================== TOWER TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_Tower;

    @FindBy(xpath = "//p[text()=' Add Tower  ']")
    private WebElement title_AddTower;

    @FindBy(xpath = "//mat-select[@name='project']")
    private WebElement drp_ProjectName_Tower;

    @FindBy(xpath = "//mat-select[@name='Towers']")
    private WebElement drp_TowerNumber_Tower;

    @FindBy(xpath = "//input[@name='tname']")
    private WebElement txt_TowerName_Tower;

    @FindBy(xpath = "//input[@name='fnum']")
    private WebElement txt_BaseFloors_Tower;

    @FindBy(xpath = "//input[@name='fname']")
    private WebElement txt_BaseFloorName_Tower;

    @FindBy(xpath = "//mat-select[@name='ptype']")
    private WebElement drp_PatternType_Tower;

    @FindBy(xpath = "//input[@name='tfnum']")
    private WebElement txt_TotalFloorsNumber_Tower;

    @FindBy(xpath = "//input[@name='tunum']")
    private WebElement txt_TotalUnits_Tower;

    @FindBy(xpath = "//mat-select[@name='cSts']")
    private WebElement drp_ConstructionStatus_Tower;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_Tower;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_Tower;

    //====================================== UNIT TYPE TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_UnitType;

    @FindBy(xpath = "//p[text()=' Add Unit Type ']")
    private WebElement title_AddUnitType;

    //************* Pricing & Cost Details Section *************//

    @FindBy(xpath = "//input[@name='rate']")
    private WebElement txt_BaseRate_UnitType;

    @FindBy(xpath = "//input[@name='consCost']")
    private WebElement txt_ConstructionCost_UnitType;

    @FindBy(xpath = "//input[@name='udslCost']")
    private WebElement txt_UDSLCost_UnitType;

    //************* Area Details Section *************//

    @FindBy(xpath = "//mat-select[@name='effRate']")
    private WebElement drp_EffectiveRate_UnitType;

    @FindBy(xpath = "//input[@name='sareaType']")
    private WebElement txt_SuperArea_UnitType;

    @FindBy(xpath = "//input[@name='careaType']")
    private WebElement txt_CarpetArea_UnitType;

    @FindBy(xpath = "//input[@name='bAreaType']")
    private WebElement txt_BuiltupArea_UnitType;

    @FindBy(xpath = "//input[@name='plotArea']")
    private WebElement txt_PlotArea_UnitType;

    @FindBy(xpath = "//input[@name='udslArea']")
    private WebElement txt_UDSLArea_UnitType;

    @FindBy(xpath = "//input[@name='balAtype']")
    private WebElement txt_BalconyArea_UnitType;

    @FindBy(xpath = "//mat-select[@name='uom']")
    private WebElement drp_UOM_UnitType;

    //************* Project & Type Details Section *************//

    @FindBy(xpath = "//mat-select[@name='project']")
    private WebElement drp_Project_UnitType;

    @FindBy(xpath = "//mat-select[@name='type']")
    private WebElement drp_RateType_UnitType;

    @FindBy(xpath = "//input[@name='areaType']")
    private WebElement txt_AreaCategory_UnitType;

    @FindBy(xpath = "//input[@name='putn']")
    private WebElement txt_UnitTypeName_UnitType;

    //************* Display & Integration Settings Section *************//

    @FindBy(xpath = "//mat-select[@name='payFile']")
    private WebElement drp_AreaDisplayonPaymentFile_UnitType;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement txt_Description_UnitType;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_UnitType;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_UnitType;

    //====================================== UNIT LOCATION TAB ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_UnitLocation;

    @FindBy(xpath = "//p[text()=' Add Unit Location  ']")
    private WebElement title_AddUnitLocation;

    @FindBy(xpath = "//mat-select[@name='project']")
    private WebElement drp_Project_UnitLocation;

    @FindBy(xpath = "//input[@name='facing']")
    private WebElement txt_Facing_UnitLocation;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement txt_Description_UnitLocation;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_UnitLocation;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_UnitLocation;

    public StructurePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProjectSetup() {
        waitAndClick(option_ProjectSetup);
    }

    public void clickStructure() {
        waitAndClick(option_Structure);
    }

    public boolean isStructureTitleDisplayed() {
        waitUntilVisible(title_Structure);
        return title_Structure.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath(String.format(DRP_OPTION, tabName)));
    }

    public void clickNew() {
        if (btn_New_Tower.isDisplayed()) {
            waitAndClick(btn_New_Tower);
        } else if (btn_New_UnitType.isDisplayed()) {
            waitAndClick(btn_New_UnitType);
        } else {
            waitAndClick(btn_New_UnitLocation);
        }
    }

    public boolean isAddTowerTitleDisplayed() {
        waitUntilVisible(title_AddTower);
        return title_AddTower.isDisplayed();
    }

    public boolean isAddUnitTypeTitleDisplayed() {
        waitUntilVisible(title_AddUnitType);
        return title_AddUnitType.isDisplayed();
    }

    public boolean isAddUnitLocationTitleDisplayed() {
        waitUntilVisible(title_AddUnitLocation);
        return title_AddUnitLocation.isDisplayed();
    }

    public void setTowerDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "PROJECT NAME":
                customDropDownSelection(drp_ProjectName_Tower, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "TOWER NUMBER":
                customDropDownSelection(drp_TowerNumber_Tower, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "TOWER NAME":
                sendKeys(txt_TowerName_Tower, value, true);
                break;
            case "BASE FLOORS":
                sendKeys(txt_BaseFloors_Tower, value, true);
                break;
            case "BASE FLOOR NAME":
                sendKeys(txt_BaseFloorName_Tower, value, true);
                break;
            case "PATTERN TYPE":
                customDropDownSelection(drp_PatternType_Tower, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "TOTAL FLOORS":
                sendKeys(txt_TotalFloorsNumber_Tower, value, true);
                break;
            case "TOTAL UNITS":
                sendKeys(txt_TotalUnits_Tower, value, true);
                break;
            case "CONSTRUCTION STATUS":
                customDropDownSelection(drp_ConstructionStatus_Tower, By.xpath(String.format(DRP_OPTION, value)));
                break;
        }
    }

    public void setUnitTypeDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "BASE RATE":
                sendKeys(txt_BaseRate_UnitType, value, true);
                break;
            case "CONSTRUCTION COST":
                sendKeys(txt_ConstructionCost_UnitType, value, true);
                break;
            case "UDSL COST":
                sendKeys(txt_UDSLCost_UnitType, value, true);
                break;
            case "EFFECTIVE RATE":
                customDropDownSelection(drp_EffectiveRate_UnitType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "SUPER AREA":
                sendKeys(txt_SuperArea_UnitType, value, true);
                break;
            case "CARPET AREA":
                sendKeys(txt_CarpetArea_UnitType, value, true);
                break;
            case "BUILTUP AREA":
                sendKeys(txt_BuiltupArea_UnitType, value, true);
                break;
            case "PLOT AREA":
                sendKeys(txt_PlotArea_UnitType, value, true);
                break;
            case "UDSL AREA":
                sendKeys(txt_UDSLArea_UnitType, value, true);
                break;
            case "BALCONY AREA":
                sendKeys(txt_BalconyArea_UnitType, value, true);
                break;
            case "UOM":
                customDropDownSelection(drp_UOM_UnitType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "PROJECT":
                customDropDownSelection(drp_Project_UnitType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "RATE TYPE":
                customDropDownSelection(drp_RateType_UnitType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "AREA CATEGORY":
                sendKeys(txt_AreaCategory_UnitType, value, true);
                break;
            case "UNIT TYPE NAME":
                sendKeys(txt_UnitTypeName_UnitType, value, true);
                break;
            case "AREA DISPLAY ON PAYMENT FILE":
                customDropDownSelection(drp_AreaDisplayonPaymentFile_UnitType, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_UnitType, value, true);
                break;
        }
    }

    public void setUnitLocationDetails(String fieldName, String value) {
        switch (fieldName.toUpperCase()) {
            case "PROJECT":
                customDropDownSelection(drp_Project_UnitLocation, By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "FACING":
                sendKeys(txt_Facing_UnitLocation, value, true);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description_UnitLocation, value, true);
                break;
        }
    }

    public void clickSave() {
        if (btn_Save_Tower.isDisplayed()) {
            waitAndClick(btn_Save_Tower);
        } else if (btn_Save_UnitType.isDisplayed()) {
            waitAndClick(btn_Save_UnitType);
        } else {
            waitAndClick(btn_Save_UnitLocation);
        }
    }

    public void clickCancel() {
        if (btn_Cancel_Tower.isDisplayed()) {
            waitAndClick(btn_Cancel_Tower);
        } else if (btn_Cancel_UnitType.isDisplayed()) {
            waitAndClick(btn_Cancel_UnitType);
        } else {
            waitAndClick(btn_Cancel_UnitLocation);
        }
    }
}
