package FlowDriveApp;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.testng.Reporter;

public class HomePage_FeedBack extends InstallandLaunchFlow {
	@Test
	public void feedback() throws InterruptedException {

		// Click on Feedback button in HomePage
		driver.findElement(By.id("com.thefloow.flo:id/btn_feedback")).click();
		Thread.sleep(5000);

		if (driver.findElement(By.id("com.thefloow.flo:id/button_send")).isDisplayed()) {
			Reporter.log("successfully clicked on Feedback button");
		}

		// select a category
		driver.findElement(By.id("com.thefloow.flo:id/spinner_categories")).click();
		Thread.sleep(5000);
		// select Scoring Category
		driver.findElement(By.name("Scoring")).click();
		Thread.sleep(5000);

		// Input your message
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_message")).sendKeys("Good");
		Thread.sleep(5000);

		// Click on Send button
		driver.findElement(By.id("com.thefloow.flo:id/button_send")).click();
		Thread.sleep(10000);
		Reporter.log("selected Scoring as category and entered appropriate feedback and clicked on Send");

		// Select Gmail to send Feedback
		driver.findElement(By.name("Gmail")).click();
		Thread.sleep(10000);
		Reporter.log("Gmail selected inorder to send Feedback");

		// now click on send email button
		driver.findElement(By.id("com.google.android.gm:id/send")).click();
		Thread.sleep(10000);
		Reporter.log(" Feedback successfully sent via Gmail");

	}

}
