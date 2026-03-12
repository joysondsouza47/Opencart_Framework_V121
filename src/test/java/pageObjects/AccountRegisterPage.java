package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasicClass{

    public AccountRegisterPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement FirtsNamelnk;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement LastNamelnk;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement Emaillnk;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement Numerlnk;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement Passwordlnk;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement Confirmpasslnk;
    @FindBy(xpath="//input[@name='agree']")
    WebElement checkboxlnk;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement continuebuttonlnk;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgconfirmationlnk;

    public void FirstName(String name)
    {
        FirtsNamelnk.sendKeys(name);
    }
    public void LastName(String name)
    {
        LastNamelnk.sendKeys(name);
    }
    public void Email(String email)
    {
        Emaillnk.sendKeys(email);
    }
    public void number(String number)
    {
        Numerlnk.sendKeys(number);
    }
    public void password(String name)
    {
        Passwordlnk.sendKeys(name);
    }
    public void Confirmpass(String name)
    {
        Confirmpasslnk.sendKeys(name);
    }
    public void checkbox ()
    {
        checkboxlnk.click();
    }
    public void Continuebutton()
    {
       continuebuttonlnk.click();
    }

    public String msgconfirmation()
    {
        try
        {
            return msgconfirmationlnk.getText();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }



}
