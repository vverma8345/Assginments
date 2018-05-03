package Practise;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestDemo {

	
	@SuppressWarnings("null")
	@Test
	public void function() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\drivers");
		WebDriver wd = new ChromeDriver();
		wd.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.navigate().to("https://www.fabhotels.com/");
		wd.navigate().refresh();
		wd.navigate().back();
		wd.navigate().forward();
		
		Actions action = new Actions(wd);
		WebElement button = null;
		action.click(button);
		action.contextClick(button);
		action.dragAndDrop(button, button);
		action.moveToElement(button).perform();
		action.moveToElement(button).build().perform();
		button.getCssValue("font-size");
		
			wd.switchTo().alert().accept();
			
			wd.switchTo().frame(1);
			wd.switchTo().frame(2);
			wd.switchTo().parentFrame();
			wd.switchTo().defaultContent();
			
			Set<String> window = wd.getWindowHandles();
			
			Iterator<String> it = window.iterator();
		   System.out.println(it.next());
		   System.out.println(it.next());
		   
		  
		File src =((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src,new File( "//ScreenShot"));
		   
		   JavascriptExecutor js = (JavascriptExecutor)wd;
		   js.executeScript("arguments[0].scrollIntoView(true);",button);
		   
		   
		
		
		
	}
	
	
}
