package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.baseclass;


public class TC001Accountregistration extends baseclass {


    @Test
    public void Accountregister()
    {

        HomePage hp = new HomePage(driver);
        hp.MyAccount();
        logger.info("Myaccount check verified");
        hp.Registration();
        logger.info("Registration page opened");


        AccountRegisterPage ap = new AccountRegisterPage(driver);
        ap.FirstName(Randomalpha());
        ap.LastName(Randomalpha());
        ap.Email(Randomalpha() + "@gmail.com");
        ap.number(Randomanum());

        String password = Randomalphanum();
        ap.password(password);
        ap.Confirmpass(password);
        ap.checkbox();
        ap.Continuebutton();
        Assert.assertEquals(ap.msgconfirmation(),"Your Account Has Been Created!");

    }


}
