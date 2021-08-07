Feature: Expense

  Background:
    Given I am on the MealB landing page
    Given I loggin with username as "alexpl23@mail.ru" and password as "Sasha240676!!"
    And I am on the "Expenses" page

  @MB-004
  Scenario: View column options in dropdown
    Then I see below options when clicked on column dropdown
    |option             |
    |Expense name      |
    |Amount             |
    |Type               |
    |Expense date       |
    |Business purpose   |
    |Project name       |
