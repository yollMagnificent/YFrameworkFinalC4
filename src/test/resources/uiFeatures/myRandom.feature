Feature: My random scenario

  @IND-001
  Scenario: Verify all checkbox successfully checked/unchecked
    Given I navigate to the url
    When I checked all checkboxes
    Then I verify that all checkboxes are checked
    And I unchecked all checkboxes
    And I verify checkboxes are unchecked
    Then I got count all checkboxes in the page


  @IND-002
  Scenario: Verify error message on the page
    Given I navigate to the correct url
    When I fill out date adults and childrens and infants
    And I press on more options
    Then I choose preferred class
    And I press search flights button
    And I verify error message "Select Departure and Arrival airports/cities."


  @IND-003
  Scenario: Verify correct message
    Given I navigate to the Ajax! webpage
    When I click on load link
    And I verify result message "Process completed! This response has been loaded via the Ajax request directly from the web server, without reoading this page."

