package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutPage extends TestBase{
@FindBy(xpath="//span[text()='Checkout: Your Information']")private WebElement checkoutCartText;
@FindBy(xpath="//input[@id='first-name']")private WebElement UserName;
@FindBy(xpath="//input[@id='last-name']")private WebElement LastName;
@FindBy(xpath="//input[@id='postal-code']")private WebElement postalCode;
@FindBy(xpath="//input[@id='continue']")private WebElement continueBtn;
@FindBy(xpath="//button[@id='cancel']")private WebElement cancelBtn;

public CheckoutPage()
{
	PageFactory.initElements(driver, this);
}
public String verifyURL()
{
	String curURL = driver.getCurrentUrl();
	return curURL;
}
public String verifyInformation() throws Exception
{
	UserName.click();
	UserName.sendKeys("Ruchita");
	LastName.click();
	LastName.sendKeys("Sawant");
	postalCode.click();
	postalCode.sendKeys("94007");
	Thread.sleep(2000);
	continueBtn.click();
	return driver.getCurrentUrl();
}

}
