@regression
Feature: SC2- User could log in with valid email and password

  Scenario: User log in with valid email and password

    #PRERQUISITE
    Given User navigate to login page


    # STEPS
    When User enter valid email
    And User enter valid password
    And User Click to login button

    # EXPECTED RESULTS
    Then User could be logged in successfully
