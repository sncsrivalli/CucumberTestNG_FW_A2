package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DriverUtility {
	WebDriver driver;
	
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("Invalid browser info");
		
		return driver;
	}
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	public void navigateToApp(String url) {
		driver.get(url);
	}
	
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void selectAnOption(WebElement dropdown, String text) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(text);
	}
	
	public void switchToframe(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	
	public String getScreenshot(String testname) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =  new File("./screenshots/"+testname+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	public WebElement convertDynamicPathToWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		return driver.findElement(By.xpath(requiredPath));
	}
	
	public void quitAllWindows() {
		driver.quit();
	}
}
