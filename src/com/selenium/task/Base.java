package com.selenium.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
	private static Actions a;
	private static Robot r;
	public static WebElement element(WebDriver driver,String path) {
		WebElement foundElement = driver.findElement(By.xpath(path));
		return foundElement;	
	}
	public static List<WebElement> elements(WebDriver driver,String path) {
		List<WebElement> foundElements = driver.findElements(By.xpath(path));
		return foundElements;	
	}
	public static void hover(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}	
	public static void click(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.click(element).build().perform();
	}	
	public static void hoverAndClick(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
	}
	public static void hoverAndRightClick(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.moveToElement(element).contextClick().build().perform();
	}
	public static void right_Click(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.contextClick(element).build().perform();
	}	
	public static void double_Click(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.doubleClick(element).build().perform();
	}
	public static void clickAndHold(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.clickAndHold(element).build().perform();
	}
	public static void releaseHold(WebDriver driver,WebElement element) { //mouse action
		a = new Actions(driver);
		a.release(element).build().perform();
	}
	public static void scrollTo(WebElement element,WebDriver driver) {  //javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
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
	public static void multiple_Window_Switch(String url,WebDriver driver) { //To switch between multiple window
		Set<String> idset = driver.getWindowHandles();
		for (String id : idset) {
			if (driver.switchTo().window(id).getCurrentUrl().equals(url)) {
				break;
			}
		}
	}
}
