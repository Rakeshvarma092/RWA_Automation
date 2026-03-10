Feature: Visitor

  Background:
    Given User navigates to Url

#  @Browser @Branch
#  Scenario: Create Visitor
#    When User enters email or mobile in login page
#      | Email or Mobile                |
#      | rakesh.pericherla@toucanus.com |
#    And Click on send otp button
#    And Fetch and Enter the OTP in the Login page
#      | OTP    |
#      | 333333 |
#    And Click on verify OTP button in the Login page
#    Then Verify "Property Admin" page is visible
#    And Click on Visitor Icon in the side panel
#    Then Verify "Visitor Management" page is visible
#    And Click on Add visitor button in the visitor Management
#    And Select visitor category in the Add new visitor page
#      | Visitor Category |
#      | Guest            |
#    And Select Type of Visit as "Once"
#    And Set below details in the Add new visitor page
#      | Date | Start Time | Valid upto | Visitor Name | Mobile Number |
#      |      | 09:30      | 17:30      | Rakesh Varma | 9642199488    |
#    And Select Host type as "Admin"
#    And Set below host details in the Add new visitor page
#      | Purpose |
#      | Test    |
#    And Click on Add visitor button in the Add new visitors page