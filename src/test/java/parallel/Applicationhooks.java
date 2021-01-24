package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.Configreader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Applicationhooks {
	private DriverFactory driverfactory;
	private WebDriver driver;
	private Configreader config;
	Properties prop;
	
	@Before(value = "@skip", order=0)
	public void skkipedTest(Scenario scenario) {
		System.out.println("Skipped scenario is " + scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void get_property() {
		config = new Configreader();
		prop = config.init_prop();
	}
	
	@Before(order = 2)
	public void launchbrowser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.int_driver(browserName);
	}
	
	@After(order = 0) 
	public void quit() {
		driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotname);
		}
	}

}
