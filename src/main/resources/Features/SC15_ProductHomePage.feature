@regression
Feature: SC15- User should to find products are displayed in home page

  Scenario: User scroll down into home page

    # shimaa eldanash
    Given User go to home page

    When User scroll down into home page

    Then User find the products in home page
