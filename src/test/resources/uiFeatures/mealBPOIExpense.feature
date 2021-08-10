@expense
Feature: User validation for MealB Expense feature

  Background:
    Given I am on the MealB landing page
    When I click on the Sing In Button
    Then I enter a valid MealB username
    And I enter a valid MealB password
    Then I click on the Login button



  @EX-01
  Scenario: Create Meal & Entertament Expence
    Given I am on Expense tab
    When I select Create Meal & Entertament expense
    Then I fill out all of the fields on the modal
    When I click on Save Button
    Then Modal window is closed
    And my newly added expense is displayed on table

  @EX-02
  Scenario: Put data into Excel file
    Given I am on Expense tab
    Then I can write to excel file

  @EX-03
  Scenario: User should be able to verify UI data with DB data
    Given I am on Expense tab
    Then User should be able to verify UI data with DB data