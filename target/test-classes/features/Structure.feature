Feature: Structure Management

  Background: User is logged in and on Structure page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Configuration icon
    And User clicks on Project Setup icon
    And User clicks on Structure option
    Then Verify Structure page is visible

  @Browser @Branch15
  Scenario: Add a new Tower in Structure
    When User clicks on "Tower" tab in Structure
    And User clicks on New button in Structure
    Then Verify "Tower" creation title is displayed in Structure
    When User sets Tower details in Structure
      | PROJECT NAME | TOWER NUMBER | TOWER NAME | BASE FLOORS | BASE FLOOR NAME | PATTERN TYPE | TOTAL FLOORS | TOTAL UNITS | CONSTRUCTION STATUS |
      | Sky High     | Tower 1      | Tower A    | 2           | Parking         | Linear       | 15           | 60          | Under Construction  |
    And User clicks on Save button in Structure
    Then Verify Structure page is visible

  @Browser @Branch15
  Scenario: Add a new Unit Type in Structure
    When User clicks on "Unit Type" tab in Structure
    And User clicks on New button in Structure
    Then Verify "Unit Type" creation title is displayed in Structure
    When User sets Unit Type details in Structure
      | BASE RATE | CONSTRUCTION COST | UDSL COST | EFFECTIVE RATE | SUPER AREA | CARPET AREA | BUILTUP AREA | UOM | PROJECT  | RATE TYPE | UNIT TYPE NAME |
      | 5000      | 3000              | 1000      | Super Area     | 1200       | 900         | 1050         | Sqf | Sky High | Saleable  | 2BHK - Deluxe  |
    And User clicks on Save button in Structure
    Then Verify Structure page is visible

  @Browser @Branch15
  Scenario: Add a new Unit Location in Structure
    When User clicks on "Unit Location" tab in Structure
    And User clicks on New button in Structure
    Then Verify "Unit Location" creation title is displayed in Structure
    When User sets Unit Location details in Structure
      | PROJECT  | FACING | DESCRIPTION          |
      | Sky High | North  | Premium North Facing |
    And User clicks on Save button in Structure
    Then Verify Structure page is visible

  @Browser @Branch15
  Scenario: Cancel Tower creation in Structure
    When User clicks on "Tower" tab in Structure
    And User clicks on New button in Structure
    Then Verify "Tower" creation title is displayed in Structure
    When User sets Tower details in Structure
      | TOWER NAME |
      | Tower B    |
    And User clicks on Cancel button in Structure
    Then Verify Structure page is visible
