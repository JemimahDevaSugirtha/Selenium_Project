package com.selenium.task;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mnet_Login  {

	public static void main(String[] args) throws InterruptedException, IOException {		
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://2022mama.com/vote");
		Screenshot.scrnsht(driver, driver.getTitle());
		driver.findElement(By.xpath("(//a[text()='LOG IN'])[1]")).click();
		driver.findElement(By.className("button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys(Credentials.username());
		driver.findElement(By.xpath("(//input[contains(@class,'log-first')])[2]"))
				.sendKeys(Credentials.password());
		Screenshot.scrnsht(driver, driver.getTitle());
		driver.findElement(By.className("log-first__btn-txt-login")).click();
		Thread.sleep(9000);
		Screenshot.scrnsht(driver, driver.getTitle());
//		driver.findElement(By.xpath("(//a[text()='LOG OUT'])[1]")).click();
//		driver.findElement(By.xpath("//button[@class = 'button']")).click();
//		Thread.sleep(5000);
//		driver.quit();
	}
}
