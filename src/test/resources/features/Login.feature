Feature: Login Functionality

  @Browser @Branch0
  Scenario: Login with valid credentials

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