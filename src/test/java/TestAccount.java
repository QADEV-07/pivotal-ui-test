import org.fundacionjala.pivotal.framework.util.PropertiesInfo;
import org.fundacionjala.pivotal.pages.Login;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.accounts.CreateAccountForm;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.dashboard.ToolBar;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by JOAQUIN on 15/04/2017.
 */
public class TestAccount {

    Accounts accountpage;
    @BeforeClass
    public void login() {
        Login login = new Login();
        String email = PropertiesInfo.getInstance().getEmail();
        String password = PropertiesInfo.getInstance().getPassword();
        Dashboard dashboard = login.loginAs(email, password);
    }
    @Test
    public void createAccountTest()
    {
        accountpage = ToolBar.clickAccountlink() ;
        CreateAccountForm createaccount = accountpage.clickNewAccountBtn();
        createaccount.setAccountNameTextField("testaccount");
        createaccount.clickCreateAccountBtn();
        String actualResults = accountpage.getAccountName();

        Assert.assertEquals(actualResults,"testaccount");
    }
    @Test
    public void deleteAccountTest()
    {
        accountpage.deleteAccount();
    }
}

