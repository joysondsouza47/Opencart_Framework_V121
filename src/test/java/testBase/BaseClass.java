package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://localhost/opencart/upload/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomstring() {
        String geneartedstring = RandomStringUtils.randomAlphabetic(5);
        return geneartedstring;
    }

    public String randomnumber() {
        String generatedstring = RandomStringUtils.randomNumeric(10);
        return generatedstring;
    }


    public String randomalpanum() {
        String generatedstring = RandomStringUtils.randomAlphanumeric(10);
        return generatedstring;
    }
}
