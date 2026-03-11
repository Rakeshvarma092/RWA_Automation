Feature: Login Functionality

  @Browser @Branch1
  Scenario: Login with valid credentials

    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "sunil.javvaji@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "SYSTEM ADMIN" page is visible

  @Browser @Branch2
  Scenario: Login with invalid email

    Given User navigates to Url
    Then Verify Login page is visible
    When User enters invalid email ID "invalid@example.com"
    And User clicks on Send OTP button
    Then Verify Login page is visible

  @Browser @Branch3
  Scenario: Login with invalid OTP

    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "sunil.javvaji@toucanus.com"
    And User clicks on Send OTP button
    And User enters invalid OTP "@23456"
    And User clicks on Verify and Login button
    Then Verify Login page is visible