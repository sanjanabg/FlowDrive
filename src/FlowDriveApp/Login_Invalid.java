package FlowDriveApp;

import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class Login_Invalid extends InstallandLaunchFlow {
	@Test
	public void Login() throws EncryptedDocumentException, OpenXML4JException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\gbsurao1\\eclipse-workspace\\FlowDrive\\src\\TestData\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("login_invalid");
		Row row = sh.getRow(1);
		Row row1 = sh.getRow(2);
		Cell c1 = row.getCell(0);
		String email = c1.getStringCellValue();

		Cell c2 = row.getCell(1);
		String pswrd = c2.getStringCellValue();

		Cell c11 = row1.getCell(0);
		String email1 = c11.getStringCellValue();

		Cell c22 = row1.getCell(1);
		String pswrd1 = c22.getStringCellValue();

		// Invalid password
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_email")).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_password")).sendKeys(pswrd);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Click on Login
		driver.findElement(By.id("com.thefloow.flo:id/btn_login")).click();
		Thread.sleep(5000);

		while (driver.findElement(By.id("android:id/alertTitle")).isDisplayed()) {
			String s1 = "User name/password not found. Are you registered?";
			if (driver.findElement(By.id("android:id/message")).getText().equals(s1)) {
				Reporter.log("Right Error message displayed for Invalid password");
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(5000);
			}
		}

		// Invalid EmailId
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_email")).sendKeys(email1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_password")).sendKeys(pswrd1);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Click on Login
		driver.findElement(By.id("com.thefloow.flo:id/btn_login")).click();
		Thread.sleep(5000);

		while (driver.findElement(By.id("android:id/alertTitle")).isDisplayed()) {
			String s2 = "Please enter an address in the correct format: abc@xyz.com";
			if (driver.findElement(By.id("android:id/message")).getText().equals(s2)) {
				Reporter.log("Right Error message displayed for Invalid EmailID");
				driver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(5000);
			}
		}

	}

}
