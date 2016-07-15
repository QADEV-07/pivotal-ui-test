Feature: Delete and Put a Workspace

  Background: I have workspace created
    Given I send a POST request to /my/workspaces
      | name   | workspace3444 |
    And stored as WorkspaceTest
    Given I login with credentials valid

#  project
  Scenario: Delete Workspace
    Given I click on workspace3444 created
#    When I click on Settings of SideBar
#    And I click on Delete link
#    When I click on Confirm Delete button
#    Then I expect the next message: workspace3444 was successfully deleted.
#
#
##  @project
#  Scenario: Edit story
#    Given I click on workspace3444 created
#    When I click on Settings of SideBar
#    When I edit the name with: workspace2221
#    And I click on Save button
#    Then I expect the next message: Changes saved.
#    Then the display name equals to workspace2221