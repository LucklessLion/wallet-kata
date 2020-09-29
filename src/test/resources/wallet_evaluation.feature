Feature: Evaluate a wallet in a specific currency

  Scenario: Evaluate an empty wallet
    Given a wallet containing a stock of 3.0 "Dollar"
    And a exchange rate "Dollar-Euro" at 2.0
    When I evaluate it in "Euro"
    Then I obtain 6.0
