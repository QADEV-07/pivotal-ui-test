package org.fundacionjala.pivotal.pages.project;

import org.apache.bcel.generic.NEW;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.Login;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.util.resources.cldr.ga.LocaleNames_ga;

import static org.fundacionjala.pivotal.api.ProjectManager.createProject;
import static org.fundacionjala.pivotal.api.ProjectManager.deleteProject;
import static org.testng.Assert.assertEquals;

/**
 * Created by xianqe on 5/3/2017.
 */
public class UpdateProjectTests {

    private static final String PROJECT = "My Project";
    private static final String NEW_PROJECT_NAME = "My updated project";
    private static final String NEW_DESCRIPTION = "updated description";
    private static final String NEW_INITIAL_VELOCITY = "12";
    private static final String NEW_DONE_ITERATIONS_TO_SHOW = "6";
    private Dashboard dashboard;
    private int projectId;
    private Project project;
    private ProjectSettings projectSettings;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        projectId = createProject(PROJECT);
        dashboard = Login.loginAsPrimaryUser();
        project = dashboard.clickOnProject(PROJECT);
        projectSettings = project.clickSettingTab();
    }

    /**
     * Verify that the project name can be updated.
     */
    @Test
    public void testUpdateProjectName() {
        //When
        projectSettings.setProjectTitleTestField(NEW_PROJECT_NAME);
        projectSettings.clickSaveButton();

        //Then
        assertEquals(projectSettings.getProjectTitleTestField(), NEW_PROJECT_NAME);
    }

    /**
     * Verify that the description can be updated.
     */
    @Test
    public void testUpdateProjectDescription() {
        //When
        projectSettings.setProjectDescriptionTestField(NEW_DESCRIPTION);
        projectSettings.clickSaveButton();

        //Then
        assertEquals(projectSettings.getDescriptionText(), NEW_DESCRIPTION);
    }

    /**
     * Verify we can update "Initial velocity".
     */
    @Test
    public void testUpdateInitialVelocity() {
        //When
        projectSettings.setProjectInitialVelocityTestField(NEW_INITIAL_VELOCITY);
        projectSettings.clickSaveButton();

        //Then
        assertEquals(projectSettings.getInitialVelocity(), NEW_INITIAL_VELOCITY);
    }

    /**
     * Verify we can update "Number of Done Interations to Show".
     */
    @Test
    public void testUpdateNumberOfDoneIterationsToShow() {
        //When
        projectSettings.setProjectNumOfDoneIterationsToShowTestField(NEW_DONE_ITERATIONS_TO_SHOW);
        projectSettings.clickSaveButton();

        //Then
        assertEquals(projectSettings.getNumberIterationShow(), NEW_DONE_ITERATIONS_TO_SHOW);
    }

    /**
     * Cleanup method
     */
    @AfterMethod
    public void cleanUp() {
        deleteProject(projectId);
    }

    /**
     * After class method.
     */
    @AfterClass
    public void tearDown() {
        DriverManager.getInstance().quitDriver();
    }
}
