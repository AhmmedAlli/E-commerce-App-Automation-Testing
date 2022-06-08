@regression
Feature: SC9- Logged user could add different products to Shopping cart

  Scenario: User try to add product to shopping cart

    Given User should to be logged in successfully
    And User go to home page to shop any product

    When User add products to cart

    Then User should to find the products in shopping cart

