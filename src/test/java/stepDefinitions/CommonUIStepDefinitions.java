package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import pageComponents.CorePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static stepDefinitions.ApplicationHooks.test;

public class CommonUIStepDefinitions extends CorePage {
    public HashMap<String, String> testData = new HashMap();
    public static HashMap<Object, Object> loginData = new HashMap();

    public HashMap<Object, Object> organizationData = new HashMap();
    public static HashMap<String, String> customerData = new HashMap<>();
    public static HashMap<String, String> officeData = new HashMap<>();
    public static HashMap<String, String> presentAddressData = new HashMap<>();
    public static HashMap<String, String> cardData = new HashMap<>();
    public static HashMap<String, String> applicationData = new HashMap<>();

    //    private ExtentTest ;
    public CommonUIStepDefinitions() throws IOException, InvalidFormatException {
    }

    //================================================ LOGIN =========================================================//

    @Given("User navigates to Url")
    public void userNavigatesToUrl() {
        try {
            navigateURL(configReader.getUrlDetails());
            test.pass("Browser launched Successfully");
        } catch (Exception e) {
            test.fail("Failed to launch the browser instance: " + e.getClass().getSimpleName());
            Assert.fail("Failed to Navigate URL" + e.getClass().getSimpleName());
        }
    }

    @Then("Verify Login page is visible")
    public void verifyLoginPageIsVisible() {
        loginPage.isLoginTitleDisplayed();
    }

    @When("User clicks on Send OTP button")
    public void userClicksOnSendOTPButton() {
        loginPage.clickSendOTP();
    }

    @When("User clicks on Verify and Login button")
    public void userClicksOnVerifyAndLoginButton() {
        loginPage.clickVerifyAndLogin();
    }

    @When("User enters invalid email ID {string}")
    public void userEntersInvalidEmailID(String email) {
        loginPage.enterEmailID(email);
    }

    @When("User enters invalid OTP {string}")
    public void userEntersInvalidOTP(String otp) {
        loginPage.enterOTP(otp);
    }


    @Then("Get data from test data sheet {string}")
    public void getDataFromTestDataSheet(String sheetName) {
        try {
            loginData = odsReader.getSheetData(sheetName);
            test.pass("Test Data Retrieved successfully from sheet: " + sheetName);
        } catch (Exception e) {
            test.fail("Failed to load test data from test data sheet: " + sheetName + e.getClass().getSimpleName());
            Assert.fail("Failed to load test data from test data sheet: " + sheetName + e.getClass().getSimpleName());
        }
    }

    @Then("Verify {string} page is visible")
    public void verifyPageIsVisible(String pageName) {
        try {
            switch (pageName.toUpperCase()) {
                case "SYSTEM ADMIN":
                    homePage.verifySystemHomePage();
                    break;
                case "COMMUNITY ADMIN":
                    homePage.verifyCommunityHomePage();
                    break;
                default:
                    Assert.fail("Invalid page name provided: " + pageName);
            }
        } catch (Exception e) {
            test.fail("Failed to verify " + pageName + " page visibility: " + e.getClass().getSimpleName());
            Assert.fail("Failed to verify " + pageName + " page visibility: " + e.getClass().getSimpleName());
        }
    }

    @When("User enters email ID {string}")
    public void userEntersEmailID(String email) {
        loginPage.enterEmailID(email);
    }

    @And("User enters OTP {string}")
    public void userEntersOTP(String otp) {
        loginPage.enterOTP(otp);
    }

    //================================================ LOGOUT ========================================================//
    @When("User clicks on Profile icon")
    public void userClicksOnProfileIcon() {
        logoutPage.clickProfile();
    }

    @Then("Verify Profile menu is displayed")
    public void verifyProfileMenuIsDisplayed() {
        Assert.assertTrue(logoutPage.isSystemAdminProfileDisplayed(), "Profile Menu/System Admin Profile is not displayed");
    }

    @And("User clicks on Log Out button")
    public void userClicksOnLogoutButton() {
        logoutPage.clickLogout();
    }

    // ============================================= COMPANY ONBOARD =================================================//
    @When("User clicks on Company Management")
    public void userClicksOnCompanyManagement() {
        companyManagementPage.clickCompanyManagementMenu();
    }

    @Then("Verify Company Onboard page is visible")
    public void verifyCompanyOnboardPageIsVisible() {
        Assert.assertTrue(companyManagementPage.isOnboardCompanyDisplayed(), "Company onboard page is not displayed");
    }

    @When("User clicks on Add New button")
    public void userClicksOnAddNewButton() {
        companyManagementPage.clickAddNew();
    }

    @Then("Verify Onboard Company page is visible")
    public void verifyOnboardCompanyPageIsVisible() {
        Assert.assertTrue(companyManagementPage.isOnboardCompanyPageDisplayed(), "Onboard Company Page is not displayed");
    }

    @When("User set Company Details in onboard company page")
    public void userSetCompanyDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                companyManagementPage.setCompanyDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User set Communication Details in onboard company page")
    public void userSetCommunicationDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                companyManagementPage.setCommunicationDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User enters Address Line 1 {string}")
    public void userEntersAddressLine1(String address) {
        companyManagementPage.enterAddressLine1(address);
    }

    @And("User enters Address Line 2 {string}")
    public void userEntersAddressLine2(String address) {
        companyManagementPage.enterAddressLine2(address);
    }

    @And("User click on Pincode")
    public void userClickOnPincode() {
        companyManagementPage.clickPincode();
    }

    @And("User clicks on Selected Pincode from lookup")
    public void userClicksOnSelectedPincodeFromLookup() {
        companyManagementPage.clickSelectedPincode();
    }

    @And("User enters Google Map Link {string}")
    public void userEntersGoogleMapLink(String link) {
        companyManagementPage.enterGoogleMapLink(link);
    }

    @When("User set Tax And Compliance Details in onboard company page")
    public void userSetTaxAndComplianceDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                companyManagementPage.setTaxAndComplianceDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User set Key Contact Details in onboard company page")
    public void userSetKeyContactDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                companyManagementPage.setKeyContactDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User clicks on Save button in Company Management")
    public void userClicksOnSaveButton() {
        companyManagementPage.clickSave();
    }

    @When("User clicks on Cancel button in Company Management")
    public void userClicksOnCancelButton() {
        companyManagementPage.clickCancel();
    }

    @And("User clicks on Clear button in Company Management")
    public void userClicksOnClearButtonInCompanyManagement() {
        companyManagementPage.clickCancel();
    }

    //=================================== MASTER DATA =========================================================//

    @When("User clicks on Configuration icon")
    public void userClicksOnConfigurationIcon() {
        masterDataPage.clickConfiguration();
    }

    @And("User clicks on Master Data option")
    public void userClicksOnMasterDataOption() {
        masterDataPage.clickMasterData();
    }

    @Then("Verify Master Data page is visible")
    public void verifyMasterDataPageIsVisible() {
        Assert.assertTrue(masterDataPage.isMasterDataTitleDisplayed(), "Master Data page title is not displayed");
    }

    @When("User clicks on {string} tab in Master Data")
    public void userClicksOnTabInMasterData(String tabName) {
        masterDataPage.clickTab(tabName);
    }

    @And("User clicks on New button in Master Data")
    public void userClicksOnNewButtonInMasterData() {
        masterDataPage.clickNew();
    }

    @Then("Verify {string} creation title is displayed")
    public void verifyCreationTitleIsDisplayed(String type) {
        boolean isDisplayed = false;
        switch (type.toUpperCase()) {
            case "PROJECT TYPE":
                isDisplayed = masterDataPage.isNewProjectTypeTitleDisplayed();
                break;
            case "CUSTOMER PROFESSION":
                isDisplayed = masterDataPage.isNewCustomerProfessionTitleDisplayed();
                break;
            case "CUSTOMER CLASSIFICATION":
                isDisplayed = masterDataPage.isNewCustomerClassificationTitleDisplayed();
                break;
            case "CUSTOMER STAGE":
                isDisplayed = masterDataPage.isNewCustomerStageTitleDisplayed();
                break;
            case "DOCUMENT":
                isDisplayed = masterDataPage.isNewDocumentTitleDisplayed();
                break;
        }
        Assert.assertTrue(isDisplayed, type + " creation title is not displayed");
    }

    @When("User sets Master Data details")
    public void userSetsMasterDataDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                masterDataPage.setMasterDataDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User clicks on Save button in Master Data")
    public void userClicksOnSaveButtonInMasterData() {
        masterDataPage.clickSave();
    }

    @And("User clicks on Cancel button in Master Data")
    public void userClicksOnCancelButtonInMasterData() {
        masterDataPage.clickCancel();
    }

    //=================================== BANK CONFIGURATION ===================================================//

    @And("User clicks on Bank Configuration option")
    public void userClicksOnBankConfigurationOption() {
        bankConfigurationPage.clickBankConfiguration();
    }

    @Then("Verify Bank Configuration page is visible")
    public void verifyBankConfigurationPageIsVisible() {
        Assert.assertTrue(bankConfigurationPage.isBankConfigurationTitleDisplayed(), "Bank Configuration page title is not displayed");
    }

    @When("User clicks on {string} tab in Bank Configuration")
    public void userClicksOnTabInBankConfiguration(String tabName) {
        bankConfigurationPage.clickTab(tabName);
    }

    @And("User clicks on New button in Bank Configuration")
    public void userClicksOnNewButtonInBankConfiguration() {
        bankConfigurationPage.clickNew();
    }

    @Then("Verify {string} bank creation title is displayed")
    public void verifyBankCreationTitleIsDisplayed(String type) {
        boolean isDisplayed = false;
        switch (type.toUpperCase()) {
            case "COMPANY":
                isDisplayed = bankConfigurationPage.isAddCompanyBankTitleDisplayed();
                break;
            case "CUSTOMER":
                isDisplayed = bankConfigurationPage.isAddCustomerBankTitleDisplayed();
                break;
        }
        Assert.assertTrue(isDisplayed, type + " bank creation title is not displayed");
    }

    @When("User sets Company Bank details")
    public void userSetsCompanyBankDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                bankConfigurationPage.setCompanyBankDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User sets Customer Bank details")
    public void userSetsCustomerBankDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                bankConfigurationPage.setCustomerBankDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User clicks on Save button in Bank Configuration")
    public void userClicksOnSaveButtonInBankConfiguration() {
        bankConfigurationPage.clickSave();
    }

    @And("User clicks on Cancel button in Bank Configuration")
    public void userClicksOnCancelButtonInBankConfiguration() {
        bankConfigurationPage.clickCancel();
    }

    //=================================== PROJECT ONBOARDING ===================================================//

    @When("User clicks on Project Onboarding option")
    public void userClicksOnProjectOnboardingOption() {
        projectOnboardingPage.clickProjectOnboarding();
    }

    @Then("Verify Project Management page is visible")
    public void verifyProjectManagementPageIsVisible() {
        Assert.assertTrue(projectOnboardingPage.isProjectManagementTitleDisplayed(), "Project Management page title is not displayed");
    }

    @When("User clicks on New button in Project Onboarding")
    public void userClicksOnNewButtonInProjectOnboarding() {
        projectOnboardingPage.clickAddNew();
    }

    @When("User set Project Details in project onboarding page")
    public void userSetProjectDetailsInProjectOnboardingPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                projectOnboardingPage.setProjectDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User set Communication Details in project onboarding page")
    public void userSetCommunicationDetailsInProjectOnboardingPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                projectOnboardingPage.setCommunicationDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User enters Address Line 1 {string} in project onboarding")
    public void userEntersAddressLine1InProjectOnboarding(String address) {
        projectOnboardingPage.enterAddressLine1(address);
    }

    @And("User enters Address Line 2 {string} in project onboarding")
    public void userEntersAddressLine2InProjectOnboarding(String address) {
        projectOnboardingPage.enterAddressLine2(address);
    }

    @And("User click on Pincode in project onboarding")
    public void userClickOnPincodeInProjectOnboarding() {
        projectOnboardingPage.clickPincode();
    }

    @And("User clicks on Selected Pincode from lookup in project onboarding")
    public void userClicksOnSelectedPincodeFromLookupInProjectOnboarding() {
        projectOnboardingPage.clickSelectedPincode();
    }

    @And("User enters Google Map Link {string} in project onboarding")
    public void userEntersGoogleMapLinkInProjectOnboarding(String link) {
        projectOnboardingPage.enterGoogleMapLink(link);
    }

    @When("User set Key Contact Details in project onboarding page")
    public void userSetKeyContactDetailsInProjectOnboardingPage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                projectOnboardingPage.setKeyContactDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User clicks on Save button in Project Onboarding")
    public void userClicksOnSaveButtonInProjectOnboarding() {
        projectOnboardingPage.clickSave();
    }

    @When("User clicks on Cancel button in Project Onboarding")
    public void userClicksOnCancelButtonInProjectOnboarding() {
        projectOnboardingPage.clickCancel();
    }

    //====================================== STRUCTURE =========================================================//

    @And("User clicks on Project Setup icon")
    public void userClicksOnProjectSetupIcon() {
        structurePage.clickProjectSetup();
    }

    @When("User clicks on Structure option")
    public void userClicksOnStructureOption() {
        structurePage.clickStructure();
    }

    @Then("Verify Structure page is visible")
    public void verifyStructurePageIsVisible() {
        Assert.assertTrue(structurePage.isStructureTitleDisplayed(), "Structure page title is not displayed");
    }

    @When("User clicks on {string} tab in Structure")
    public void userClicksOnTabInStructure(String tabName) {
        structurePage.clickTab(tabName);
    }

    @When("User clicks on New button in Structure")
    public void userClicksOnNewButtonInStructure() {
        structurePage.clickNew();
    }

    @Then("Verify {string} creation title is displayed in Structure")
    public void verifyCreationTitleIsDisplayedInStructure(String type) {
        boolean isDisplayed = false;
        switch (type.toUpperCase()) {
            case "TOWER":
                isDisplayed = structurePage.isAddTowerTitleDisplayed();
                break;
            case "UNIT TYPE":
                isDisplayed = structurePage.isAddUnitTypeTitleDisplayed();
                break;
            case "UNIT LOCATION":
                isDisplayed = structurePage.isAddUnitLocationTitleDisplayed();
                break;
        }
        Assert.assertTrue(isDisplayed, type + " creation title is not displayed in Structure");
    }

    @When("User sets Tower details in Structure")
    public void userSetsTowerDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                structurePage.setTowerDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User sets Unit Type details in Structure")
    public void userSetsUnitTypeDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                structurePage.setUnitTypeDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @When("User sets Unit Location details in Structure")
    public void userSetsUnitLocationDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                structurePage.setUnitLocationDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User clicks on Save button in Structure")
    public void userClicksOnSaveButtonInStructure() {
        structurePage.clickSave();
    }

    @And("User clicks on Cancel button in Structure")
    public void userClicksOnCancelButtonInStructure() {
        structurePage.clickCancel();
    }

    //=================================== OWNERSHIP CLASSIFICATION =============================================//

    @When("User clicks on Ownership Classification option")
    public void userClicksOnOwnershipClassificationOption() {
        ownershipClassificationPage.clickOwnershipClassification();
    }

    @Then("Verify Ownership Classification page is visible")
    public void verifyOwnershipClassificationPageIsVisible() {
        Assert.assertTrue(ownershipClassificationPage.isOwnershipClassificationHeaderDisplayed(), "Ownership Classification header is not displayed");
    }

    @When("User clicks on {string} tab in Ownership Classification")
    public void userClicksOnTabInOwnershipClassification(String tabName) {
        ownershipClassificationPage.clickTab(tabName);
    }

    @When("User clicks on New button in Ownership Classification")
    public void userClicksOnNewButtonInOwnershipClassification() {
        ownershipClassificationPage.clickNew();
    }

    @Then("Verify Add Owner Type title is displayed")
    public void verifyAddOwnerTypeTitleIsDisplayed() {
        Assert.assertTrue(ownershipClassificationPage.isAddOwnerTypeHeaderDisplayed(), "Add Owner Type header is not displayed");
    }

    @When("User sets Owner Type details in Ownership Classification")
    public void userSetsOwnerTypeDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                ownershipClassificationPage.setOwnerTypeDetails(entry.getKey(), entry.getValue());
            }
        }
    }

    @And("User clicks on Save button in Ownership Classification")
    public void userClicksOnSaveButtonInOwnershipClassification() {
        ownershipClassificationPage.clickSave();
    }

    @And("User clicks on Cancel button in Ownership Classification")
    public void userClicksOnCancelButtonInOwnershipClassification() {
        ownershipClassificationPage.clickCancel();
    }

    //=================================== STAGE ===================================================//

    @When("User clicks on Payment Setup option")
    public void userClicksOnPaymentSetup() {
        stagePage.clickPaymentSetup();
    }

    @And("User clicks on Stage option")
    public void userClicksOnStage() {
        stagePage.clickStage();
    }

    @Then("Verify Stage page is visible")
    public void verifyStagePageIsVisible() {
        Assert.assertTrue(stagePage.isPaymentPlanTitleDisplayed(), "Stage/Payment Plan page title is not displayed");
    }

    @When("User clicks on {string} tab in Stage")
    public void userClicksOnTabInStage(String tabName) {
        stagePage.clickTab(tabName);
    }

    @And("User clicks on New button in Stage for {string}")
    public void userClicksOnNewButtonInStage(String tabName) {
        stagePage.clickNew(tabName);
    }

    @Then("Verify {string} creation title is displayed in Stage")
    public void verifyCreationTitleIsDisplayedInStage(String tabName) {
        Assert.assertTrue(stagePage.isAddTitleDisplayed(tabName), tabName + " creation title is not displayed");
    }

    @When("User sets {string} details in Stage")
    public void userSetsStageDetails(String tabName, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                if (tabName.equalsIgnoreCase("Construction Stage")) {
                    stagePage.setConstructionStageDetails(entry.getKey(), entry.getValue());
                } else if (tabName.equalsIgnoreCase("Payment Plan")) {
                    stagePage.setPaymentPlanDetails(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    @And("User clicks on Save button in Stage for {string}")
    public void userClicksOnSaveButtonInStage(String tabName) {
        stagePage.clickSave(tabName);
    }

    @And("User clicks on Cancel button in Stage for {string}")
    public void userClicksOnCancelButtonInStage(String tabName) {
        stagePage.clickCancel(tabName);
    }

    //=================================== CHARGES ===================================================//

    @When("User clicks on Charge Master option")
    public void userClicksOnChargeMaster() {
        chargesPage.clickChargeMaster();
    }

    @And("User clicks on Charges option")
    public void userClicksOnCharges() {
        chargesPage.clickCharges();
    }

    @Then("Verify Charges page is visible")
    public void verifyChargesPageIsVisible() {
        Assert.assertTrue(chargesPage.isChargesTitleDisplayed(), "Charges page title is not displayed");
    }

    @When("User clicks on {string} tab in Charges")
    public void userClicksOnTabInCharges(String tabName) {
        chargesPage.clickTab(tabName);
    }

    @And("User clicks on New button in Charges for {string}")
    public void userClicksOnNewButtonInCharges(String chargeType) {
        chargesPage.clickNew(chargeType);
    }

    @Then("Verify {string} creation title is displayed in Charges")
    public void verifyCreationTitleIsDisplayedInCharges(String chargeType) {
        Assert.assertTrue(chargesPage.isAddChargeTitleDisplayed(chargeType), chargeType + " creation title is not displayed");
    }

    @When("User sets {string} details")
    public void userSetsChargeDetails(String chargeType, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            for (Map.Entry<String, String> entry : row.entrySet()) {
                switch (chargeType.toUpperCase()) {
                    case "PLC CHARGE":
                        chargesPage.setPLCChargeDetails(entry.getKey(), entry.getValue());
                        break;
                    case "OTHER CHARGES":
                        chargesPage.setOtherChargeDetails(entry.getKey(), entry.getValue());
                        break;
                    case "IFMS":
                        chargesPage.setIFMSDetails(entry.getKey(), entry.getValue());
                        break;
                    case "ADD ON CHARGES":
                        chargesPage.setAddOnChargeDetails(entry.getKey(), entry.getValue());
                        break;
                }
            }
        }
    }

    @And("User clicks on Save button in Charges for {string}")
    public void userClicksOnSaveButtonInCharges(String chargeType) {
        chargesPage.clickSave(chargeType);
    }

    @And("User clicks on Cancel button in Charges for {string}")
    public void userClicksOnCancelButtonInCharges(String chargeType) {
        chargesPage.clickCancel(chargeType);
    }
}