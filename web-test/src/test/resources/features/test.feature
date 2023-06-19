Feature: Test feature

  Scenario: Test scenario
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And start building a new page
    When switch to 'Blocks' tab
    And select create your own block
    When prepare the following items to be added to the page:
      | item | position | parent         | name             |
      | TEXT | -        | -              | GREETINGS_TEXT   |
      | TEXT | UP       | GREETINGS_TEXT | WELCOME_MESSAGE1 |
      | TEXT | BOTTOM   | GREETINGS_TEXT1 | WELCOME_MESSAGE  |
#    And prepare the following properties for the items to be added to the page:
#      | item_name | text | size |
    And add the items to the page
