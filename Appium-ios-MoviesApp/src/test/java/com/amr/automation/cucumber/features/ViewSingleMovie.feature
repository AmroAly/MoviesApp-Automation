Feature: View Single Movie

  Scenario: User can view a movie
    Given User opened the App
    When User tab the first movie
    Then Movie is displayed in a new page
