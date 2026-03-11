Feature: Bank Configuration Management

  Background: User is logged in and on Bank Configuration page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Configuration icon
    And User clicks on Bank Configuration option
    Then Verify Bank Configuration page is visible

  @Browser @Branch13
  Scenario: Add a new Company Bank

    When User clicks on "Company Bank" tab in Bank Configuration
    And User clicks on New button in Bank Configuration
    Then Verify "Company" bank creation title is displayed
    When User sets Company Bank details
      | BANK NAME | ACCOUNT NUMBER | BRANCH ADDRESS | IFSC CODE  | UPI ID          |
      | HDFC Bank | 1234567890     | Jubilee Hills  | HDFC0001234| hdfc@upi.com    |
    And User clicks on Save button in Bank Configuration
    Then Verify Bank Configuration page is visible

  @Browser @Branch13
  Scenario: Add a new Customer Bank

    When User clicks on "Customer Bank" tab in Bank Configuration
    And User clicks on New button in Bank Configuration
    Then Verify "Customer" bank creation title is displayed
    When User sets Customer Bank details
      | BANK NAME |
      | ICICI Bank|
    And User clicks on Save button in Bank Configuration
    Then Verify Bank Configuration page is visible

  @Browser @Branch13
  Scenario: Cancel Company Bank creation

    When User clicks on "Company Bank" tab in Bank Configuration
    And User clicks on New button in Bank Configuration
    Then Verify "Company" bank creation title is displayed
    When User sets Company Bank details
      | BANK NAME | ACCOUNT NUMBER | BRANCH ADDRESS | IFSC CODE  | UPI ID          |
      | SBI Bank  | 0987654321     | Gachibowli     | SBIN0004321| sbi@upi.com     |
    And User clicks on Cancel button in Bank Configuration
    Then Verify Bank Configuration page is visible

  @Browser @Branch13
  Scenario: Cancel Customer Bank creation

    When User clicks on "Customer Bank" tab in Bank Configuration
    And User clicks on New button in Bank Configuration
    Then Verify "Customer" bank creation title is displayed
    When User sets Customer Bank details
      | BANK NAME |
      | Axis Bank |
    And User clicks on Cancel button in Bank Configuration
    Then Verify Bank Configuration page is visible
