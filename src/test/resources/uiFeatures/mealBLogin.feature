Feature: Login
  Background:
    Given I am on the MealB landing page

  @MB-001 @Smoke
  Scenario: User can login successfully
    When I click on the Sing In Button
    Then I enter username as "alexpl23@mail.ru"
    And I enter MealB password as "Sasha240676!!"
    Then I click on the Login button
    Then I am successfully logged in as "Alex & Co"

  @MB-002 @Smoke
  Scenario: User should not login with incorrect info
    When I loggin with username as "abc" and password as "bla bla"
    Then I should see error message as "Invalid username or password"


