package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase{

	@FindBy(xpath="//div[@class='login_logo']")private WebElement LoginLogo;
	@FindBy(xpath="//div[@class='bot_column']")private WebElement LogBot;
	@FindBy(id="user-name")private WebElement UserName;
	@FindBy(id="password")private WebElement Password;
    @FindBy(xpath="//input[@id='login-button']")private WebElement LoginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	public Boolean verifyLoginLogo()
	{
		return LoginLogo.isDisplayed();
	}
	public Boolean verifyLogBot()
	{
		return LogBot.isDisplayed();
	}
	public String verifyLoginPage() throws Exception
	{
		UserName .click();
      //  UserName.sendKeys("standard_user");
		UserName.sendKeys(ReadData.readPropertyFile("username"));
		//UserName.sendKeys(ReadData.excelData(0, 0));
        Password.click();
        Password.sendKeys("secret_sauce");
	    LoginBtn.click();
	    return driver.getCurrentUrl();
	    
	}
	
}
