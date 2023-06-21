Feature: Test feature

  Scenario: Test scenario
    When navigate to home page
    And open dashboard page
    When select 'Project #1' from projects list
    And start building a new page
    When switch to 'Blocks' tab
    And select create your own block
    When prepare the following items to be added to the page:
      | item   | position | parent         | name           |
      | TEXT   | -        | -              | GREETINGS_TEXT |
      | IMAGE  | BOTTOM   | GREETINGS_TEXT | WELCOME_IMAGE  |
      | BUTTON | BOTTOM   | WELCOME_IMAGE  | WELCOME_BUTTON |
      | ICON   | UP       | WELCOME_BUTTON | WELCOME_ICON   |
#    And prepare the following properties for the items to be added to the page:
#      | item_name      | text     | size |
#      | GREETINGS_TEXT | DemoText | size |
#    And add the items to the page
#    When publish the page
