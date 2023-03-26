@regression
Feature: SC3- User could reset his/her password successfully


  Scenario: User want to reset his/her password

    #PRERQUISITE
    Given User navigate to login page directly

    # STEPS
    When User enter the reset password button
    And User enter his email to send the key to reset the password
    And User clicked to reset button

    # EXPECTED RESULTS
    Then The website send to email hsa been register
