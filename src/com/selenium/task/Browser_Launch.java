package com.selenium.task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Launch {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Browser launch
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("https://www.facebook.com/");
		cdriver.navigate().to("https://www.amazon.in/");
		cdriver.navigate().back();
		cdriver.navigate().forward();
		System.out.println("Chrome browser current URL title: "+cdriver.getTitle());
		System.out.println("firefox browser current URL: "+cdriver.getCurrentUrl());
		cdriver.close();
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\geckodriver.exe");
		WebDriver fdriver = new FirefoxDriver();
		fdriver.get("https://www.instagram.com/");
		fdriver.navigate().refresh();
		fdriver.manage().window().maximize();
		fdriver.close();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\msedgedriver.exe");
		WebDriver edriver = new EdgeDriver();
		edriver.get("https://www.youtube.com/");
		edriver.get("https://www.instagram.com/");
		edriver.get("https://www.facebook.com/");
		edriver.manage().window().maximize();
		edriver.manage().window().minimize();
		edriver.quit();
		
		
		
	}

}
