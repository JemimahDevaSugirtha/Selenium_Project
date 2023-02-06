package com.selenium.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Single_Window_Handles {
	public static WebDriver driver;
	private static void down() throws AWTException {
		Robot r = new Robot();	//Keyboard actions	
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	private static void enter() throws AWTException {
		Robot r = new Robot();		//Keyboard actions
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	private static void window_Switch() {
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
	public static void main(String[] args) throws AWTException {
		driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/");
		Actions a = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//span[.='×']")).click();
		a.moveToElement(driver.findElement(By.xpath("(//a[@class='ty-menu__item-link'])[184]"))).build().perform();
		WebElement skincare = driver.findElement(By.xpath("(//a[@href='https://kindlife.in/skincare/'])[2]"));
		a.moveToElement(skincare).build().perform();
		a.click(skincare).build().perform();
		WebElement snail = driver.findElement(By.xpath("(//img[@id='det_img_3964'])"));
		js.executeScript("arguments[0].scrollIntoView()", snail);
		a.moveToElement(snail).clickAndHold(snail).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //implicit wait
		a.release(snail).build().perform();
		WebElement cosrx = driver.findElement(By.xpath("(//a[.='COSRX'])[1]"));
		a.moveToElement(cosrx).contextClick().build().perform();
		down();
		enter();
		window_Switch();
		a.moveToElement(driver.findElement(By.xpath("(//a[@id='button_wishlist_3964'])[1]"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='cp_wl_select_btn_']"))).click().build().perform();
		window_Switch();
		a.moveToElement(driver.findElement(By.xpath("//a[@id='button_wishlist_3964']"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[.='Add to wishlist']"))).click().build().perform();
		window_Switch();
	}

}
