package AppiumProject.JavaAppium;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.DataWidgetsPage;
import PageObjects.HomePage;
import PageObjects.InlinePage;
import PageObjects.ViewsPage;
import Resources.base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class SwipeTest extends base {

	

	
	@Test(dataProvider="getData")
	public void Swipe(String number1, String number2, String number3) throws MalformedURLException
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		
		HomePage homePage = new HomePage(driver); 
		homePage.viewsClick();
		
		ViewsPage viewsPage = new ViewsPage(driver); 	
		viewsPage.dateWidgetsClick();
		
		DataWidgetsPage dataWidgetsPage = new DataWidgetsPage(driver);
		dataWidgetsPage.inlineClick();
		

		InlinePage inlinePage = new InlinePage(driver);
		inlinePage.numberClick(number1);
		
		
		
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(inlinePage.number(number2))).withDuration(ofSeconds(2))).moveTo(element(inlinePage.number(number3))).release().perform();
		service.stop();
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
	Object[][] data= new Object[1][3];
	data[0][0] = "10";
	data[0][1] = "25";
	data[0][2] = "55";

	return data;
	}
	
}
