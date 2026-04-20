package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import pagecomponents.HomePage;
import pagecomponents.LoginPage;
import utilities.ConfigReader;
import driverfactory.WebDriverFactory;

import java.io.IOException;

import static hooks.ApplicationHooks.test;

public class LoginSteps extends WebDriverFactory {
    private ConfigReader configReader = new ConfigReader();
    private LoginPage loginPage;
    private HomePage homePage;

    @Given("User navigates to Url")
    public void userNavigatesToUrl() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        try {
            navigateURL(configReader.getUrlDetails());
            test.pass("Browser launched Successfully");
        } catch (Exception e) {
            test.fail("Failed to launch the browser instance: " + e.getClass().getSimpleName());
            Assert.fail("Failed to Navigate URL" + e.getClass().getSimpleName());
        }
    }

    @Then("Verify login page is displayed")
    public void verifyLoginPageIsDisplayed() {
        loginPage.isLoginTitleDisplayed();
    }

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        loginPage.enterEmailID(email);
    }

    @And("User clicks on the Send OTP button")
    public void userClicksOnTheSendOTPButton() {
        loginPage.clickSendOTP();
    }

    @And("User enters OTP {string}")
    public void userEntersOTP(String otp) {
        loginPage.enterOTP(otp);
    }

    @And("User clicks on the Verify and Login button")
    public void userClicksOnTheVerifyAndLoginButton() {
        loginPage.clickVerifyAndLogin();
    }

    @Then("User should be redirected to the {string} dashboard page")
    public void userShouldBeRedirectedToTheDashboardPage(String role) {
        homePage.verifyRoleDisplayed(role);
    }

    @When("User login with {string} credentials")
    public void userLoginWithCredentials(String portal) {
        switch (portal.toUpperCase()) {
            case "SUPER ADMIN":
                loginPage.loginWithOTP(ConfigReader.getProperty("superAdmin_Name"), ConfigReader.getProperty("superAdmin_OTP"));
                break;
            case "COMPANY ADMIN":
                loginPage.loginWithOTP(ConfigReader.getProperty("company_Name"), ConfigReader.getProperty("company_OTP"));
                break;
            case "PROJECT ADMIN":
                loginPage.loginWithOTP(ConfigReader.getProperty("project_Name"), ConfigReader.getProperty("project_OTP"));
                break;
            default:
                throw new IllegalArgumentException("Unknown portal: '" + portal + "'. Valid values: 'Super Admin', 'Admin'");
        }
    }

    @When("User logs in with email {string} and OTP {string}")
    public void userLogsInWithEmailAndOTP(String email, String otp) {
        loginPage.loginWithOTP(email, otp);
    }
}
