package Resources;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}

	public static AndroidDriver<AndroidElement> capabilities(String App) throws MalformedURLException
	{
		
		AndroidDriver<AndroidElement> driver;
		File appDir = new File("src");
		System.out.println(appDir);
		DesiredCapabilities cap = new DesiredCapabilities();
		if (App.equals("Api-Demos"))
			{
			
			
			File app = new File(appDir, "ApiDemos-debug.apk");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			}
		else if (App.equals("Api-Demos"))
			{
				File app = new File(appDir, "General-Store.apk");
				cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			}


		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

}
//test
//test2
