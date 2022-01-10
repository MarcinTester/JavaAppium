package AppiumProject.JavaAppium;
import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RadioGroupPage;
import PageObjects.ViewsPage;
import Resources.base;
import Resources.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ButtonTest  extends base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	@Test
	public void ButtonTest1() throws IOException, InterruptedException{
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		HomePage homePage = new HomePage(driver); 
		homePage.viewsClick();
		
		
		
		Utilities u = new Utilities(driver);
		
		u.scrollToText("Radio Group");
		
		ViewsPage viewsPage = new ViewsPage(driver);
		
		viewsPage.radioGroupClick();
		
		RadioGroupPage radioGroupPage = new RadioGroupPage(driver);
	
		assertEquals(radioGroupPage.DinnerButton.getAttribute("checked").equals("false"), true);
		radioGroupPage.dinnerButtonClick();
		assertEquals(radioGroupPage.DinnerButton.getAttribute("checked").equals("true"), true);
		
		radioGroupPage.breakfastButtonClick();
		assertEquals(radioGroupPage.BreakfastButton.getAttribute("checked").equals("true"), true);
		
		radioGroupPage.allButtonClick();
		assertEquals(radioGroupPage.AllButton.getAttribute("checked").equals("true"), true);
		
		radioGroupPage.snackButtonClick();
		assertEquals(radioGroupPage.SnackButton.getAttribute("checked").equals("true"), true);
		
		radioGroupPage.lunchButtonClick();
		assertEquals(radioGroupPage.LunchButton.getAttribute("checked").equals("true"), true);
		
		radioGroupPage.clearButtonClick();
		System.out.println(radioGroupPage.LunchButton.getAttribute("checked").equals("false"));
		assertEquals(radioGroupPage.DinnerButton.getAttribute("checked").equals("false"), true);
		assertEquals(radioGroupPage.BreakfastButton.getAttribute("checked").equals("false"), true);
		assertEquals(radioGroupPage.AllButton.getAttribute("checked").equals("false"), true);
		assertEquals(radioGroupPage.SnackButton.getAttribute("checked").equals("false"), true);
		assertEquals(radioGroupPage.LunchButton.getAttribute("checked").equals("false"), true);
		
		System.out.println(radioGroupPage.DinnerButton.getAttribute("checked").equals("false"));
		service.stop();
	}	
}
