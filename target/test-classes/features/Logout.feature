Feature: Logout

  Background: User is logged into the application
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "sunil.javvaji@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "SYSTEM ADMIN" page is visible

  @Browser @Branch4
  Scenario: User successfully logs out from the application

    When User clicks on Profile icon
    Then Verify Profile menu is displayed
    And User clicks on Log Out button
    Then Verify Login page is visible
