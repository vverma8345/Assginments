package seleniumeasy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.Highlighter;
import utility.ScreenShot;

public class PractiseTest {
	WebDriver wd;

	@SuppressWarnings("static-access")
	@BeforeTest
	public void StartBrowser() throws IOException {
		wd = new FirefoxDriver();
	
		
		wd.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		ScreenShot.Captured(wd);
		wd.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void TestTwo() throws Exception {
		
		List<WebElement> ele = wd.findElements(By.xpath(".//*[@class=\"btn btn-default btn-lg\"]"));
	
		Iterator<WebElement> it = 	ele.iterator();
		WebElement btn = (WebElement) it.next();
		
		WebElement btn1 = (WebElement) it.next();
		
		Highlighter.OnElement(wd,btn1);
		Thread.sleep(2000);
		btn1.click();
		Alert alert = wd.switchTo().alert();
		alert.sendKeys("ASDAsdmaklsdjklasjdka");
		
		//wd.findElement(By.id("prompt-demo")).clear();//sendKeys("Hello World");
		Thread.sleep(2000);
		alert.accept();
		
		
//		JavascriptExecutor js = ((JavascriptExecutor)wd);
//		js.executeScript("arguments[0].scrollIntoView", ele);

		
		
	}

	

	@AfterTest
	public void CloseBroswer() {
		
		wd.quit();
	}
	
	
}