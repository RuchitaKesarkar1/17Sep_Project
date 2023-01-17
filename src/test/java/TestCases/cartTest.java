package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;

public class cartTest extends TestBase {

	    InventoryPage inv;
	    LoginPage log;
	    cartPage cart1;
	    
		@BeforeMethod(alwaysRun=true)
		public void setup() throws Exception
		{
			initalization();
			log=new LoginPage();
			log.verifyLoginPage();
			inv= new InventoryPage();
			cart1 = new cartPage();
			inv.addProduct();
		}
		
		
		@Test(groups="sanity")
		public void verifyURLTest()
		{
			String actURL = cart1.verifyURL();
			String expURL="https://www.saucedemo.com/cart.html";
			Assert.assertEquals(actURL, expURL);
		}
		
		@Test
		public void verifyYourCartTextTest() throws Exception
		{
			String acttext = cart1.verifyYourCartText();
			String exptext = "YOUR CART";
			Assert.assertEquals(acttext, exptext);
		}
		
		
		@Test
		public void verifyRemoveProductTest()
		{
			String acttxt = cart1.verifyremoveProduct();
			String exptxt = "3";
			Assert.assertEquals(acttxt, exptxt);
		}
		
		@Test
		public void verifyContinueSoppinTest()
		{
		 String actURL = cart1.verifyContinueShopping();
		 String expURL = "https://www.saucedemo.com/inventory.html";
		 Assert.assertEquals(actURL, expURL);
		}
		public void verifycheckoutBtnTest()
		{
			String actURL = cart1.verifycheckoutBtn();
			String expURL="https://www.saucedemo.com/checkout-step-one.html";
			Assert.assertEquals(actURL, expURL);
		}
		@AfterMethod(alwaysRun=true)
		public void closeBrowser()
		{
			driver.close();
			driver.quit();
		}
}
