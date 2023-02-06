package com.selenium.task;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Actions {
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
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/");
		Actions a = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//span[.='×']")).click();
		a.moveToElement(driver.findElement(By.xpath("(//a[@class='ty-menu__item-link'])[185]"))).build().perform();
		WebElement skincare = driver.findElement(By.xpath("(//a[@href='https://kindlife.in/skincare/'])[2]"));
		a.moveToElement(skincare).build().perform();
		a.click(skincare).build().perform();
		WebElement snail = driver.findElement(By.xpath("(//img[@id='det_img_3964'])"));
		js.executeScript("arguments[0].scrollIntoView()", snail);
		a.moveToElement(snail).clickAndHold(snail).build().perform();
		Thread.sleep(2000);
		a.release(snail).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[.='+']"))).doubleClick().build().perform();
		js.executeScript("arguments[0].setAttribute('style','color:red')", driver.findElement(By.xpath("(//input[@type='text'])[3]")));
		WebElement cosrx = driver.findElement(By.xpath("(//a[.='COSRX'])[1]"));
		a.moveToElement(cosrx).contextClick().build().perform();
		down();
		enter();
		a.moveToElement(cosrx).contextClick().build().perform();
		down();
		down();
		enter();		
	}
}
