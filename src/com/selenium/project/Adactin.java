package com.selenium.project;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class Adactin {

	public static void main(String[] args) throws IOException {
		WebDriver driver = LaunchBrowser.chrome("https://adactinhotelapp.com/");		
		Hotel.login(driver);		
		Hotel.search("London", "24/12/2022", "27/12/2022", driver);		
		Hotel.book(driver);
		Hotel.confirmAandLogout(driver);
		
	}

}
