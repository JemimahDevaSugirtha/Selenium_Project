package com.selenium.task;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Web_Table {

	public static void main(String[] args) {
		WebDriver driver = Browser_Launch_Base.chrome_Browser("https://qavbox.github.io/demo/webtable/");
		
		WebElement single_element = Base.element(driver, "//table[@id='table01']/tbody/tr[1]/td[4]");
		System.out.println("Single element fetch: "+single_element.getText());
		
		List<WebElement> row = Base.elements(driver, "//table[@id='table01']/tbody/tr[3]/td");
		for (WebElement i : row) {
			System.out.println("row fetch: "+i.getText());
		}
		
		List<WebElement> column = Base.elements(driver, "//table[@id='table01']/tbody/tr/td[3]");
		for (WebElement i : column) {
			System.out.println("column fetch: "+i.getText());
		}
		
		List<WebElement> check = Base.elements(driver, "//table[@id='table01']/tbody/tr/td[1]");
		for (WebElement i : check) {
			Base.click(driver, i);
		}
		
		List<WebElement> delete = Base.elements(driver, "//table[@id='table01']/tbody/tr/td[5]");
		for (WebElement i : delete) {
			Base.click(driver, i);
		}
	}

}
