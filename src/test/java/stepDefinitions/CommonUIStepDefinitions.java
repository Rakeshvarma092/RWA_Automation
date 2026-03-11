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
}