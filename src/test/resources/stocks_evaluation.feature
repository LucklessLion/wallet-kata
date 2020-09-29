Feature: Evaluate a stock in a specific currency

  Scenario: Evaluate a single stock
    Given a stock of 3.0 "Dollar"
    And a exchange rate "Dollar-Euro" at 2.0
    When I evaluate it in "Euro"
    Then I get 6.0

  Scenario: Evaluate a stock in its own type
    Given a stock of 15 "Dollar"
    And a exchange rate "Dollar-Euro" at 2.0
    When I evaluate it in "Dollar"
    Then I get 15.0
