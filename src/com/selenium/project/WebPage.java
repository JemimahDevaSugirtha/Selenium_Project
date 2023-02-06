package com.selenium.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPage {
	private static Actions a;
	private static Robot r;
	private static int count = 0;
	
	public static WebElement element(String elementPath, WebDriver driver) {
		WebElement foundElement = driver.findElement(By.xpath(elementPath));
		return foundElement;	
	}
	
	public static List<WebElement> elements(String elementPath, WebDriver driver) {
		List<WebElement> foundElements = driver.findElements(By.xpath(elementPath));
		return foundElements;	
	}
	
	public static void enterText(String elementPath,String text, WebDriver driver) { //enter text in text box
		driver.findElement(By.xpath(elementPath)).sendKeys(text);
	}
	
	public static void selectByValue(String elementPath,String value, WebDriver driver) { //select by value from dropdown box
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.click();
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectByText(String elementPath,String value, WebDriver driver) { //select by text from dropdown box
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.click();
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public static void selectByIndex(String elementPath,int index, WebDriver driver) { //select by index from dropdown box
		WebElement element = driver.findElement(By.xpath(elementPath));
		element.click();
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public static void clear(String elementPath, WebDriver driver) { //to clear the text box
		driver.findElement(By.xpath(elementPath)).clear();
	}
	
	public static void hover(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void click(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.click(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void hoverAndClick(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(elementPath))).click().build().perform();
	}
	
	public static void hoverAndRightClick(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(elementPath))).contextClick().build().perform();
	}
	
	public static void right_Click(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.contextClick(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void double_Click(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.doubleClick(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void clickAndHold(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		
		a.clickAndHold(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void releaseHold(String elementPath, WebDriver driver) { //mouse action
		a = new Actions(driver);
		a.release(driver.findElement(By.xpath(elementPath))).build().perform();
	}
	
	public static void scrollTo(String elementPath, WebDriver driver) {  //javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(elementPath)));
	}
	
	public static void down() throws AWTException {  //keyboard action
		r = new Robot();	
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	public static void enter() throws AWTException {  //keyboard action
		r = new Robot();	
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void single_Window_Switch(WebDriver driver) { //To switch between 2 window 
		String parent = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); //explicit wait
		Set<String> idset = driver.getWindowHandles();
		for (String id : idset) {
			if (id.equals(parent)) {
				continue;
			} else {
				driver.switchTo().window(id);
			}
		}
	}
	
	public static void multiple_Window_Switch(String url, WebDriver driver) { //To switch between multiple window
		Set<String> idset = driver.getWindowHandles();
		for (String id : idset) {
			if (driver.switchTo().window(id).getCurrentUrl().equals(url)) {
				break;
			}
		}
	}
	
	
	public static void screenshot(WebDriver driver) throws IOException {
		String path;
		path = "D:\\Jemi\\Selenium\\eclipse-workspace\\Selenium_Project\\Screenshots\\HotelBooking"+count+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(path));
		++count;
	}
}
