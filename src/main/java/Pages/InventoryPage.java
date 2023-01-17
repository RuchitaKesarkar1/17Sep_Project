package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethods;

public class InventoryPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Products']")private WebElement ProductText;
	@FindBy(xpath="//div[@class='app_logo']")private WebElement SwagLabsLogo;
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement PriceDropDown;
	@FindBy(id="add-to-cart-sauce-labs-backpack")private WebElement Backpack;
	@FindBy(id="add-to-cart-sauce-labs-bike-light")private WebElement BikeLight;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")private WebElement FleeceJacket;
	@FindBy(id="add-to-cart-sauce-labs-onesie")private WebElement LabsOnesie;
	@FindBy(xpath="//div[@id='shopping_cart_container']")private WebElement cart;
	public InventoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURL()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	public String verifyProductText()
	{
		String text1 = ProductText.getText();
		return text1;
	}
	public boolean verifySwagLabLogo()
	{
		boolean result = SwagLabsLogo.isDisplayed();
		return result;
	}
	public String addProduct() throws Exception
	{
		UtilityMethods.selectClass(PriceDropDown, 3);
		//Select s =new Select(PriceDropDown);
	    //s.selectByIndex(3);
	    //WebElement selOption = s.getFirstSelectedOption();
	    //String SelOptionString = selOption.getText();
		//return SelOptionString;
		Backpack.click();
		Thread.sleep(1000);
		BikeLight.click();
		Thread.sleep(1000);
		FleeceJacket.click();
		Thread.sleep(1000);
		LabsOnesie.click();
		Thread.sleep(1000);
		String TotalProduct = cart.getText();
		cart.click();
		return TotalProduct;
	}
	

}
