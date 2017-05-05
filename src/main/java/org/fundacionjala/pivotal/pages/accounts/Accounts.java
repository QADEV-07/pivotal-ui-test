package org.fundacionjala.pivotal.pages.accounts;

import org.apache.log4j.Logger;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.*;

/**
 * This class represents Accounts page and its characteristics.
 */
public class Accounts extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(Accounts.class.getName());

    private final ToolBarAccount toolBarAccount;

    @FindBy(css = "li[class='notice']")
    private WebElement deleteAccountMessage;

    @FindBy(xpath = "//a[contains(.,'Manage Account')]")
    private WebElement manageAccountBtn;

    @FindBy(id = "new_account_link")
    private WebElement createNewAccountLink;

    @FindBy(id = "account_name")
    private WebElement accountTextBox;

    @FindBy(id = "add_account_button")
    private WebElement createNewAccountBtn;

    //Joaquin gonzales
    @FindBy(css = "h2.account_name span")
    private WebElement accountname;

    @FindBy(xpath = "//*[contains(a,'Settings')]")
    WebElement settingsTab;

    @FindBy(css = "a[data-method='delete']")
    WebElement deleteLink;

    @FindBy(css = "input[id='account_name']")
    WebElement accountNameTextValue;

    @FindBy(css = "div.save_changes input")
    WebElement saveChangesButton;
    /**
     * Class constructor,
     * This class instances a ToolBarAccount.
     */
    public Accounts() {
        toolBarAccount = new ToolBarAccount();
    }

    /**
     * This method is used to get into an Account properties and settings.
     *
     * @return {@link ToolBarAccount}
     */
    public ToolBarAccount manageAccount() {
        clickWebElement(manageAccountBtn);
        return new ToolBarAccount();
    }

    /**
     * This method is used to catch the message that is displayed after deleting an
     * account.
     *
     * @return the message of deleting an account.
     */
    public String getDeleteAccountMessage() {
        LOGGER.info("Message delete account " + deleteAccountMessage.getText());
        return deleteAccountMessage.getText();
    }

    /**
     * This method clicks the new account button displayed on the page.
     *
     * @return {@link CreateAccountForm}
     */
    public CreateAccountForm clickNewAccountBtn() {
        clickWebElement(createNewAccountLink);
        return new CreateAccountForm();
    }

    /**
     * it returns the web element that represents
     * the manage accounts button.
     *
     * @return the web element from the instance
     */
    public WebElement getManageAccountBtn() {
        return manageAccountBtn;
    }

    /**
     * It gives us the tool bar account that is present on the instance.
     *
     * @return the tool bar account instance
     */
    public ToolBarAccount getToolBarAccount() {
        return toolBarAccount;
    }

    /**
     * The method returns the tool bar instance.
     *
     * @return the tool bar retrieved from the instance
     */
    public ToolBar getToolBar() {
        return new ToolBar();
    }

    ///Created by JQN

    public String getAccountName()
    {
        return getTextForElement(accountname);
    }
    public void deleteAccount()
    {
        clickWebElement(settingsTab);
        clickWebElement(deleteLink);
        checkAlert();
    }
    private void checkAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            LOGGER.warn("alert is not present",e);
            //exception handling
        }
    }
    public String accountNameCreated()
    {
        clickWebElement(settingsTab);
        return accountNameTextValue.getAttribute("value");
    }
    public void editAccount(String newAccountName)
    {
        clickWebElement(settingsTab);
        setWebElement(accountNameTextValue, newAccountName);
        clickWebElement(saveChangesButton);
    }
    public String accountNametitle()
    {
        System.out.println(getValue(accountname));
        return getValue(accountname);
    }

}
