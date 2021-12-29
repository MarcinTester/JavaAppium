package AppiumProject.JavaAppium;


import java.net.MalformedURLException;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PreferencesDependenciesPage;
import PageObjects.PreferencesPage;
import Resources.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TextTest  extends base {

	@Test
	public void test1() throws MalformedURLException
	{
		AndroidDriver<AndroidElement> driver = capabilities("Api-Demos");
		
		HomePage homePage = new HomePage(driver); 
		
		homePage.preferencesClick();
		
		PreferencesPage preferencesPage = new PreferencesPage(driver);
		
		preferencesPage.preferenceDependenciesClick();
		
		PreferencesDependenciesPage preferencesDependenciesPage = new PreferencesDependenciesPage(driver);
		
		preferencesDependenciesPage.CheckBoxClick();
		preferencesDependenciesPage.WiFisettingsClick();
	}
	
	
	
}
