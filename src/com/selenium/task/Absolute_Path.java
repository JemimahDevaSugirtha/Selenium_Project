package com.selenium.task;

import org.openqa.selenium.WebDriver;

public class Absolute_Path {

	public static void main(String[] args) {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/");
		
		Base.click(driver,Base.element(driver,"//span[.='×']"));
		
		Base.hover(driver, Base.element(driver, 
				"//html/body/div[3]/div[4]/div/div/div[5]/div/div/div/div/ul/li[2]/a[2]"));
		
		Base.hoverAndClick(driver, Base.element(driver, 
				"//html/body/div[3]/div[4]/div/div/div[5]/div/div/div/div/ul/li[2]/div/div/div/ul/li[1]/div[2]/ul/li[2]/a"));
	}

}
