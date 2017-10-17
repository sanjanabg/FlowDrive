package FlowDriveApp;

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

import org.testng.annotations.Test;

public class RegisterandSubmitProfile_Valid extends InstallandLaunchFlow {

	@Test
	public void register()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\gbsurao1\\eclipse-workspace\\FlowDrive\\src\\TestData\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("register_valid");
		Row row = sh.getRow(1);

		Cell c1 = row.getCell(0);
		String Username = c1.getStringCellValue();

		Cell c2 = row.getCell(1);
		String Surname = c2.getStringCellValue();

		Cell c3 = row.getCell(2);
		String mm = c3.getStringCellValue();

		Cell c4 = row.getCell(3);
		String dd = c4.getStringCellValue();

		Cell c5 = row.getCell(4);
		String yy = c5.getStringCellValue();

		Cell c6 = row.getCell(5);
		String Email = c6.getStringCellValue();

		Cell c7 = row.getCell(6);
		String Postcode = c7.getStringCellValue();

		Cell c8 = row.getCell(7);
		String Companyname = c8.getStringCellValue();

		Cell c9 = row.getCell(8);
		String Pswrd = c9.getStringCellValue();

		Cell c10 = row.getCell(9);
		String Repeatpswrd = c10.getStringCellValue();

		// Click on Create an Account Now in Login Page
		driver.findElement(By.id("com.thefloow.flo:id/text_view_create_account")).click();
		Reporter.log("successfully Clicked on 'Create an account now'");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Input all details
		driver.findElement(By.name("First name")).sendKeys(Username);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.findElement(By.name("Surname")).sendKeys(Surname);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.findElement(By.id("com.thefloow.flo:id/edit_text_email")).sendKeys(Email);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.findElement(By.id("com.thefloow.flo:id/edit_text_postcode")).sendKeys(Postcode);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.findElement(By.id("com.thefloow.flo:id/edit_text_company_name")).sendKeys(Companyname);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		driver.findElement(By.id("com.thefloow.flo:id/edit_text_password")).sendKeys(Pswrd);
		driver.findElement(By.id("com.thefloow.flo:id/edit_text_confirm_password")).sendKeys(Repeatpswrd);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		// To Select Nov 22 1998 as DOB
		driver.findElement(By.name("Date of birth (at least 17 years old)")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (driver.findElement(By.id("android:id/parentPanel")).isDisplayed()) {

			while (!(driver.findElement(By.id("android:id/month")).findElement(By.className("android.widget.EditText"))
					.getText()).equals(mm)) {
				driver.findElement(By.name("Increase month")).click();
			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			while (!(driver.findElement(By.id("android:id/day")).findElement(By.className("android.widget.EditText"))
					.getText()).equals(dd)) {

				driver.findElement(By.name("Increase day")).click();
			}

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			while (!(driver.findElement(By.id("android:id/year")).findElement(By.className("android.widget.EditText"))
					.getText()).equals(yy)) {
				driver.findElement(By.name("Decrease year")).click();
			}

		}

		// click on Set Button
		driver.findElement(By.name("Set")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("successfully inserted all Registration Details");

		// Click on Submit button
		driver.findElement(By.id("com.thefloow.flo:id/button_register")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(10000);
		Reporter.log("successfully clicked on Submit button");

		if (driver.findElement(By.id("com.thefloow.flo:id/text_view_promo_blurb_header")).isDisplayed()) {
			Reporter.log("successfully Registered");
		}

		// click Login
		driver.findElement(By.id("com.thefloow.flo:id/button_success_dismiss")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.name("Welcome to FlowDrive")).isDisplayed()) {
			Reporter.log("successfully Logged In");
		}

		// click on close button on top right corner
		driver.findElement(By.id("com.thefloow.flo:id/btn_welcome_close")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.id("com.thefloow.flo:id/image_view_logo")).isDisplayed()) {
			Reporter.log("We are on the Main page of FlowDrive App");
		}

	}

}
