Feature: Amazon page


@EL-001 @Smoke
Scenario: User should be able to add new item and check price at three points
  Given I visit Amazon homepage
  When search for the book "qa testing for beginners"
  Then press Search button and click on first item in the list results
  And verify the book price before add item to Cart
  Then click on Add to cart button
  And verify item price before click Proceed to checkout
  Then click on Proceed to checkout button
  And verify item price from checkout page