package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CheckoutPage;
import Pages.FinalPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;

public class FinalPageTest extends TestBase{
	
	InventoryPage inv;
    LoginPage log;
    cartPage cart1;
    CheckoutPage check;
    FinalPage fin;
    
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
    check.verifyInformation(); 
    fin=new FinalPage();
    }
    @Test(groups="sanity")
    public void verifyURLTest()
    {
    	String actURL = fin.verifyURL();
    	String expURL="https://www.saucedemo.com/checkout-step-two.html";
    	Assert.assertEquals(actURL, expURL);
    }
    @Test(enabled=false)
    public void verifyTextTest()
    {
    	String actText = fin.verifyText();
    	String expText = "CHECKOUT: OVERVIEW";
    	Assert.assertEquals(actText, expText);
    }

    @Test(enabled=false)
    public void verifyPriceInfoTest()
    {
    	fin.verifyPriceInfo();
    }
    
    @Test
    public void verifyCancelBtnTest()
    {
    	String actURL = fin.verifyCancelBtn();
    	String expURL = "https://www.saucedemo.com/inventory.html";
    	Assert.assertEquals(actURL, expURL);
    }
    
    @Test
    public void verifyFinishBtnTest()
    {
    	String actURL = fin.verifyFinishBtn();
    	String expURL = "https://www.saucedemo.com/checkout-complete.html";
    	Assert.assertEquals(actURL, expURL);
    }
    @AfterMethod(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.close();
    	driver.quit();
    }
}
