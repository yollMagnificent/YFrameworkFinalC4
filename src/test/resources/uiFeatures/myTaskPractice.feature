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

  @HR001
  Scenario: User should be able to verify message after hover over the image
    Given USer navigated to herokuapp webpage
    When user navigates to hovers tab
    And user hover over images
    Then user press on view profile button
    And user verify the message "Not Found"

  @HR002
  Scenario: User should be able to verify context menu using right click
    Given USer navigated to herokuapp webpage
    When user navigates to context menu tab
    And user right clicks on the target area
    Then user access alert and verify "You selected a context menu" of alert

