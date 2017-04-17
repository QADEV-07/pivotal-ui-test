package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.framework.util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.framework.util.PropertiesInfo;

/**
 * This Class is login page the pivotal
 *
 * @Mijhaol Villarroel
 */

public class Login extends BasePage {

    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    @FindBy(css = "input[id=credentials_username]")
    private WebElement userNameTextField;

    @FindBy(id = "credentials_password")
    private WebElement passwordTestField;

    @FindBy(css = ".app_signin_action_button")
    private WebElement signInBtn;

    public void setUserNameTestField(String username) {
        CommonMethods.setWebElement(userNameTextField, username);
    }

    public void setPasswordTestField(String password) {
        CommonMethods.setWebElement(passwordTestField, password);
    }

    public static Dashboard loginAs(String userName, String password) {
        Dashboard dashboard = new Dashboard();
         String res1=dashboard.getUserNameText();
         //String res2=dashboard.getUserName(userName);
         System.out.println("rest"+res1);
         //System.out.println("res2"+res2);
        if (!(res1.equalsIgnoreCase(userName))) {
            PivotalHome pivotalHome = new PivotalHome();
            Login login = pivotalHome.clickSingInLink();
            login.setUserNameTestField(userName);
            login.clickSignInButton();
            login.setPasswordTestField(password);
            return login.clickSignInButton();
        }
        return dashboard;
    }

    public Dashboard clickSignInButton() {
        CommonMethods.clickWebElement(signInBtn);
        return new Dashboard();
    }

    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getEmail(),
                PROPERTIES_INFO.getPassword());
    }
}
