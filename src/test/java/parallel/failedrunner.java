package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"@target/rerun.txt"},
		glue = {"parallel"},
		//tags = "@Smoke, AND @Regression",
	    plugin = {"pretty","summary",
	    		  "rerun:target/rerun.txt"
	    		  },
	    monochrome = true
		)


public class failedrunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
