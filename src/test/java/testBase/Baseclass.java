package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Baseclass {
    public Logger logger;
    public WebDriver driver;

    @BeforeClass
    public void appopen()
    {
        logger= LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://localhost/opencart/upload/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void close()
    {
        driver.close();
    }


    public String randomapbhabet()
    {
        return RandomStringUtils.randomAlphanumeric(7);
    }

    public String randomnumber()
    {
        return RandomStringUtils.randomNumeric(10);
    }
    public String randomalphanum()
    {
        return RandomStringUtils.randomAlphanumeric(8);
    }

}
