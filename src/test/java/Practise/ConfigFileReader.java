package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigFileReader {
	Properties prop;
	FileInputStream fs;
	WebDriver wd;

	@BeforeTest
	public void PropertyFile() throws IOException {
		try {

			fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\Practise\\Data.properties");
			prop = new Properties();
			prop.load(fs);

		} catch (IOException e) {
			System.out.println("Error :- File not found" + e.getMessage());

		}

	}

	@Test
	public void StartBrowser() throws Exception {

		wd = new FirefoxDriver();
		wd.get(prop.getProperty("Url"));
		wd.manage().window().maximize();
		wd.findElement(By.xpath(prop.getProperty("SearchBox"))).sendKeys(prop.getProperty("SearchKey"));
		wd.findElement(By.xpath(prop.getProperty("SearchBtn"))).click();
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		wd.close();
		
	}

}
