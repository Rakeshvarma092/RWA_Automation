Feature: Onboard Company

  Background:
    Given User navigates to Url
    Given User enters email or mobile in login page
      | Email                          |
      | yeshwanth.bupathi@toucanus.com |
    When User click on send otp button
    And Fetch and Enter the OTP in the Login page
      | OTP    |
      | 333333 |
    When User click on verify OTP button in the Login page
    Then Verify "System Admin" page is visible

  @Browser @Branch1
  Scenario: Create a Company
    When User click on company management on side panel
    Then Verify "Company Management" page is visible
    When User click on add company button in company setup page
    Then Verify "Onboard Company" page is visible
    And User set below company details in onboard company page
      | Company Name | Company Type            | Company Group |
      |              | Condominium Association | Group         |
    And User set below communication details in onboard company page
      | Country Code | Mobile Number | Email ID   |
      | 91           |               | @gmail.com |
    And User set below address details in onboard company page
      | Address Line 1 | Pincode |
      |                |         |
    And User set below tax and compliance details in onboard company page
      | GSTIN           | GSTIN Effective Date | PAN Number |
      | 27ASDFG1234F1Z2 |                      | HEOPP8541A |
    And User set below key Contact details in onboard company page
      | Name | Designation | Email      | Country Code | Phone Number |
      |      |             | @gmail.com | 91           |              |