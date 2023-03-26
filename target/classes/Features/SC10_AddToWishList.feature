@regression
Feature: SC10- Logged user could add different products to Wishlist

  Scenario: User could be able to add products to wishlist

    Given User logged in successfully
    And  User go to home page to shop any product

    When User select different products to wishlist

    Then User show green message for successful add products to wishlist
    And User open wishlist page and find the items has been selected

