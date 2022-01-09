package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RadioGroupPage {

	public RadioGroupPage(AndroidDriver<AndroidElement> driver)	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="io.appium.android.apis:id/dinner")
	public WebElement DinnerButton;
	
	@AndroidFindBy(id="io.appium.android.apis:id/lunch")
	public WebElement LunchButton;
	
	@AndroidFindBy(id="io.appium.android.apis:id/snack")
	public WebElement SnackButton;
	
	@AndroidFindBy(id="io.appium.android.apis:id/breakfast")
	public WebElement BreakfastButton;

	@AndroidFindBy(id="io.appium.android.apis:id/all")
	public WebElement AllButton;
	
	@AndroidFindBy(id="io.appium.android.apis:id/clear")
	public WebElement ClearButton;
	
	public void dinnerButtonClick()	{
		DinnerButton.click();
	}
	
	public void lunchButtonClick()	{
		LunchButton.click();
	}
	
	public void snackButtonClick()	{
		SnackButton.click();
	}
	
	public void breakfastButtonClick()	{
		BreakfastButton.click();
	}
	
	public void allButtonClick()	{
		AllButton.click();
	}
	
	public void clearButtonClick()	{
		ClearButton.click();
	}
}
