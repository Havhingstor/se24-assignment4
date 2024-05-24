Feature: InsertInListAcceptanceTests
  This feature inserts an item in a sorted list

  Scenario: Inserting an item in an empty list
    Given an empty list
    When I insert 1
    Then the list should be the following
     | 1 |

  Scenario: Inserting an item in a list with one larger item
    Given I have elements with the following values in my list:
     | 2 |
    When I insert 1
    Then the list should be the following
     | 1 |
     | 2 |

  Scenario: Inserting an item in a list with one smaller item
    Given I have elements with the following values in my list:
     | 1 |
    When I insert 2
    Then the list should be the following
     | 1 |
     | 2 |
