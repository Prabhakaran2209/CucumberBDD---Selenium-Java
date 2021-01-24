package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features/LoginPage.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		//tags = "@Smoke, AND @Regression",
	    plugin = {"pretty",
	    		  "json: target/Myreports/report.json",
	    		  "junit: target/Myreports/report.xml",
	    		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	    		  "rerun: target/rerun.txt"
	    		  },
	    monochrome = true
	   // features = {"@target/rerun.txt"}
		
		)

public class Failed_rerun {

}
