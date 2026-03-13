package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicClass{

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//a[@title='My Account']")
    WebElement MyAccountlnk;
    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement Registrationlnk;
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement Loginpagelnk;


    public void MyAccount()
    {
        MyAccountlnk.click();
    }
    public void Registration()
    {
        Registrationlnk.click();
    }
    public void Loginlnk()
    {
        Loginpagelnk.click();
    }
}
