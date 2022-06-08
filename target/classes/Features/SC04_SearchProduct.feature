@regression
Feature: SC4- Logged User could search for any product

  Scenario: User search about product

    #PRERQUISITE
    Given User should to be logged in successfully

    # STEPS
    When User Write the name of product an Ex:"Camera"
    And User clicked to enter button in keyboard

    # EXPECTED RESULTS
    Then The wabsite should appear the results related to the product name


