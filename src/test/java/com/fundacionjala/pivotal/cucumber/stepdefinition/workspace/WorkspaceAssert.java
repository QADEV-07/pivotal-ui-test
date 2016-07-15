package com.fundacionjala.pivotal.cucumber.stepdefinition.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel
 */

public class WorkspaceAssert {

    private WorkspaceStepDef workspaceStepDef;

    public WorkspaceAssert (WorkspaceStepDef workspaceStepDef) {
        this.workspaceStepDef = workspaceStepDef;
    }

    @Then("^I expect a Create Workspace form$")
    public void iExpectACreateWorkspaceForm () {
        assertNotNull (workspaceStepDef.getCreateWorkspace ());
        workspaceStepDef.getCreateWorkspace ().clickCancelCreateWorkspaceLink ();
    }

    @And("^the display name equals to (.*)$")
    public void theDisplayNameEqualsTo (String workspaceName) {
        assertEquals (workspaceName, workspaceStepDef.getWorkspace ().getWorkspaceNameText ());
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }

    @Then("^I expect a workspace with the selected project$")
    public void iExpectAWorkspaceWithTheProjectSelected (String nameProject) {
        assertEquals (nameProject, workspaceStepDef.getWorkspace ().getWorkspaceNameText ());
    }

    @Then("^I expect the next message: (.*)$")
    public void iExpectTheNextMessageWorkspaceWasSuccessfullyDeleted(String message) {
        if(message.equalsIgnoreCase("Changes saved.")){
            assertEquals(message, workspaceStepDef.getSettingWorkspace().getMessageChangesWorkspace());
        }
        else {
            assertEquals(message, workspaceStepDef.getDashboard().getMessageDeleteWorkspace());
        }

        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();

    }
}
