package com.fundacionjala.pivotal.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;

/**
 *
 */
public class Dashboard extends BasePage {

    @FindBy(className = "tc_dropdown_name")
    private WebElement userNameText;

    @FindBy(id = "create_new_project_button")
    private WebElement createProjectLink;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(id = "notice")
    private WebElement deleteMessageText;

    @FindBy(id = "notice")
    private WebElement messageDeleteWorkspace;

    /**
     * @return
     */
    public CreateProject clickCreateProjectLink() {
        createProjectLink.click();
        return new CreateProject();
    }

    /**
     * @return CreateWorkspace()
     */
    public CreateWorkspace clickCreateWorkspaceLink() {
        createWorkspaceLink.click();
        return new CreateWorkspace();
    }

    /**
     * @return
     */
    public String getUserNameText() {
        String userName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, TimeUnit.SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        }
        return userName;
    }

    /**
     * @return
     */
    public String getMessageTextDelete() {
        return deleteMessageText.getText();
    }
    
    public Project clickOnProject(String projectName) {
        WebElement projectNameLink = driver.findElement(By.xpath("//a[contains(.,'"+projectName+"')]"));
        projectNameLink.click();
        return new Project();
    }

    public Setting clickSettingsLink(String nameProjects) {
        WebElement taskElement = driver.findElement(By.xpath("//*[@class='hover_link settings' and @href=\"/projects/"+nameProjects+"/settings\"]"));
        taskElement.click();
        return new Setting();
    }

    public Workspace clickNameWorkspaceLink(String nameWorkspace) {
        WebElement nameWorkspaceLink = driver.findElement(By.xpath("//a[contains(.,'"+nameWorkspace+"')]"));
        System.out.println (nameWorkspaceLink.getText ());
        nameWorkspaceLink.click();
        return new Workspace();
    }

    public String getMessageDeleteWorkspace() {

        return messageDeleteWorkspace.getText();
    }
}
