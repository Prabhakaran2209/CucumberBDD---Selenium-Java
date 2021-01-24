package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;
	
	//By locators
	private By accountsection = By.cssSelector("div#center_column span");

	//create constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public int getAccountSectionCount() {
		return driver.findElements(accountsection).size();
	}
	
	public ArrayList<String> getAccountsSectionList() {
		ArrayList <String> ar = new ArrayList<String>();
		
		List<WebElement> accountsectionlist = driver.findElements(accountsection);
		for(WebElement e: accountsectionlist) {
			String text = e.getText();
			System.out.println(text);
			ar.add(text);
		}
		return ar;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
		
}
