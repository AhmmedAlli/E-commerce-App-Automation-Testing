@regression
Feature: SC12- Create successful Order

  Scenario: User make an order

    Given User logged in successfully

    When User add products to cart
    And User fill her data for make the order

    Then Order should created successfully


