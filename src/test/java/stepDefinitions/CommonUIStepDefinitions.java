package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import pageComponents.CorePage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static stepDefinitions.ApplicationHooks.test;

public class CommonUIStepDefinitions extends CorePage {
    public HashMap<String, String> testData = new HashMap();
    public HashMap<Object, Object> loginData = new HashMap();

    public HashMap<Object, Object> organizationData = new HashMap();
    public static HashMap<String, String> customerData = new HashMap<>();
    public static HashMap<String, String> officeData = new HashMap<>();
    public static HashMap<String, String> presentAddressData = new HashMap<>();
    public static HashMap<String, String> cardData = new HashMap<>();
    public static HashMap<String, String> applicationData = new HashMap<>();

    //    private ExtentTest ;
    public CommonUIStepDefinitions() throws IOException, InvalidFormatException {
    }
    //************************************************ LOGIN *********************************************************//

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

    @Given("User enters email or mobile in login page")
    public void loginToApplication(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++) {
            try {
                loginPage.enterUserEmailOrMobile(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
                test.pass("Successfully entered the email or mobile number in the login page : ");
            } catch (Exception e) {
                test.fail("Failed to enter the email or mobile number in the login page" + e.getClass().getSimpleName());
                Assert.fail("Failed to enter the email or mobile number in the login page" + e.getClass().getSimpleName());
            }
        }
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

    @When("User click on send otp button")
    public void clickOnSendOtpButton() {
        try {
            loginPage.clickSendOtpButton();
            test.pass("Successfully clicked on login button");
        } catch (Exception e) {
            test.fail("Failed to click on Login Button: " + e.getClass().getSimpleName());
            Assert.fail("Failed to click on Login button" + e.getClass().getSimpleName());
        }
    }

    @And("Fetch and Enter the OTP in the Login page")
    public void fetchAndEnterTheOTPInTheLoginPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++) {
            try {
                loginPage.enterOTP(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
                test.pass("Successfully entered the otp in the login page: ");
            } catch (Exception e) {
                test.fail("Failed to enter the otp in the login page" + e.getClass().getSimpleName());
                Assert.fail("Failed to enter the otp in the login page" + e.getClass().getSimpleName());
            }
        }
    }

    @When("User click on verify OTP button in the Login page")
    public void clickOnVerifyOTPButtonInTheLoginPage() {
        try {
            loginPage.clickOnVerifyOtpButton();
            test.pass("Successfully clicked on the verify otp button in the login page :: ");
        } catch (Exception e) {
            test.fail("Failed to click on the verify otp button in the login page ::" + e.getClass().getSimpleName());
            Assert.fail("Failed to click on the verify otp button in the login page :: " + e.getClass().getSimpleName());
        }
    }

    // ******************************************** VERIFY PAGES *****************************************************//
    @Then("Verify {string} page is visible")
    public void verifyPageIsVisible(String pageName) {
        try {
            switch (pageName.toUpperCase()) {
                case "SYSTEM ADMIN":
                    homePage.verifySystemHomePage();
                    break;
                case "COMPANY ADMIN":
                    homePage.verifyCommunityHomePage();
                    break;
                case "PROJECT ADMIN":
                    homePage.verifyPropertyHomePage();
                    break;
                case "COMPANY MANAGEMENT":
                    companyManagementPage.verifyPage();
                    break;
                case "ONBOARD COMPANY":
                    onboardCompanyPage.verifyPage();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Page Name Supplied: " + pageName);
            }
            test.pass(pageName + "-Page Name Verified successfully");
        } catch (Exception e) {
            test.fail("Failed to load page: " + pageName + " -" + e.getClass().getSimpleName());
            Assert.fail("Failed to load page: " + pageName + " -" + e.getClass().getSimpleName());
        }
    }

    //******************************************** ONBOARD COMPANY ***************************************************//
    @When("User click on company management on side panel")
    public void userClickOnCompanyManagementOnSidePanel() {
        companyManagementPage.navigateToCompanyManagement();
    }

    @When("User click on add company button in company setup page")
    public void userClickOnAddCompanyButtonInCompanySetupPage() {
        companyManagementPage.clickAddCompany();
    }

    @And("User set below company details in onboard company page")
    public void userSetBelowCompanyDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++){
            onboardCompanyPage.setCompanyDetails(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
        }
    }

    @And("User set below communication details in onboard company page")
    public void userSetBelowCommunicationDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++){
            onboardCompanyPage.setCommunicationDetails(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
        }
    }

    @And("User set below address details in onboard company page")
    public void userSetBelowAddressDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++){
            onboardCompanyPage.setAddressDetails(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
        }
    }

    @And("User set below tax and compliance details in onboard company page")
    public void userSetBelowTaxAndComplianceDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++){
            onboardCompanyPage.setTaxAndComplianceDetails(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
        }
    }

    @And("User set below key Contact details in onboard company page")
    public void userSetBelowKeyContactDetailsInOnboardCompanyPage(DataTable dataTable) {
        List<List<String>> fieldNames = dataTable.transpose().asLists(String.class);
        for (int i = 0; i < fieldNames.size(); i++){
            onboardCompanyPage.setKeyContactDetails(fieldNames.get(i).get(0), fieldNames.get(i).get(1));
        }
    }
}