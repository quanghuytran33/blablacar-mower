Feature: Process Mower's actions

  Scenario: Mower with position 1 2 N with commands LFLFLFLFF
    Given the lawn have horizontal 5 and vertical 5
    Given the mower start at 1 2 N
    Given list of commands is: LFLFLFLFF
    When process the actions
    Then the final position is: 1 3 N

  Scenario: Mower with position 3 3 E with actions FFRFFRFRRF
    Given the lawn have horizontal 5 and vertical 5
    Given the mower start at 3 3 E
    Given list of commands is: FFRFFRFRRF
    When process the actions
    Then the final position is: 5 1 E