package com.fundacionjala.pivotal.cucumber.hooks;

import com.fundacionjala.pivotal.cucumber.stepdefinition.api.ApiResourcesSteps;
import cucumber.api.java.After;

import static com.fundacionjala.pivotal.api.Mapper.mapUrlToDeleteWorkspace;
import static com.fundacionjala.pivotal.api.RequestManager.deleteRequest;

/**
 * Created by Zeus on 15/07/2016.
 */
public class WorkspaceHooks {

    private static final int SUCCESS_STATUS_CODE = 200;

    private static final int DELETE_STATUS_CODE = 204;

    private ApiResourcesSteps api;

    public WorkspaceHooks(ApiResourcesSteps api) {
        this.api = api;
    }


    @After("@workspace")
    public void afterStoryScenario() {
        if (api.getResponse().statusCode() == SUCCESS_STATUS_CODE || api.getResponse().statusCode() == DELETE_STATUS_CODE) {
            deleteRequest(mapUrlToDeleteWorkspace(api.getEndPoint()));
        }
    }

}
