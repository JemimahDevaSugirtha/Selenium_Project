package com.selenium.task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class Browser_Launch_Base {
	
	public static WebDriver chrome_Browser(String url) {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver firefox_Browser(String url) {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static WebDriver edge_Browse(String url) {
		System.setProperty("webdriver.edge.driver", 
				"C:\\Users\\DELL\\eclipse-workspace\\Selenium_Project\\Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
