Feature: Change Tabs

  Scenario: Default Homepage is Now Playing
    Given User opened the App
    Then "Now Playing" page is displayed


  Scenario Outline: User can change change pages by clicking on Tabs
    Given User opened the App
    When User clicks on <tab>
    Then <tab> page is displayed
    Examples:
      | tab         |
      | Now Playing |
      | Popular     |
      | Upcoming    |
      | Top Rated   |
