package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//a[@title='My Account']")
    WebElement myaccountlnk;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement registerlnk;

    public void myaccount()
    {
        myaccountlnk.click();
    }

    public void register(){
        registerlnk.click();
    }

}