package com.selenium.task;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Dynamic_Path {

	public static void main(String[] args) throws AWTException {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://kindlife.in/skincare/");
		Base.scrollTo(Base.element(driver, 
				"(//a[text()='COSRX'])[1]//preceding::a[@href='https://kindlife.in/advanced-snail-96-mucin-power-essence-100ml/']"), driver); //PRECEDING
		
		Base.right_Click(driver, Base.element(driver, 
				"(//a[@href='https://kindlife.in/advanced-snail-96-mucin-power-essence-100ml/'])[1]//following::a[text()='COSRX'][1]")); //FOLLOWING
		Base.down();Base.enter();

		Base.right_Click(driver, Base.element(driver, 
				"//li//parent::a[@href='https://kindlife.in/vitaminc']")); //PARENT
		Base.down();Base.enter();
		
		Base.right_Click(driver, Base.element(driver, 
				"//li//child::a[@href='https://kindlife.in/hyaluronic-acid']")); //CHILD
		Base.down();Base.enter();
		
		Base.right_Click(driver, Base.element(driver, 
				"//li[@class='ty-menu__item ty-menu__item-nodrop ty-menu-item__newest']//following-sibling::li[@class='ty-menu__item ty-menu__item-nodrop ty-menu-item__hits']")); //FOLLOWING-SIBLING
		Base.down();Base.enter(); //FOLLOWING-SIBLING
		
		Base.right_Click(driver, Base.element(driver, 
				"//li[@class='ty-menu__item ty-menu__item-nodrop']//preceding-sibling::li[@class='ty-menu__item ty-menu__item-nodrop ty-menu-item__brands']")); //PRECEDING-SIBLING
		Base.down();Base.enter(); //PRECEDING-SIBLING
		
		Base.scrollTo(Base.element(driver, 
				"//div[@class='span3  customer-service-grid']//descendant::span[text()='About us']"), driver); //DESCENDANT

		Base.right_Click(driver, Base.element(driver, 
				"//img[@src='https://kindlife.in/images/ui_icon/footer_app_andr_icon.png']//ancestor::a[@href='http://play.google.com/store/apps/details?id=com.kindlife']")); //ANCESTOR
		Base.down();Base.enter(); //ANCESTOR
	}
}
