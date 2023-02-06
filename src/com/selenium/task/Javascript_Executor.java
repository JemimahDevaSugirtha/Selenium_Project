package com.selenium.task;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Javascript_Executor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://demo.automationtesting.in/Register.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("JEMIMAH");
		driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys("DEVASUGIRTHA");
		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys(Credentials.username());
		WebElement phone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
		phone.sendKeys("8234567190");
		js.executeScript("arguments[0].setAttribute('style','color:indigo')",phone);
		driver.findElement(By.xpath("(//input[@ng-model='radiovalue'])[2]")).click();
		WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
		Select s = new Select(country);
		js.executeScript("arguments[0].scrollIntoView()",country);
		s.selectByValue("India");
		js.executeScript("arguments[0].value='Tae@123'", driver.findElement(By.xpath("//input[@id='firstpassword']")));
		js.executeScript("arguments[0].value='Tae@123'", driver.findElement(By.xpath("//input[@id='secondpassword']")));
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//button[@id='Button1']")));
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//h2[.='Register']")));
	}

}
