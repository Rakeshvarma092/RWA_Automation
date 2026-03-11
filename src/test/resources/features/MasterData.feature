Feature: Master Data Management

  Background: User is logged in and on Master Data page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Configuration icon
    And User clicks on Master Data option
    Then Verify Master Data page is visible

  @Browser @Branch7
  Scenario: Create a new Project Type

    When User clicks on "Project Type" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Project Type" creation title is displayed
    When User sets Master Data details
      | PROJECT TYPE NAME  |
      | Automation Project |
    And User clicks on Save button in Master Data
    # Add verification step here if success message or record in table is expected

  @Browser @Branch8
  Scenario: Create a new Customer Profession

    When User clicks on "Customer Profession" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Customer Profession" creation title is displayed
    When User sets Master Data details
      | CUSTOMER PROFESSION NAME |
      | Software Engineer        |
    And User clicks on Save button in Master Data

  @Browser @Branch9
  Scenario: Create a new Customer Classification

    When User clicks on "Customer Classification" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Customer Classification" creation title is displayed
    When User sets Master Data details
      | CUSTOMER CLASSIFICATION NAME | DESCRIPTION                           |
      | High Priority                | Customers with high revenue potential |

    And User clicks on Save button in Master Data

  @Browser @Branch10
  Scenario: Create a new Customer Stage

    When User clicks on "Customer Stage" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Customer Stage" creation title is displayed
    When User sets Master Data details
      | CUSTOMER STAGE NAME | CUSTOMER STAGE DESCRIPTION                 |
      | Onboarding          | Initial onboarding stage for new customers |
    And User clicks on Save button in Master Data

  @Browser @Branch11
  Scenario: Create a new Document

    When User clicks on "Document" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Document" creation title is displayed
    When User sets Master Data details
      | DOCUMENT NAME | DOCUMENT SOURCE | STAGE             | IS REQUIRED | DOCUMENT DESCRIPTION                   |
      | Aadhaar Card  | Individual      | Booking Allotment | Yes         | Aadhaar card for identity verification |
    And User clicks on Save button in Master Data

  @Browser @Branch12
  Scenario: Cancel Project Type creation

    When User clicks on "Project Type" tab in Master Data
    And User clicks on New button in Master Data
    Then Verify "Project Type" creation title is displayed
    When User sets Master Data details
      | PROJECT TYPE NAME |
      | Cancelled Project |
    And User clicks on Cancel button in Master Data
    Then Verify Master Data page is visible