Feature: Automate eBay shopping flow

  Scenario: Add the lowest-priced Apple mobile phone to cart
    Given I open the eBay homepage
    When I hover over "Enter the phone textbox"
    And I click on "Search Button"
    And I click dropdown by "Low to High"
    And I click on the first Apple mobile phone listed
    And I add the product to the cart
    Then I take a screenshot after each step
