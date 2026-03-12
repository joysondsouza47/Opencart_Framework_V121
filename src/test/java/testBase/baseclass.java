package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class baseclass {

    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void openapp(String br)
    {
        logger = LogManager.getLogger(this.getClass());
        switch (br.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            case "firefox" : driver = new FirefoxDriver(); break;
            default :
                System.out.println("invalid browser"); return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("*******Test execution started*******");
        driver.get("http://localhost/opencart/upload/");
        logger.info("URL opened");
        driver.manage().window().maximize();
    }


    @AfterClass
    public void close()
    {
        logger.info("*******Test execution completed*******");
        driver.quit();
    }


    public String Randomalpha()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String Randomalphanum()
    {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public String Randomanum()
    {
        return RandomStringUtils.randomNumeric(10);
    }
}
