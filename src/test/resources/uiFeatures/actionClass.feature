@automationPractice
Feature: User validations in actions

@APTC1
Scenario: As a user I can hover over womens section and get casual dresses page
    Given I navigate to AP page
    Then I hover over womens tab
    And I click on casual dresses link
    Then I am navigated to casual dresses page

@APTC2
Scenario: User should be able to right click on the element
  Given User navigated to contexMenu website
  When User clicks on the button
  Then User should be able to verify alert

@PR-01
Scenario: User should be able to verify build actions
  Given I navigate to AP page
  When User performs series of actions on search box
  Then User should be able to verify "search" results

@PR-02
Scenario: User should be able to verify tooltip
  Given User navigated to the tooltip URL
  When User hover over to the input text field
  Then User should be able to verify "tooltip"

@PR-03
Scenario: User should be able to upload a file
  Given USer navigated to herokuapp webpage
  When User uploads a file
  Then user should be able to verify uploaded file

@PR-04
Scenario: User should be able to download file
  Given USer navigated to herokuapp webpage
  Then User should be able to download the file






