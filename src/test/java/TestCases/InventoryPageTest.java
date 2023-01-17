package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;



public class InventoryPageTest extends TestBase{
	
    InventoryPage inv;
    LoginPage log;
	
    @BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{
		initalization();
		log=new LoginPage();
		log.verifyLoginPage();
		 inv= new InventoryPage();
	}
    
    @Test(groups="sanity")
    public void verifyURLTest()
    {
    	String actUrl = inv.verifyURL();
    	String expurl="https://www.saucedemo.com/inventory.html";
    	Assert.assertEquals(actUrl, expurl);
    }
   
    @Test(enabled=false)
    public void verifyTitleTest()
    {
    	String actUrl = inv.verifyTitle();
    	String expurl="Swag Labs";
    	Assert.assertEquals(actUrl, expurl);
    }
   
    @Test(enabled =false)
    public void verifyProductTextTest()
    {
    	String actUrl = inv.verifyProductText();
    	String expurl="PRODUCTS";
    	Assert.assertEquals(actUrl, expurl);
    }
    @Test(enabled =false)
    public void verifySwagLabLogoTest()
    {
    	boolean actLogo = inv.verifySwagLabLogo();
    	Assert.assertEquals(actLogo, true);
    }
   /* @Test 
    public void verifyPriceDropDownTest()
    {
    	   String actoption = inv.verifyPriceDropDown();
    	   Assert.assertEquals(actoption, "Price (high to low)");
    }*/
    
    @Test
    public void addProductTest() throws Exception
    {
    	String acttext = inv.addProduct();
    	String exptext = "4";
    	Assert.assertEquals(acttext, exptext);
    	Reporter.log("Total products added ="+ acttext);
    }
    
    @AfterMethod(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.close();
    	driver.quit();
    }
    
}
