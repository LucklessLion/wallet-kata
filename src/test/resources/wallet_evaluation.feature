Feature: Evaluate a wallet in a specific currency

  Scenario: Evaluate an empty wallet
    Given an empty wallet
    And a exchange rate "Dollar-Euro" at 2.0
    When I evaluate it in "Euro"
    Then I obtain 0.0

  Scenario: Evaluate a wallet with a unique stock
    Given an empty wallet
    And I add a stock of 3.0 "Dollar"
    And a exchange rate "Dollar-Euro" at 2.0
    When I evaluate it in "Euro"
    Then I obtain 6.0

  Scenario: Evaluate a wallet with two stocks
    Given an empty wallet
    And I add a stock of 10.0 "Dollar"
    And I add a stock of 1.0 "Bitcoin"
    And a exchange rate "Dollar-Euro" at 0.8
    And a exchange rate "Bitcoin-Euro" at 8459.50
    When I evaluate it in "Euro"
    Then I obtain 8467.50
