package WalletHub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Assignment_2 {

	WebDriver wd;
	@BeforeTest
	public void StartBrowser() {

		 wd = new FirefoxDriver();
		wd.get("http://wallethub.com/profile/test_insurance_company/");
		wd.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		
	}
	
	@Test
	public void Test() throws InterruptedException
	{
		Thread.sleep(3000);
		Actions action = new Actions(wd);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.moveToElement(wd.findElement(By.xpath("//a[text()=\"4\"]")));
		
		wd.findElement(By.xpath("//a[text()=\"5\"]")).click();
		
	}
}
