package testCases;

import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Baseclass;

public class TC001AccountRegistrationTest extends Baseclass {


    @Test
    public void myaccount()
    {
        logger.info("**** Starting TC001AccountRegistrationTest ****");
        try {
            HomePage hp = new HomePage(driver);
            hp.myaccount();
            logger.info("Clicked on My Account Link..");
            hp.register();
            logger.info("Clicked on My Register Link..");

            AccountRegistrationPage ar = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");

            ar.setFirstName(randomapbhabet());
            ar.setLastName(randomapbhabet());
            ar.setEmail(randomapbhabet() + "@gmail.com");
            ar.setTelephone(randomnumber());

            String password = randomalphanum();
            ar.setPassword(password);
            ar.setConfirmPassword(password);
            ar.setPrivacyPolicy();
            ar.clickContinue();
            logger.info("Validating expected message..");
            if(ar.getConfirmationMsg().equals("Your Accoun Has Been Created!"))
            {
                Assert.assertTrue(true);
            }
            else
            {
                logger.error("Test failed..");
                logger.debug("Debug logs..");
                Assert.assertTrue(false);
            }
        }
        catch(Exception e)
        {
            Assert.fail();
        }

        logger.info(" ****** finished***** ");
    }


}
