@regression
Feature: SC1- Registration | guest user could register with valid data successfully

  Scenario: User will enter valid to inputs

      # PREREQUISITE
      Given User should have an email to register
      And User navigate to register page

      # STEPS
      When User enter valid data

      # EXPECTED RESULTS
      Then User could be register successfully




