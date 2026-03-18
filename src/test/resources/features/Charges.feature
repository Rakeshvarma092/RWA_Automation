Feature: Charges Management

  Background: User is logged in and on Charges page
    Given User navigates to Url
    Then Verify Login page is visible
    When User enters email ID "rakesh.pericherla@toucanus.com"
    And User clicks on Send OTP button
    And User enters OTP "333333"
    And User clicks on Verify and Login button
    Then Verify "COMMUNITY ADMIN" page is visible
    When User clicks on Charge Master option
    And User clicks on Charges option
    Then Verify Charges page is visible

  @Browser @Charges
  Scenario Outline: Create a new <ChargeType>
    When User clicks on "<TabName>" tab in Charges
    And User clicks on New button in Charges for "<ChargeType>"
    Then Verify "<ChargeType>" creation title is displayed in Charges
    When User sets "<ChargeType>" details
      | PROJECT NAME | CHARGE NAME | CHARGE TYPE | DESCRIPTION |
      | <Project>    | <Charge>    | <Type>      | <Desc>      |
    And User clicks on Save button in Charges for "<ChargeType>"
    # Then Verify charge is created successfully (Add verification if applicable)

    Examples:
      | ChargeType     | TabName         | Project | Charge      | Type     | Desc                 |
      | PLC CHARGE     | PLC Charge      | P001    | PLC_Auto    | in %     | Auto PLC Charge      |
      | OTHER CHARGES  | Other Charges   | P001    | Other_Auto  | Fixed    | Auto Other Charge    |
      | IFMS           | IFMS            | P001    | IFMS_Auto   | Per Area | Auto IFMS Charge     |

  @Browser @Charges @AddOn
  Scenario: Create a new Add On Charge
    When User clicks on "Add On Charges" tab in Charges
    And User clicks on New button in Charges for "ADD ON CHARGES"
    Then Verify "ADD ON CHARGES" creation title is displayed in Charges
    When User sets "ADD ON CHARGES" details
      | PROJECT NAME | CHARGE NAME | CHARGE TYPE CATEGORY | CALCULATE AT | CHARGE TYPE | MANDATORY | NEGOTIATIONS | INVENTORY LINKED BASE | DESCRIPTION      |
      | P001         | AddOn_Auto  | Club Membership      | On Booking   | Fixed       | Yes       | Yes          | No                    | Auto AddOn Charge|
    And User clicks on Save button in Charges for "ADD ON CHARGES"

  @Browser @Charges @Negative
  Scenario: Cancel PLC Charge creation
    When User clicks on "PLC Charge" tab in Charges
    And User clicks on New button in Charges for "PLC CHARGE"
    Then Verify "PLC CHARGE" creation title is displayed in Charges
    When User sets "PLC CHARGE" details
      | PROJECT NAME | CHARGE NAME | CHARGE TYPE | DESCRIPTION |
      | P001         | Cancel_PLC  | Fixed       | Cancel Test |
    And User clicks on Cancel button in Charges for "PLC CHARGE"
    Then Verify Charges page is visible
