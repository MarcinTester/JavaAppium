package AppiumProject.JavaAppium;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;



import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RadioGroupPage;
import PageObjects.ViewsPage;
import Resources.base;
import Resources.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollTest  extends base {

	@Test
	public void ScrollTest1() throws IOException, InterruptedException{
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		HomePage homePage = new HomePage(driver); 
		homePage.viewsClick();
		
		Utilities u = new Utilities(driver);
		
		u.scrollToText("Radio Group");
		
		ViewsPage viewsPage = new ViewsPage(driver);

		assertEquals(viewsPage.RadioGroup.isDisplayed(), true);
		System.out.println(viewsPage.RadioGroup.isDisplayed());
		viewsPage.radioGroupClick();
		
		service.stop();
	}	
}
