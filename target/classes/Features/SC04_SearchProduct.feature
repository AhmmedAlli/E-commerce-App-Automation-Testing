@regression
Feature: SC4- Logged User could search for any product


  # Scenario 1 Search by Name of Product
  Scenario: User search about product

    #PRERQUISITE
    Given User should to be logged in successfully

    # STEPS
    When User Write the name of product an Ex:"Camera"
    And User clicked to enter button in keyboard

    # EXPECTED RESULTS
    Then The website should appear the results related to the product name

      # Scenario 1 Search with StepCode
      Scenario: User search for products with step code
        # PRERQUISITE
        Given User should to be logged in successfully

        # STEPS
        When User Write the step code of product an Ex:"AP_MBP_13"
        And User clicked to enter button in keyboard

        # EXPECTED RESULTS
        Then The website should appear the results related to the product name
