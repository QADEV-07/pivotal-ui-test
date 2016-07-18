package com.fundacionjala.pivotal.cucumber.hooks;

import com.fundacionjala.pivotal.api.RequestManager;
import com.fundacionjala.pivotal.cucumber.stepdefinition.workspace.WorkspaceStepDef;
import com.fundacionjala.pivotal.pages.Workspaces.Workspace;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;

/**
 * Created by DanielGonzales
 */
public class WorkspaceHooks {

    private static final String WORKSPACES_ENDPOINT = "/my/workspaces/";

    private WorkspaceStepDef workspaceStepDef;

    public WorkspaceHooks(WorkspaceStepDef workspaceStepDef) {
        this.workspaceStepDef = workspaceStepDef;
    }

    @After("@DeleteWorkspace")
    public void DeleteWorkspace() {
        Workspace workspace = workspaceStepDef.getWorkspace();
        String id = WORKSPACES_ENDPOINT + workspace.getIdWorkspace();
        Response response = RequestManager.deleteRequest(id);
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }

    @After("@ReturnDashboard")
    public void ReturnDashboard() {
        workspaceStepDef.getWorkspace ().clickReturnDashboardLink ();
    }
}
