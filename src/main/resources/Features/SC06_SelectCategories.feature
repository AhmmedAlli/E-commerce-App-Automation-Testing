@regression
Feature: SC6- Logged user could select different Categories

  Scenario: Logged user select Category

    #PRERQUISITE
    Given User should to be logged in successfully

    # STEPS
    When User select any category

    # EXPECTED RESULTS
    Then The website should to appear the products that related to the category selected
