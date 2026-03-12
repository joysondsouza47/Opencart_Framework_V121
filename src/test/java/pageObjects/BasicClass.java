package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicClass {
    public WebDriver driver;
    public BasicClass(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
