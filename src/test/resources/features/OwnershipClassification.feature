Feature: Ownership Classification Management

  Background: User is logged in and on Ownership Classification page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Configuration icon
    And User clicks on Project Setup icon
    And User clicks on Ownership Classification option
    Then Verify Ownership Classification page is visible

  @Browser @Branch16
  Scenario: Add a new Owner Type in Ownership Classification
    When User clicks on "Owner Type" tab in Ownership Classification
    And User clicks on New button in Ownership Classification
    Then Verify Add Owner Type title is displayed
    When User sets Owner Type details in Ownership Classification
      | PROJECT  | UNIT CLASSIFICATION | OWNER TYPE NAME |
      | Sky High | Regular             | Primary Owner   |
    And User clicks on Save button in Ownership Classification
    Then Verify Ownership Classification page is visible

  @Browser @Branch16
  Scenario: Cancel Owner Type creation in Ownership Classification
    When User clicks on "Owner Type" tab in Ownership Classification
    And User clicks on New button in Ownership Classification
    Then Verify Add Owner Type title is displayed
    When User sets Owner Type details in Ownership Classification
      | OWNER TYPE NAME   |
      | Cancelled Owner   |
    And User clicks on Cancel button in Ownership Classification
    Then Verify Ownership Classification page is visible
