package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage Login;// =new LoginPage();
	
	

	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		Login = new LoginPage();
	}
	
	@Test
	public void  verifyTitleTest()
	{
		String expTitle="Swag Labs";
		String actTitle = Login.verifyTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test(enabled =false)
	public void verifyUrlTest()
	{
		String expUrl="https://www.saucedemo.com/";
		String actUrl = Login.verifyUrl();
		Assert.assertEquals(actUrl, expUrl);
	}
	
	@Test (enabled =false)
	public void verifyLoginLogoTest()
	{
		boolean Result = Login.verifyLoginLogo();
		Assert.assertEquals(Result, true);
	}
	
	@Test(enabled =false)
	public void verifyLoginBotTest()
	{
		boolean Result1=Login.verifyLogBot();
		Assert.assertEquals(Result1, true);
	}
	
	@Test
	public void verifyLoginPageTest() throws Exception
	{
		String newurl = Login.verifyLoginPage();
		String expurl = "https://www.saucedemo.com/inventory.html";
		Assert .assertEquals(newurl, expurl);
	}	
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
	   driver.close();
	   driver.quit();
	}
	
}
