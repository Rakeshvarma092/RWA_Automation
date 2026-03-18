Feature: Stage and Payment Plan Management

  Background: User is logged in and on Stage page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Payment Setup option
    And User clicks on Stage option
    Then Verify Stage page is visible

  @Browser @Stage
  Scenario: Create a new Construction Stage
    When User clicks on "Construction Stage" tab in Stage
    And User clicks on New button in Stage for "Construction Stage"
    Then Verify "Construction Stage" creation title is displayed in Stage
    When User sets "Construction Stage" details in Stage
      | PROJECT NAME | STAGE NAME | RANK | DESCRIPTION | BOUND TYPE         |
      | P001         | Stage_Auto | 1    | Auto Stage  | Construction Bound |
    And User clicks on Save button in Stage for "Construction Stage"

  @Browser @Stage @PaymentPlan
  Scenario: Create a new Payment Plan
    When User clicks on "Payment Plan" tab in Stage
    And User clicks on New button in Stage for "Payment Plan"
    Then Verify "Payment Plan" creation title is displayed in Stage
    When User sets "Payment Plan" details in Stage
      | PROJECT NAME | PLAN NAME | PLAN TYPE | DISCOUNT ENABLED | RATE CALCULATION | DESCRIPTION      |
      | P001         | PP_Auto   | Flexi     | Yes              | Simple           | Auto Payment Plan|
    And User clicks on Save button in Stage for "Payment Plan"

  @Browser @Stage @Negative
  Scenario: Cancel Payment Plan creation
    When User clicks on "Payment Plan" tab in Stage
    And User clicks on New button in Stage for "Payment Plan"
    Then Verify "Payment Plan" creation title is displayed in Stage
    When User sets "Payment Plan" details in Stage
      | PROJECT NAME | PLAN NAME | PLAN TYPE | DISCOUNT ENABLED | RATE CALCULATION | DESCRIPTION      |
      | P001         | Cancel_PP | Flexi     | No               | Simple           | Cancel Test      |
    And User clicks on Cancel button in Stage for "Payment Plan"
    Then Verify Stage page is visible
