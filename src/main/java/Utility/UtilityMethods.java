package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class UtilityMethods extends TestBase {
	public static void selectClass(WebElement ele,int option)
	{
	Select s =new Select(ele);
    s.selectByIndex(option);
	}
	public static void Screenshotweb(String name) throws Exception
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Ruchita\\eclipse-workspace\\Project17Sep\\Screenshot\\"+name+".jpeg");
		FileHandler.copy(src, dest);
	}
}
