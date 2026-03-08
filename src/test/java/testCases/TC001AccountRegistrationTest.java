package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration()
    {
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        regpage.setFirstName(randomstring().toUpperCase());
        regpage.setLastName(randomstring().toUpperCase());
        regpage.setEmail(randomstring() +"@gmail.com");
        regpage.setTelephone(randomnumber());

        String password = randomalpanum();
        System.out.println(password);
        regpage.setPassword(password);
        regpage.setConfirmPassword(password);

        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        String confmsg = regpage.getConfirmationMsg();
        Assert.assertEquals(confmsg,"Your Account Has Been Created!");

    }

}
