package FlowDriveApp;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class HomePage_FeedBack extends InstallandLaunchFlow {
	@Test
	public void feedback() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\gbsurao1\\eclipse-workspace\\FlowDrive\\src\\TestData\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("gmaillogin");
		Row row = sh.getRow(1);
		
		Cell c1 = row.getCell(0);
		String email = c1.getStringCellValue();

		Cell c2 = row.getCell(1);
		String pswrd = c2.getStringCellValue();
		
		
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

		
		//Input Gmail Account details
		//gmail-existing account 
		driver.findElement(By.id("com.google.android.gsf.login:id/next_button")).click();
		Thread.sleep(10000);
		
		//Input Email and Password
		driver.findElement(By.id("com.google.android.gsf.login:id/username_edit")).sendKeys(email);
		Thread.sleep(5000);
		driver.findElement(By.id("com.google.android.gsf.login:id/password_edit")).sendKeys(pswrd);
		Thread.sleep(5000);		
		driver.findElement(By.id("com.google.android.gsf.login:id/next_button")).click();		
		Thread.sleep(10000);
		
		
		//agree to terms and conditions
		driver.findElement(By.id("android:id/button1")).click();		
		Thread.sleep(10000);
		
		driver.findElement(By.id("com.google.android.gsf.login:id/next_button")).click();		
		Thread.sleep(30000);
		
		//account sync
		driver.findElement(By.name("Accept")).click();		
		Thread.sleep(50000);
		Reporter.log("Successfully signed into gmail account");
		
		// now click on send email button
		driver.findElement(By.id("com.google.android.gm:id/send")).click();
		Thread.sleep(10000);
		Reporter.log(" Feedback successfully sent via Gmail");

	}

}
