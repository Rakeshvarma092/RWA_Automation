Feature: Project Onboarding Management

  Background: User is logged in and on Project Onboarding page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Configuration icon
    When User clicks on Project Onboarding option
    Then Verify Project Management page is visible

  @Browser @Branch14
  Scenario: Onboard a new Project with all details
    When User clicks on New button in Project Onboarding
    When User set Project Details in project onboarding page
      | PROJECT NAME | PROJECT TYPE | TOWERS | LAND AREA | DOCUMENT TYPE | GST NUMBER      | GSTIN EFFECTIVE DATE | RERA NUMBER  | RERA EFFECTIVE DATE |
      | Sky High     | Commercial   | 5      | 3000      | Square Yard   | 36AAAAA0000A1Z5 | Current Date         | RERA12345678 | Current Date        |
    When User set Communication Details in project onboarding page
      | COUNTRY CODE | MOBILE NUMBER | EMAIL ID             | WEBSITE         |
      | +91          | 9876543210    | skyhigh@projects.com | www.skyhigh.com |
    And User enters Address Line 1 "123 Business Park" in project onboarding
    And User enters Address Line 2 "Financial District" in project onboarding
    And User click on Pincode in project onboarding
    And User clicks on Selected Pincode from lookup in project onboarding
    And User enters Google Map Link "https://maps.google.com/skyhigh" in project onboarding
    When User set Key Contact Details in project onboarding page
      | NAME     | DESIGNATION | EMAIL                | COUNTRY CODE | MOBILE NUMBER | IDENTIFICATION NUMBER |
      | John Doe | Manager     | john.doe@skyhigh.com | +91          | 9988776655    | ID12345678            |
    And User clicks on Save button in Project Onboarding
    Then Verify Project Management page is visible

  @Browser @Branch14
  Scenario: Cancel Project Onboarding
    When User clicks on New button in Project Onboarding
    When User set Project Details in project onboarding page
      | PROJECT NAME   | PROJECT TYPE |
      | Cancel Project | Commercial   |
    And User clicks on Cancel button in Project Onboarding
    Then Verify Project Management page is visible
