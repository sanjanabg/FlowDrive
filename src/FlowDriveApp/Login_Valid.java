package FlowDriveApp;

import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class Login_Valid extends InstallandLaunchFlow {
	@Test
	public void loginv() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\gbsurao1\\eclipse-workspace\\FlowDrive\\src\\TestData\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("login_valid");
		Row row = sh.getRow(1);

		Cell c1 = row.getCell(0);
		String eml = c1.getStringCellValue();

		Cell c2 = row.getCell(1);
		String pswd = c2.getStringCellValue();

		// valid login by registered user
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_email")).sendKeys(eml);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_password")).sendKeys(pswd);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Click on Login
		driver.findElement(By.id("com.thefloow.flo:id/btn_login")).click();
		Thread.sleep(5000);

		// click on close button on top right corner
		driver.findElement(By.id("com.thefloow.flo:id/btn_welcome_close")).click();
		Thread.sleep(5000);

		if (driver.findElement(By.id("com.thefloow.flo:id/image_view_logo")).isDisplayed()) {
			Reporter.log("Logged in successfully and landed on the Main page of FlowDrive App");
		}

	}

}
