package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;

public class CheckoutPageTest extends TestBase{

	InventoryPage inv;
    LoginPage log;
    cartPage cart1;
    CheckoutPage check;
    
    @BeforeMethod(alwaysRun=true)
    public void setup() throws Exception
    {
    	initalization();
    	log =new LoginPage();
    	log.verifyLoginPage();
    	inv = new InventoryPage();
    	inv.addProduct();
    	cart1= new cartPage();
    	cart1.verifycheckoutBtn();
    	check = new CheckoutPage();
    }
    
    @Test(groups="sanity")
    public void verifyURLTest()
    {
    	String actURL = check.verifyURL();
    	String expURL = "https://www.saucedemo.com/checkout-step-one.html";
    	Assert.assertEquals(actURL, expURL);
    }
    @Test
    public void verifyInformationTest() throws Exception
    {
    	String actURL = check.verifyInformation();
    	String expURL="https://www.saucedemo.com/checkout-step-two.html";
    	Assert.assertEquals(actURL, expURL);
    }
    @AfterMethod(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.close();
    	driver.quit();
    }
}
