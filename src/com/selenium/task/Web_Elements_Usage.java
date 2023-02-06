package com.selenium.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web_Elements_Usage  {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://2022mama.com/vote");
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.className("button")).click();
		WebElement username = driver.findElement(By.id("field-2"));
		username.sendKeys("abc@gmail.com");
		username.clear();
		username.sendKeys(Credentials.username());
		System.out.println("Text in the username box: "+username.getText()); // as there is no "inner text" for this box, so value will be null 
		System.out.println("value of the attribute for username box: "+username.getAttribute("value"));
		System.out.println("username box displayed: "+username.isDisplayed());
		WebElement password = driver.findElement(By.cssSelector("input[class ='log-first__pass__input w-input']"));
		password.sendKeys(Credentials.password());
		System.out.println("Tag name of password box: "+password.getTagName());
		System.out.println("Password box enabled: "+password.isEnabled());
		driver.findElement(By.className("log-first__btn-txt-login")).click();

	}
}
