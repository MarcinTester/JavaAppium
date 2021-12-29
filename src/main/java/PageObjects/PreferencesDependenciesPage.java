	package PageObjects;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.pagefactory.AndroidFindBy;
	import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class PreferencesDependenciesPage {

		public PreferencesDependenciesPage(AndroidDriver<AndroidElement> driver)
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(id="android:id/checkbox")
		public WebElement CheckBox;	
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='WiFi settings']")
		public WebElement WiFisettings;	
		
		public void CheckBoxClick()
		{
			CheckBox.click();
		}
		
		public void WiFisettingsClick()
		{
			WiFisettings.click();
		}
}
