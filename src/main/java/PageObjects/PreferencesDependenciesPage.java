	package PageObjects;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.pagefactory.AndroidFindBy;
	import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	public class PreferencesDependenciesPage {
		
		public AndroidDriver<AndroidElement> driver;

		public PreferencesDependenciesPage(AndroidDriver<AndroidElement> driver)
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		@AndroidFindBy(id="android:id/checkbox")
		public WebElement CheckBox;	
		
		@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
		public WebElement WiFisettings;	
		
		@AndroidFindBy(className="android.widget.EditText")
		public WebElement TextBox;	

		
		public void checkBoxClick()
		{
			CheckBox.click();
		}
		
		public void wiFisettingsClick()
		{
			WiFisettings.click();
		}
		
		public void textBoxSendText(String text)
		{
		//	WiFisettings.click();
			TextBox.sendKeys(text);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
