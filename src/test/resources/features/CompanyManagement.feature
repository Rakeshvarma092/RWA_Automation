Feature: Company Management functionality

  Background:
    Given User navigates to Url
    When User login with "Super Admin" credentials
    Then User should be redirected to the "System Admin" dashboard page
    When User navigates to Company Management page

  @Browser @Branch3
  Scenario: Successfully onboard a new company with all details


    Then User clicks on the Add New button
    Then Verify Onboard Company page is displayed
    And User enters the following details in "Company Details" section:
      | Field Name      | Value                       |
      | Company Name    | Random                      |
      | Company Type    | HOA(Home Owner Association) |
      | Company Details | QA Automation               |
    And User clicks on "Next" button in "Company Details" section
    And User enters the following details in "Communication Details" section:
      | Field Name      | Value            |
      | Country Code    | +91              |
      | Mobile Number   | Random           |
      | Email ID        | @test.com        |
      | Landline Number | Random           |
      | Website         | www.testauto.com |
    And User clicks on "Next" button in "Communication Details" section
    And User enters the following details in "Address Details" section:
      | Field Name      | Value                   |
      | Address Line 1  | Plot No 123             |
      | Address Line 2  | Hi-Tech City            |
      | Pincode         | 500038                  |
      | Google Map Link | https://maps.google.com |
    And User clicks on "Next" button in "Address Details" section
    And User enters the following details in "Tax & Compliance" section:
      | Field Name           | Value     |
      | CI Number            | Random    |
      | GST Number           | Random    |
      | GSTIN Effective Date | Current   |
      | PAN Number           | Random    |
      | ISO                  | 9001:2015 |
      | RERA                 | RERA12345 |
      | RERA Effective Date  | Current   |
    And User clicks on "Next" button in "Tax & Compliance" section
    And User enters the following details in "Social Media Links" section:
      | Field Name          | Value                     |
      | Social Media Link 1 | https://linkedin.com/test |
      | Social Media Link 2 | https://twitter.com/test  |
      | Social Media Link 3 | https://facebook.com/test |
    And User clicks on "Next" button in "Social Media Links" section
    And User enters the following details in "Key Contact Details" section:
      | Field Name            | Value               |
      | Contact Person Name   | Random              |
      | Designation           | QA Manager          |
      | Contact Email ID      | qa.manager@test.com |
      | Contact Country Code  | +91                 |
      | Contact Mobile Number | Random              |
      | Identification Type   | PAN                 |
      | Identification Number | Random              |
    And User clicks on the Save button
    Then Company should be onboarded successfully

  @Browser @Branch2
  Scenario: Cancel company onboarding process

    When User clicks on the Add New button
    And User enters the following details in "Company Details" section:
      | Field Name   | Value       |
      | Company Name | Cancel Test |
    And User clicks on the Cancel button
    Then Verify Company Management page is displayed
