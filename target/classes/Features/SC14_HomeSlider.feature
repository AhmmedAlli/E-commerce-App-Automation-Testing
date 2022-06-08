@regression
Feature: SC14- User Can to click to home slider and go to related page

  # Scenario 1 User Enter To Home Slider Number 1
  Scenario: First slider is clickable on home page

    Given User go to home page

    When User click to first slider

    Then Relative product for first slider is displayed


    # Scenario 2 User Enter To Home Slider Number 2
    Scenario: Second slider is clickable on home page

      Given User go to home page

      When User click to second slider

      Then Relative product for second slider is displayed