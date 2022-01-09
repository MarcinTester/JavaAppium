package AppiumProject.JavaAppium;


import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PreferencesDependenciesPage;
import PageObjects.PreferencesPage;
import Resources.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TextTest  extends base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@Test(dataProvider="getData")
	public void Text(String test) throws IOException, InterruptedException	{
		
		service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		
		HomePage homePage = new HomePage(driver); 
		
		homePage.preferencesClick();
		
		
		PreferencesPage preferencesPage = new PreferencesPage(driver);
		
		preferencesPage.preferenceDependenciesClick();
		
		PreferencesDependenciesPage preferencesDependenciesPage = new PreferencesDependenciesPage(driver);
	
		preferencesDependenciesPage.checkBoxClick();
		preferencesDependenciesPage.wiFisettingsClick();
		preferencesDependenciesPage.textBoxSendText(test);
		preferencesDependenciesPage.okButtonClick();
		service.stop();
	}
	
	@DataProvider
	public Object[][] getData() {
	Object[][] data= new Object[1][1];
	data[0][0] = "test";
	return data;
	}
	
}
