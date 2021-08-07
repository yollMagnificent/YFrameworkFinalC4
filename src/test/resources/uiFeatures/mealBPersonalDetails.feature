Feature: Personal Details

  Background:
    Given I am on the MealB landing page
    Given I loggin with username as "alexpl23@mail.ru" and password as "Sasha240676!!"
    And I am on the "PersonalInfo" page

  @MB-003
  Scenario: Change password verification
    When I enter mismatching passwords
    Then I get error message "Password confirmation doesn't match Password"