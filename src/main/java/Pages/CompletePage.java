package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Base.TestBase;

public class CompletePage extends TestBase{
@FindBy (xpath="//span[text()='Checkout: Complete!']")private WebElement CheckoutCompleteText;
@FindBy (xpath="//img[@class='pony_express']")private WebElement ponyExpressLogo;
@FindBy (xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")private WebElement ThankYouText;
@FindBy (xpath="//div[@class='complete-text']")private WebElement CompleteText;
@FindBy (xpath="//button[text()='Back Home']")private WebElement BackHomeBtn;

public CompletePage()
{
	PageFactory.initElements(driver, this);
}
public String  verifyURL()
{
	return driver.getCurrentUrl();
}
public String verifyCheckoutCompleteText()
{
	return CheckoutCompleteText.getText();
}
public boolean verifyPonnyExpressLogo()
{
	return ponyExpressLogo.isDisplayed();
}
public void verifyThankYouText()
{
	 Reporter.log(ThankYouText.getText());
}
public void verifyCompleteText()
{
	Reporter.log(CompleteText.getText());
}
public String verifyBackToHomeBtn()
{
	BackHomeBtn.click();
	return driver.getCurrentUrl();
}
}
