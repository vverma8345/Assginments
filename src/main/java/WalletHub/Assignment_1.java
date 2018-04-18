package WalletHub;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_1 {
	
	// To run this script please put for credentials into Data.propertires file
	Properties prop;
	FileInputStream fs;
	WebDriver wd;

	@BeforeTest
	public void PropertyFile() throws IOException {
		try {

			fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\WalletHub\\Data.properties");
			prop = new Properties();
			prop.load(fs);

		} catch (IOException e) {
			System.out.println("Error :- File not found" + e.getMessage());

		}

	}

	@SuppressWarnings("deprecation")
	@Test
	public void logInFacebook() throws Exception {

		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		wd = new FirefoxDriver(ffprofile);
		wd.get(prop.getProperty("Url"));
		wd.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.findElement(By.xpath(prop.getProperty("EmailorPhone"))).sendKeys(prop.getProperty("username"));
		wd.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(prop.getProperty("password"));
		wd.findElement(By.xpath(prop.getProperty("LogIn"))).click();
		Thread.sleep(10000);

	}

	@Test
	public void SharePost() throws Exception {

		WebElement notification = wd.findElement(By.xpath("//a[contains(@action,\"cancel\")]"));
		if (notification.isDisplayed()) {
			System.out.println("Notification is present");
			notification.click();
		}
		WebElement status = wd.findElement(By.xpath("//textarea[@name=\"xhpc_message\"]"));
		status.click();
		status.sendKeys("Hello World!");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(wd, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Post\"]"))).click();
	}

	@AfterTest
	public void CloseBrowser() {
		wd.close();

	}

}
