Feature: Test feature

  Scenario: Test scenario
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And start building a new page
    When switch to 'Blocks' tab
    And select create your own block
    When add the following items to the container:
      | item | position | parent | name  |
      | TEXT | -        | -      | TEXT1 |
      | TEXT | BOTTOM   | TEXT1  | TEXT2 |
