package com.selenium.task;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Multiple_Window_Handles {
		
	public static void main(String[] args) throws AWTException {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/");
		Base.click(driver,Base.element(driver,"//span[.='×']"));
		Base.hover(driver, Base.element(driver, "(//a[@class='ty-menu__item-link'])[184]"));
		Base.hoverAndClick(driver, Base.element(driver, "(//a[@href='https://kindlife.in/skincare/'])[2]"));
		WebElement snail = Base.element(driver, "(//img[@id='det_img_3964'])");
		Base.scrollTo(snail, driver);
		Base.click(driver, snail);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //implicit wait
		Base.right_Click(driver, Base.element(driver, "(//a[.='COSRX'])[1]"));
		Base.down();
		Base.enter();
		Base.single_Window_Switch(driver);
		Base.right_Click(driver, Base.element(driver, "//a[.='BHA Blackhead Power Liquid - 100ml']"));
		Base.down();
		Base.enter();
		WebElement aha = Base.element(driver, "//a[.='AHA 7 Whitehead Power Liquid - 100ml']");
		Base.scrollTo(aha, driver);
		Base.right_Click(driver, aha);
		Base.down();
		Base.enter();
		String target = "https://kindlife.in/aha-7-whitehead-power-liquid-100ml/";
		Base.multiple_Window_Switch(target, driver);
		Base.scrollTo(Base.element(driver, "(//button[@type='submit'])[3]"), driver);
		Base.click(driver,Base.element(driver, "(//button[@type='submit'])[3]"));
	}

}
