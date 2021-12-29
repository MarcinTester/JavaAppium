package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InlinePage {
	
	public AndroidDriver<AndroidElement> driver;
	
	public InlinePage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc='9']")
	public WebElement Number;
	
	public void numberClick(String number)
	{
		driver.findElementByXPath("//*[@content-desc='" + number +"']").click();
	}
	
	public AndroidElement number(String number)
	{
		return driver.findElementByXPath("//*[@content-desc='" + number +"']");
	}
	
	
}
