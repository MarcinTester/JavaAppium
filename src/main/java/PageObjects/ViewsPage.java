package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPage {

	public ViewsPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
	public WebElement DateWidgets;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Radio Group']")
	public WebElement RadioGroup;
	
	public void dateWidgetsClick()
	{
		DateWidgets.click();
	}
	
	public void radioGroupClick()
	{
		RadioGroup.click();
	}
}
