@regression
Feature: SC-13 User could have to follow the pages of website

  # Scenario #1
  Scenario: User opens facebook link

    Given User go to home page

    When User opens facebook link

    Then "https://www.facebook.com/nopCommerce" facebook page is opened

  # Scenario #2
  Scenario: User opens twitter link

    Given User go to home page

    When User opens twitter link

    Then "https://twitter.com/nopCommerce" twitter page is opened

  # Scenario #3
  Scenario: User opens rss link

    Given User go to home page

    When User opens rss link

    Then "https://demo.nopcommerce.com/new-online-store-is-open" rss page is opened
  # Scenario #4
  Scenario: User opens youtube link

    Given User go to home page

    When User opens youtube link

    Then "https://www.youtube.com/user/nopCommerce" youtube page is opend