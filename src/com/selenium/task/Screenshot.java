package com.selenium.task;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot{
	static int a=0;
	public static void scrnsht(WebDriver driver, String name) throws IOException {
		String prime,ext,i;
		prime = "D:\\Jemi\\Selenium\\eclipse-workspace\\Selenium_Project\\Screenshots\\";
		ext = ".png";
		i= prime.concat(name.replaceAll("[^a-zA-Z0-9]", ""))+a+ext;
		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File des = new File(i);
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(i));
		++a;
	}
}
