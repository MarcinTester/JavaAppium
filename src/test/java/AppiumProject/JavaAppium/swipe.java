package AppiumProject.JavaAppium;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import PageObjects.homePage;
import PageObjects.viewsPage;
import Resources.base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class swipe extends base {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		
		homePage homePage = new homePage(driver); 
		

		homePage.viewsClick();
		
		viewsPage viewsPage = new viewsPage(driver); 
		
		viewsPage.dateWidgetsClick();
		
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElementByXPath("//*[@content-desc='9']").click();
		WebElement number15 = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement number45 = driver.findElementByXPath("//*[@content-desc='45']");
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(number15)).withDuration(ofSeconds(2))).moveTo(element(number45)).release().perform();
		
	}

}
