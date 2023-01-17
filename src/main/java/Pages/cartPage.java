package Pages;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class cartPage extends TestBase{
	    
	@FindBy(xpath="//button[text()='Open Menu']")private WebElement openMenu; 
	@FindBy(xpath="//span[@class='title']")private WebElement yourProduct; 
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement bikeLightRemoveBtn; 
	@FindBy(xpath="//button[text()='Checkout']")private WebElement checkoutBtn;
	@FindBy(xpath="//button[text()='Continue Shopping']")private WebElement continueBtn; 
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement cart; 
	
	public cartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURL()
	{
		String curURL = driver.getCurrentUrl();
		return curURL;
	}
	
	public String verifyYourCartText() throws Exception
	{    Thread.sleep(1000);
	
		 String text = yourProduct.getText();
		 return text;
	}
	
	public String verifyremoveProduct()
	{
		 bikeLightRemoveBtn.click();
		 String ProdNumber = cart.getText();
		 return ProdNumber; 
	}
	public String verifyContinueShopping()
	{
		continueBtn.click();
		String invetURL = driver.getCurrentUrl();
		return invetURL;
	}

	public String verifycheckoutBtn()
	{
	checkoutBtn.click();
	String curURL = driver.getCurrentUrl();
	return curURL;
	}
}
