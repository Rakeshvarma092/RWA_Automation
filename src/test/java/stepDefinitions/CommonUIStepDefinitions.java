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
        homePage.verifySystemHomePage();
    }

    @When("User enters email ID {string}")
    public void userEntersEmailID(String email) {
        loginPage.enterEmailID(email);
    }

    @And("User enters OTP {string}")
    public void userEntersOTP(String otp) {
        loginPage.enterOTP(otp);
    }
}