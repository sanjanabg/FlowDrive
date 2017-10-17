package FlowDriveApp;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.BeforeMethod;

import java.io.File;


import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class InstallandLaunchFlow {

	protected static AndroidDriver<AndroidElement> driver;

	@BeforeMethod
	public void beforeMethod()
			throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

	

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/Apps/FloowApp/");
		File app = new File(appDir, "8b3d8e298a.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "C5302");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		capabilities.setCapability("appPackage", "com.thefloow.flo");
		capabilities.setCapability("appActivity", "com.thefloow.flo.activity.LauncherActivity");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Reporter.log("Flow App Installed and Launched Successfully");

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		Thread.sleep(5000);

	}

	@Test
	public void Launch() throws InterruptedException {
		// Click on I Agree in Terms and Conditions page
		driver.findElement(By.id("com.thefloow.flo:id/btn_agree")).click();
		Thread.sleep(10000);
		if (driver.findElement(By.name("Please log in")).isDisplayed()) {
			Reporter.log("successfully Clicked on I Agree Button and navigated to Login Page");
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

	}

}
