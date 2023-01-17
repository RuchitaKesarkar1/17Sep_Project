package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Base.TestBase;

public class FinalPage extends TestBase{

	@FindBy(xpath="//span[text()='Checkout: Overview']")private WebElement checkoutOverviewText;
	@FindBy(xpath="//button[@id='finish']")private WebElement FinishBtn;
	@FindBy(xpath="//div[@class='summary_subtotal_label']")private WebElement ItemTotal;
	@FindBy(xpath="//div[@class='summary_tax_label']")private WebElement Tax;
	@FindBy(xpath="//div[@class='summary_total_label']")private WebElement TotalPrice;
	@FindBy(xpath="//button[@id='cancel']")private WebElement BtnCancel;
	public FinalPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyURL()
	{
		String curURL = driver.getCurrentUrl();
		return curURL;
	}
	public String verifyText()
	{
		return checkoutOverviewText.getText();
	}
	public void verifyPriceInfo()
	{
		Reporter.log(ItemTotal.getText()); 
		Reporter.log(Tax.getText()); 
		Reporter.log(TotalPrice.getText()); 
	}
	public String verifyCancelBtn()
	{
		BtnCancel.click();
		return driver.getCurrentUrl();
	}
	public String verifyFinishBtn()
	{
	     FinishBtn.click();
	     return driver.getCurrentUrl();
	}

}
