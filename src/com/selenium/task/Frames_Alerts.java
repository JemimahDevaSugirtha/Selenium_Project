package com.selenium.task;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frames_Alerts {
	static WebDriver driver;	
	public static void alerts() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='SwitchTo']")).click();
		driver.findElement(By.xpath("//a[.='Alerts']")).click();
		driver.findElement(By.xpath("//a[.='Alert with OK ']")).click();
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		driver.switchTo().alert().accept(); //Simple alert
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
		driver.switchTo().alert().dismiss(); //Simple with cancel alert
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
		driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
		Alert alert = driver.switchTo().alert(); //alert with text box
		alert.sendKeys("JEMIMAH");
		alert.accept();		
	}	
	public static void frame() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='SwitchTo']")).click();		//Single frame
		driver.findElement(By.xpath("//a[.='Frames']")).click();
		driver.findElement(By.xpath("//a[.='Single Iframe ']")).click();
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("JEMIMAH");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[.='Iframe with in an Iframe']")).click();		//Multi frames
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("JEMIMAH");
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[.='Single Iframe ']")).click();		
	}
	public static void main(String[] args) throws InterruptedException {
		driver = Browser_Launch_Base.chrome_Browser("https://demo.automationtesting.in/Alerts.html");
		alerts();
		frame();
	}
}
