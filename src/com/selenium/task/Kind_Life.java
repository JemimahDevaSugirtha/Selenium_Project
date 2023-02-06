package com.selenium.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Kind_Life {
		
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/");
		driver.findElement(By.xpath("//span[@class ='bk-icon-proicohdr bk_proicohdr_nonActiveImg']")).click();
		driver.findElement(By.xpath("//a[text() ='Register']")).click();
		driver.findElement(By.xpath("//span[@title ='Calendar']")).click();
		
		WebElement year = driver.findElement(By.xpath("//select[@data-handler = 'selectYear']"));
		year.click();
		Select s = new Select(year);
		s.selectByValue("1997");
		
		WebElement month = driver.findElement(By.xpath("//select[@data-handler = 'selectMonth']"));
		month.click();
		Select s1 = new Select(month);
		s1.selectByIndex(4);
		
		driver.findElement(By.xpath("(//a[text()='29'])[2]")).click();
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@class,'cm-calendar')]")).getAttribute("value"));
	}

}
