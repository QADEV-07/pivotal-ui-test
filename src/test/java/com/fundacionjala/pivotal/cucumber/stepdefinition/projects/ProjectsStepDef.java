package com.fundacionjala.pivotal.cucumber.stepdefinition.projects;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.java.en.Given;

import com.fundacionjala.pivotal.cucumber.stepdefinition.login.LoginStepDef;
import com.fundacionjala.pivotal.pages.dashboard.CreateProject;
import com.fundacionjala.pivotal.pages.project.Project;
import com.fundacionjala.pivotal.pages.project.ProjectSteps;
import cucumber.api.java.en.Given;

/**
 * Created by BrunoBarrios on 7/7/2016.
 */
public class ProjectsStepDef {

    private LoginStepDef loginStepDef;

    private CreateProject createProject;

    private Project project;

    private Map<ProjectSteps, Object> valuesMap;

    public ProjectsStepDef(LoginStepDef loginStepDef) {
        this.loginStepDef = loginStepDef;
    }

    @Given("^I create a new project$")
    public void iCreateANewProject(Map<ProjectSteps, Object> values) {
        this.valuesMap = values;
        createProject = loginStepDef.getDashboard().clickCreateProjectLink();
        valuesMap.keySet().stream().forEach((step) -> createProject.getStrategyStepMap(valuesMap).get(step).executeStep());
        project = createProject.clickCreateProject();
    }

    public Project getProject() {
        return project;
    }

}
