package Resources;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
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
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\Marcin\\eclipse-workspace\\JavaAppium\\src\\main\\java\\Resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement> capabilities(String App) throws IOException, InterruptedException
	{
		startEmulator();
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
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
//
//	public static void getScreenshot(String s, AndroidDriver<AndroidElement> driver) throws IOException {
//		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File("C:\\work\\" + s + ".PNG"));
//	}
//	
//	public static void getScreenshot(String s) throws IOException {
//		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "\\" + s + ".png"));
//		}
	public static void getScreenshot(String s) throws IOException {
		 
		try{
		// To create reference of TakesScreenshot
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		// Call method to capture screenshot
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		// Copy files to specific location
		// result.getName() will return name of test case so that screenshot name will be same as test case name
		FileUtils.copyFile(src, new File("C:\\work\\" + s + ".PNG"));
		System.out.println("Successfully captured a screenshot");
		}catch (Exception e){
		System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}}
