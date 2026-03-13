package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class baseclass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups={"Sanity","Master","Regression","DataDriven"})
    @Parameters("browser")
    public void openapp(String br) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

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
        driver.get(p.getProperty("appurl1"));
        logger.info("URL opened");
        driver.manage().window().maximize();
    }


    @AfterClass(groups={"Sanity","Master","Regression"})
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


    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }

}
