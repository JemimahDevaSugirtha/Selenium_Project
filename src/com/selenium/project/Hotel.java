package com.selenium.project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Hotel {
	
	public static void login(WebDriver driver) throws IOException {
		WebPage.screenshot(driver);
		WebPage.enterText("//span[@id='username_span']//preceding-sibling::input[@id='username']", Credentials.username, driver);
		WebPage.enterText("//span[@id='password_span']//preceding-sibling::input[@id='password']", Credentials.password, driver);
		WebPage.screenshot(driver);
		WebPage.click("//table[@class='login']/tbody/tr[6]/td[2]/input", driver);
	}
	
	public static void search(String Location, String checkInDate, String checkOutDate, WebDriver driver ) throws IOException {
		WebPage.screenshot(driver);
		WebPage.selectByValue("//select[@id='location']", Location, driver);
		WebPage.selectByValue("//select[@id='hotels']", "Hotel Creek", driver);
		WebPage.selectByValue("//select[@id='room_type']", "Standard", driver);
		WebPage.selectByValue("//select[@id='room_nos']", "3", driver);
		WebPage.clear("//input[@id='datepick_in']", driver);
		WebPage.enterText("//input[@id='datepick_in']",checkInDate, driver);
		WebPage.clear("//input[@id='datepick_out']", driver);
		WebPage.enterText("//input[@id='datepick_out']",checkOutDate, driver);
		WebPage.selectByValue("//select[@id='adult_room']", "2", driver);
		WebPage.selectByValue("//select[@id='child_room']", "2", driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='Submit']", driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='total_radiobutton']//preceding-sibling::input[@id='radiobutton_0']", driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='cancel']//preceding-sibling::input[@id='continue']", driver);
	}
	
	public static void book(WebDriver driver) throws IOException {
		WebPage.enterText("//label[@id='first_name_span']//preceding-sibling::input[@id='first_name']",Credentials.firstName, driver);
		WebPage.screenshot(driver);
		WebPage.scrollTo("//label[@id='first_name_span']//preceding-sibling::input[@id='first_name']", driver);
		WebPage.enterText("//label[@id='last_name_span']//preceding-sibling::input[@id='last_name']",Credentials.lastName, driver);
		WebPage.enterText("//label[@id='address_span']//preceding-sibling::textarea[@id='address']",Credentials.address, driver);
		WebPage.enterText("//label[@id='cc_num_tip']//preceding-sibling::input[@id='cc_num']",Credentials.creditCardNo, driver);
		WebPage.selectByText("//select[@id='cc_type']", Credentials.cardType, driver);
		WebPage.selectByText("//select[@id='cc_exp_month']", Credentials.expiryMonth, driver);
		WebPage.selectByText("//select[@id='cc_exp_year']", Credentials.expiryYear, driver);
		WebPage.enterText("//label[@id='cc_cvv_span']//preceding-sibling::input[@id='cc_cvv']",Credentials.cvv, driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='cancel']//preceding-sibling::input[@id='book_now']", driver);		
	}
	
	public static void confirmAandLogout(WebDriver driver) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.urlToBe("https://adactinhotelapp.com/BookingConfirm.php")); //explicit wait
		WebPage.screenshot(driver);
		WebPage.scrollTo("//input[@id='search_hotel']", driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='my_itinerary']", driver);
		WebPage.screenshot(driver);
		WebPage.click("//input[@id='search_hotel']//following-sibling::input[@id='logout']", driver);
	}
}
