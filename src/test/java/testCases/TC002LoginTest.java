package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.baseclass;

public class TC002LoginTest extends baseclass {

    @Test
    public void logintest()
    {
        try
        {
            logger.info("*****starting test login *******");
            HomePage hp = new HomePage(driver);
            hp.MyAccount();
            hp.Loginlnk();
            logger.info("login page is received");

            loginPage lp = new loginPage(driver);
            lp.sendemail(p.getProperty("email"));
            lp.passwordlnk(p.getProperty("password"));
            lp.login();

            MyAccountPage macc = new MyAccountPage(driver);
            Assert.assertTrue(macc.isMyaccountpageexists());
            macc.logout();
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("*****completed test login *******");
    }
}
