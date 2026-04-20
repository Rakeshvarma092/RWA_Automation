Feature: Login functionality

  Background:
    Given User navigates to Url
    Then Verify login page is displayed

  @Browser @Branch0
  Scenario: Successful login with valid credentials

    When User enters email "sunil.javvaji@toucanus.com"
    And User clicks on the Send OTP button
    And User enters OTP "859674"
    And User clicks on the Verify and Login button
    Then User should be redirected to the "System Admin" dashboard page


  @Browser @Branch1
  Scenario: Successful login using complete login flow

    When User logs in with email "sunil.javvaji@toucanus.com" and OTP "859674"
    Then User should be redirected to the "System Admin" dashboard page

  @Browser @Branch2
  Scenario: Login to application with different credentials

    When User login with "Super Admin" credentials
    Then User should be redirected to the "System Admin" dashboard page