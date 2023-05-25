Feature: Search

  Scenario: Search is displayed when click on search button
    Given User opened the App
    When User landed on search page
    Then Search is displayed

  Scenario Outline: Search for valid movie names
    Given User opened the App
    When User landed on search page
    And Search for movie <movie>
    Then <movie> Movie is present
    Examples:
      | movie |
      | The Godfather  |
      | Sweet November |

    # negative scenario
  Scenario Outline: Search for invalid movie names
    Given User opened the App
    When User landed on search page
    And Search for movie <movie>
    Then empty list is present
    Examples:
      | movie  |
      | Test1  |
      | Test2  |