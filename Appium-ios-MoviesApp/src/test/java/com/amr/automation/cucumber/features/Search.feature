Feature: Search

  Scenario:
    Given User opened the App
    When User landed on search page
    Then Search is displayed

  Scenario Outline:
    Given User opened the App
    When User landed on search page
    And Search for move <movie>
    Then <movie> Movie is present
    Examples:
      | movie |
      | The Godfather  |
      | Sweet November |

    # negative scenario
  Scenario Outline: Search for invalid movie names
    Given User opened the App
    When User landed on search page
    And Search for move <movie>
    Then empty list is present
    Examples:
      | movie  |
      | Test1  |
      | Test2  |
