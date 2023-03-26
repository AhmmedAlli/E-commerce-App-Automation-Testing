@regression
Feature: SC8- Logged user could select different tags

  Scenario: User try to select different tags


    Given User should to be logged in successfully
    And  User select any category

    When User select different tags

    Then User appear for him results of related items for this tag

