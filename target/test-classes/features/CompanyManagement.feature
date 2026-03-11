Feature: Company Management

  Background: User is logged into the application
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "sunil.javvaji@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "SYSTEM ADMIN" page is visible

  @Browser @Branch5
  Scenario: Successfully onboard a new company

    When User clicks on Company Management
    Then Verify Company Onboard page is visible
    When User clicks on Add New button
    Then Verify Onboard Company page is visible
    When User set Company Details in onboard company page
      | Company Name | Company Type | Company Group |
      | Test         | Developer    | Group         |
    When User set Communication Details in onboard company page
      | Country Code | Mobile Number | Email ID   | Landline Number | Website            |
      | 91           |               | @gmail.com | 0401234567      | www.automation.com |
    And User enters Address Line 1 "Automation Street"
    And User enters Address Line 2 "Tech Park"
    And User click on Pincode
    And User clicks on Selected Pincode from lookup
    And User enters Google Map Link "https://goo.gl/maps/xyz"
    When User set Tax And Compliance Details in onboard company page
      | CI Number             | GST Number      | GSTIN Effective Date | PAN Number | ISO      | RERA    |
      | U12345TG2023PTC123456 | 36AAAAA0000A1Z5 |                      | ABCDE1234F | ISO 9001 | RERA123 |
    When User set Key Contact Details in onboard company page
      | Contact Person Name | Designation | Contact Email ID | Contact Country Code | Contact Mobile Number | Contact Identification Number |
      | Raj                 | Manager     | @gmail.com       | 91                   |                       | ABCDE1234F                    |
    And User clicks on Save button in Company Management

  @Browser @Branch6
  Scenario: Canceling company onboarding

    When User clicks on Company Management
    Then Verify Company Onboard page is visible
    When User clicks on Add New button
    Then Verify Onboard Company page is visible
    When User set Company Details in onboard company page
      | Company Name | Company Type | Company Group |
      | Test         | Developer    | Group         |
    And User clicks on Clear button in Company Management
    Then Verify Company Onboard page is visible
