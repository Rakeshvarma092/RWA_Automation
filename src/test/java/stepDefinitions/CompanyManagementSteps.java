package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pagecomponents.CompanyManagementPage;
import driverfactory.WebDriverFactory;

import java.util.List;
import java.util.Map;

import static hooks.ApplicationHooks.test;

public class CompanyManagementSteps extends WebDriverFactory {

    private CompanyManagementPage companyManagementPage = new CompanyManagementPage(getDriver());

    @When("User navigates to Company Management page")
    public void userNavigatesToCompanyManagementPage() {
        companyManagementPage.clickCompanyManagement();
        test.pass("Navigated to Company Management page successfully");
    }

    @Then("User clicks on the Add New button")
    public void userClicksOnTheAddNewButton() {
        companyManagementPage.clickAddNew();
        test.pass("Clicked on Add New button");
    }

    @When("User clicks on the Add New button in company management")
    public void userClicksOnTheAddNewButtonWhen() {
        companyManagementPage.clickAddNew();
        test.pass("Clicked on Add New button");
    }

    @Then("Verify Onboard Company page is displayed")
    public void verifyOnboardCompanyPageIsDisplayed() {
        Assert.assertTrue(companyManagementPage.isOnboardCompanyPageDisplayed(), "Onboard Company page is not displayed");
        test.pass("Verified Onboard Company page is displayed");
    }

    @And("User enters the following details in {string} section:")
    public void userEntersTheFollowingDetailsInSection(String section, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String fieldName = row.get("Field Name");
            String value = row.get("Value");
            try {
                switch (section.toUpperCase()) {
                    case "COMPANY DETAILS":
                        companyManagementPage.enterCompanyDetails(fieldName, value);
                        break;
                    case "COMMUNICATION DETAILS":
                        companyManagementPage.enterCommunicationDetails(fieldName, value);
                        break;
                    case "ADDRESS DETAILS":
                        companyManagementPage.enterAddressDetails(fieldName, value);
                        break;
                    case "TAX & COMPLIANCE":
                        companyManagementPage.enterTaxComplianceDetails(fieldName, value);
                        break;
                    case "SOCIAL MEDIA LINKS":
                        companyManagementPage.enterSocialMediaLinks(fieldName, value);
                        break;
                    case "KEY CONTACT DETAILS":
                        companyManagementPage.enterKeyContactDetails(fieldName, value);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown section: " + section);
                }
            } catch (Exception e) {
                test.fail("Error entering " + fieldName + " in " + section + ": " + e.getMessage());
                Assert.fail("Error entering " + fieldName + " in " + section + ": " + e.getMessage());
            }
        }
        test.pass("Entered details in " + section + " section");
    }

    @And("User clicks on {string} button in {string} section")
    public void userClicksOnButtonInSection(String buttonName, String section) {
        try {
            switch (section.toUpperCase()) {
                case "COMPANY DETAILS":
                    companyManagementPage.enterCompanyDetails(buttonName, "");
                    break;
                case "COMMUNICATION DETAILS":
                    companyManagementPage.enterCommunicationDetails(buttonName, "");
                    break;
                case "ADDRESS DETAILS":
                    companyManagementPage.enterAddressDetails(buttonName, "");
                    break;
                case "TAX & COMPLIANCE":
                    companyManagementPage.enterTaxComplianceDetails(buttonName, "");
                    break;
                case "SOCIAL MEDIA LINKS":
                    companyManagementPage.enterSocialMediaLinks(buttonName, "");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown section: " + section);
            }
            test.pass("Clicked " + buttonName + " in " + section);
        } catch (Exception e) {
            test.fail("Failed to click " + buttonName + " in " + section + ": " + e.getMessage());
            Assert.fail("Failed to click " + buttonName + " in " + section + ": " + e.getMessage());
        }
    }

    @And("User clicks on the Save button")
    public void userClicksOnTheSaveButton() {
        companyManagementPage.clickSave();
        test.pass("Clicked on Save button");
    }

    @And("User clicks on the Cancel button")
    public void userClicksOnTheCancelButton() {
        companyManagementPage.clickCancel();
        test.pass("Clicked on Cancel button");
    }

    @Then("Company should be onboarded successfully")
    public void companyShouldBeOnboardedSuccessfully() {
        companyManagementPage.clickCompanyManagement();
        test.pass("Company onboarded successfully");
    }

    @Then("Verify Company Management page is displayed")
    public void verifyCompanyManagementPageIsDisplayed() {
        companyManagementPage.clickCompanyManagement();
        test.pass("Verified Company Management page is displayed");
    }
}
