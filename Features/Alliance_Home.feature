Feature: Alliance Home Page Scenarios

Background: User login to application with valid and valid credentials
  Given I am on Alliance Home Page
  When I click on Sign In button
  And User is in the sign in page
  And user is in login page enter the correct username and correct password
  Then Home is displayed with expectedUserName

Scenario: Verifying MyPlaceSetUp module
    Given user is in homepage
    When click on the globe icon
    And click on Sandbox Private
    And mousehover to SellNetwork
    And Click on MyPlaceSetup
    Then MyPlaceSetUp page should display
  
Scenario: Verifying Select Organization
    Given user is in MyplaceSetup module
    When click on the organization close icon
    And enter the orgname and select the org
    Then MyPlaceforpats page should display as blank
    
 Scenario: Verifying Copy SellNetwork from
    Given user is in MyplaceSetup module to add sellnetwork
    When user select Copy Sellnetwork From checkbox 
    And Select store from dropdown
    And Select location from dropdown
    And select Primary Details checkbox
    And Click on Go button
    And Click on OK button for confirm message
    Then It should display the sellnetwork which are available in the selected location
    
    
    
