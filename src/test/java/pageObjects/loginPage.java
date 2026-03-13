package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasicClass{
    WebDriver driver;

    public loginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-email']")
    WebElement emailaddlnk;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement passlnk;

    @FindBy(xpath="//input[@value='Login']")
    WebElement loginlnk;

    public void sendemail(String email)
    {
        emailaddlnk.sendKeys(email);
    }
    public void passwordlnk(String pass)
    {
        passlnk.sendKeys(pass);
    }
    public void login()
    {
        loginlnk.click();
    }
}
