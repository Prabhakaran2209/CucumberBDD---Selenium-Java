package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/parallel/AccountsPage.feature"},
		glue = {"parallel"},
		//tags = "not @Skip, @Login",
	    plugin = {"pretty","summary",
	    		  "json: target/Myreports/report.json",
	    		  "junit: target/Myreports/report.xml",
	    		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		  "timeline:test-output-thread/",
	    		  "rerun: target/failedrerun.txt"
	    		  },
	    monochrome = true
		)

public class Parallelrunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
