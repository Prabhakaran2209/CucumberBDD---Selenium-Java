package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features= {"src/test/resources/parallel/LoginPage.feature"},
		glue = {"parallel"},
		//tags = "not @Skip",
	    plugin = {"pretty", "summary"
	    		  },
	    monochrome = true
		
		)

public class MyserenityTestrunner {

}
