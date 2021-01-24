package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	//This method is used to initialise thread local driver on the basis of given browser
	public WebDriver int_driver (String browser) {
		System.out.println("your browser is "+ browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please give correct browser value : " +browser);
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	 //method used to get the driver using threadlocal
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
