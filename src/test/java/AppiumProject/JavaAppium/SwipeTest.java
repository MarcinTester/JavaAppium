package AppiumProject.JavaAppium;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
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

public class SwipeTest extends base {

	@Test
	public void test1() throws MalformedURLException
	{
		
	
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		
		HomePage homePage = new HomePage(driver); 
		homePage.viewsClick();
		
		ViewsPage viewsPage = new ViewsPage(driver); 	
		viewsPage.dateWidgetsClick();
		
		DataWidgetsPage dataWidgetsPage = new DataWidgetsPage(driver);
		dataWidgetsPage.inlineClick();
		
	//	driver.findElementByXPath("//*[@content-desc='9']").click();
		
		InlinePage inlinePage = new InlinePage(driver);
		inlinePage.numberClick();
		WebElement number15 = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement number45 = driver.findElementByXPath("//*[@content-desc='45']");
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(number15)).withDuration(ofSeconds(2))).moveTo(element(number45)).release().perform();
		
	}
	
}
