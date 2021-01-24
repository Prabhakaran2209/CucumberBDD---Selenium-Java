package parallel;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	String title;
	String loginpagetitle;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("Page title is "+ title);
	}

	@When("Page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		 Assert.assertTrue(title.contains(expectedtitle));
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	   Assert.assertTrue(loginpage.isFrgotPasswordlinkExist());
	}

	@Given("User enters {string} on the username field")
	public void user_enters_on_the_username_field(String username) {
	    loginpage.enterUserName(username);
	}

	@Given("User enters {string} on the password field")
	public void user_enters_on_the_password_field(String password) {
	    loginpage.enterPassword(password);
	}

	@Given("User clicks on login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickLogin();
	}

}
