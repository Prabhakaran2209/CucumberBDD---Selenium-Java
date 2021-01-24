package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//By locators
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By signin = By.id("SubmitLogin");
	private By forgotpassword = By.linkText("Forgot your password?123");
	
	//create constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Actions on a page
	public String getLoginPageTitle() {
		return driver.getTitle();
	};
	
	public boolean isFrgotPasswordlinkExist() {
		return driver.findElement(forgotpassword).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(email).sendKeys(username);
	}
	
	public void clickLogin() {
		driver.findElement(signin).click();
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public AccountPage doLogin(String un, String pwd) {
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signin).click();
		return new AccountPage(driver);
	}
}
