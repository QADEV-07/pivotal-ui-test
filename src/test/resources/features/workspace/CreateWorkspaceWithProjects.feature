Feature: Workspace with Projects

  Background: I have projects created
    Given I send a POST request to /projects
      | name   | project3444 |
      | public | true        |
#    And stored as ProjectW
    Given I login with credentials valid

  @DeleteWorkspace
  Scenario: Add project to Workspace created

    Given I am on Pivotal Create Workspace form
    When I fill with My Workspace8 the name Workspace field
    And click on the Create Workspace button of the Form
    When I click on Add Projects button
    And I  click on list projects icon
    When I select the project created previously
    And I click on Save Workspace button
    Then I expect a workspace with the selected project

