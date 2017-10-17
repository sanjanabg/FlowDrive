package FlowDriveApp;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class HomePageActivities extends InstallandLaunchFlow {
	@Test
	public void mainpage() throws InterruptedException {

		// verify whether start journey button in Home Page functions
		driver.findElement(By.id("com.thefloow.flo:id/btn_start")).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.id("com.thefloow.flo:id/btn_cancel_gps")).isDisplayed()) {
			Reporter.log("successfully clicked on Start Journey button");
		}

		// now tap on Cancel to stop journey
		driver.findElement(By.id("com.thefloow.flo:id/btn_cancel_gps")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(20000);
		Reporter.log("successfully clicked on Cancel button to stop journey");

		// Navigate to Journeys page
		driver.findElement(By.id("com.thefloow.flo:id/tab_journeys")).click();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.name("Distance")).isDisplayed()) {
			Reporter.log("Landed on Journeys Page");
		}

		// Navigate to Score Page
		driver.findElement(By.id("com.thefloow.flo:id/tab_score")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.id("com.thefloow.flo:id/image_score_dial")).isDisplayed()) {
			Reporter.log("Landed on Score Page");
		}

		// Navigate to Social Page
		driver.findElement(By.id("com.thefloow.flo:id/tab_social")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.id("com.thefloow.flo:id/social_menu_my_scores")).isDisplayed()) {
			Reporter.log("Landed on Social Page");
		}

		// Navigate to Help Page
		driver.findElement(By.id("com.thefloow.flo:id/tab_help")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.id("android:id/text1")).isDisplayed()) {
			Reporter.log("Landed on Help Page");
		}

		// Navigate back to Home Page
		driver.findElement(By.id("com.thefloow.flo:id/tab_home")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(10000);
		if (driver.findElement(By.id("com.thefloow.flo:id/image_view_logo")).isDisplayed()) {
			Reporter.log("Navigated back to Home Page ");
		}

	}

}
