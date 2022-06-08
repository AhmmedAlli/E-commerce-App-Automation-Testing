@regression
Feature: SC5- Logged User could switch between currencies US-Euro

  Scenario: Logged user switch currency to euro


    #PRERQUISITE
    Given User should to be logged in successfully

    # STEPS
    When User choose "Euro" as a main currency from static dropdown

    # EXPECTED RESULTS
    Then The currency in the website should to be changed
