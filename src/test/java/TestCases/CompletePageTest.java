package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.CompletePage;
import Pages.FinalPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;

public class CompletePageTest extends CompletePage{
	InventoryPage inv;
    LoginPage log;
    cartPage cart1;
    CheckoutPage check;
    FinalPage fin;
    CompletePage com;
    
    @BeforeMethod(alwaysRun=true)
    public void setup() throws Exception
    {
    initalization();
	log = new LoginPage();
	log.verifyLoginPage();
	inv = new InventoryPage();
	inv.addProduct();
	cart1= new cartPage();
	cart1.verifycheckoutBtn();
	check = new CheckoutPage();
    check.verifyInformation(); 
    fin= new FinalPage();
    fin.verifyFinishBtn();
    com = new CompletePage();
    }
    @Test(groups="sanity")
    public void verifyURLTest()
    {
    	String actURL = com.verifyURL();
    	String expURL = "https://www.saucedemo.com/checkout-complete.html";
    	Assert.assertEquals(actURL, expURL);
    }
    @Test(enabled=false)
    public void verifyCheckoutCompleteTextTest()
    {
    	String actText = com.verifyURL();
    	String expText = "CHECKOUT: COMPLETE!";
    	Assert.assertEquals(actText, expText);
    }
    @Test(enabled=false)
    public void verifyPonnyExpress()
    {
    	boolean logo = com.verifyPonnyExpressLogo();
    	Assert.assertEquals(logo, true);
    }
    @Test
    public void verifyThankYouTextTest()
    {
    	com.verifyThankYouText();
    }
    @Test
    public void verifyCompleteTextTest()
    {
    	com.verifyCompleteText();
    }
    @Test
   
    public void verifyBackToHomeBtnTest() 
    {
    	String actURL = com.verifyBackToHomeBtn();
    	String expURL = "https://www.saucedemo.com/inventory.html";
    	Assert.assertEquals(actURL, expURL);
    }
    	
    @AfterMethod(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.close();
    	driver.quit();
    }
}
