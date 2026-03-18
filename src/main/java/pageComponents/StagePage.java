package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class StagePage extends DriverUtils {

    public StagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Payment Setup']")
    private WebElement option_PaymentSetup;

    @FindBy(xpath = "//span[text()=' Stage ']")
    private WebElement option_Stage;

    private static final String DRP_OPTION = "//span[contains(text(),'%s')]";

    @FindBy(xpath = "//p[text()='Payment Plan']")
    private WebElement title_PaymentSetup;

    @FindBy(xpath = "//span[contains(text(),'%s')]")
    private WebElement tab_Option;

    //====================================== Construction Stage Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_ConstructionStage;

    @FindBy(xpath = "//p[text()=' Add Stage Master ']")
    private WebElement title_AddStageMaster;

    @FindBy(xpath = "//mat-select[@name='project']")
    private WebElement drp_ProjectName;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement txt_StageName;

    @FindBy(xpath = "//input[@name='rank']")
    private WebElement txt_Rank;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement txt_Description;

    @FindBy(xpath = "//label[text()='Time Bound']")
    private WebElement radio_TimeBound;

    @FindBy(xpath = "//label[text()='Construction Bound']")
    private WebElement radio_ConstructionBound;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_ConstructionStage;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_ConstructionStage;

    //====================================== Payment Plan Tab ========================================

    @FindBy(xpath = "//span[text()=' + New ']")
    private WebElement btn_New_PaymentPlan;

    @FindBy(xpath = "//p[text()=' Add Payment Plan ']")
    private WebElement title_AddPaymentPlan;

    @FindBy(xpath = "//mat-select[@name='projectName']")
    private WebElement drp_PaymentPlan_ProjectName;

    @FindBy(xpath = "//input[@name='planName']")
    private WebElement txt_PaymentPlanName;

    @FindBy(xpath = "//mat-select[@name='planType']")
    private WebElement drp_PaymentPlanType;

    @FindBy(xpath = "//button[@name='discountEnabled']")
    private WebElement toggle_DiscountEnabled;

    @FindBy(xpath = "//mat-select[@name='rateCalculation']")
    private WebElement drp_RateCalculation;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement txt_PaymentPlanDescription;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement btn_Save_PaymentPlan;

    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    private WebElement btn_Cancel_PaymentPlan;

    public void clickPaymentSetup() {
        waitAndClick(option_PaymentSetup);
    }

    public void clickStage() {
        waitAndClick(option_Stage);
    }

    public boolean isPaymentPlanTitleDisplayed() {
        waitUntilVisible(title_PaymentSetup);
        return title_PaymentSetup.isDisplayed();
    }

    public void clickTab(String tabName) {
        waitAndClick(By.xpath("//span[contains(text(),'" + tabName + "')]"));
    }

    public void clickNew(String tabName) {
        if (tabName.equalsIgnoreCase("Construction Stage")) {
            waitAndClick(btn_New_ConstructionStage);
        } else if (tabName.equalsIgnoreCase("Payment Plan")) {
            waitAndClick(btn_New_PaymentPlan);
        }
    }

    public boolean isAddTitleDisplayed(String tabName) {
        if (tabName.equalsIgnoreCase("Construction Stage")) {
            waitUntilVisible(title_AddStageMaster);
            return title_AddStageMaster.isDisplayed();
        } else if (tabName.equalsIgnoreCase("Payment Plan")) {
            waitUntilVisible(title_AddPaymentPlan);
            return title_AddPaymentPlan.isDisplayed();
        }
        return false;
    }

    public void setConstructionStageDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                waitAndClick(drp_ProjectName);
                waitAndClick(By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "STAGE NAME":
                sendKeys(txt_StageName, value, true);
                break;
            case "RANK":
                sendKeys(txt_Rank, value, true);
                break;
            case "DESCRIPTION":
                sendKeys(txt_Description, value, true);
                break;
            case "BOUND TYPE":
                if (value.equalsIgnoreCase("Time Bound")) {
                    waitAndClick(radio_TimeBound);
                } else if (value.equalsIgnoreCase("Construction Bound")) {
                    waitAndClick(radio_ConstructionBound);
                }
                break;
        }
    }

    public void setPaymentPlanDetails(String field, String value) {
        switch (field.toUpperCase()) {
            case "PROJECT NAME":
                waitAndClick(drp_PaymentPlan_ProjectName);
                waitAndClick(By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "PLAN NAME":
                sendKeys(txt_PaymentPlanName, value, true);
                break;
            case "PLAN TYPE":
                waitAndClick(drp_PaymentPlanType);
                waitAndClick(By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "DISCOUNT ENABLED":
                if (value.equalsIgnoreCase("Yes")) waitAndClick(toggle_DiscountEnabled);
                break;
            case "RATE CALCULATION":
                waitAndClick(drp_RateCalculation);
                waitAndClick(By.xpath(String.format(DRP_OPTION, value)));
                break;
            case "DESCRIPTION":
                sendKeys(txt_PaymentPlanDescription, value, true);
                break;
        }
    }

    public void clickSave(String tabName) {
        if (tabName.equalsIgnoreCase("Construction Stage")) {
            waitAndClick(btn_Save_ConstructionStage);
        } else if (tabName.equalsIgnoreCase("Payment Plan")) {
            waitAndClick(btn_Save_PaymentPlan);
        }
    }

    public void clickCancel(String tabName) {
        if (tabName.equalsIgnoreCase("Construction Stage")) {
            waitAndClick(btn_Cancel_ConstructionStage);
        } else if (tabName.equalsIgnoreCase("Payment Plan")) {
            waitAndClick(btn_Cancel_PaymentPlan);
        }
    }

}