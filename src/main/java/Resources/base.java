package Resources;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
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
		boolean flag=checkIfServerIsRunnning(4723);
		if(!flag)
		{	
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
			return service;
	}
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
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
