package parallel;

import java.util.List;
import java.util.Map;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class AccountpageSteps {
	LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	
	@Given("User is logged in to the application")
	public void user_is_logged_in_to_the_application(DataTable dataTable) {
	    List<Map<String, String>> credentialList = dataTable.asMaps();
	    String username = credentialList.get(0).get("Username");
	    String password = credentialList.get(0).get("Password");
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountPage = loginpage.doLogin(username, password);  
	}

	@Given("User is on accounts page")
	public void user_is_on_accounts_page() {
	    String title = accountPage.getPageTitle();
	    System.out.println(title);
	}

	@Given("User gets the account section count")
	public void user_gets_the_account_section_count(DataTable dataTable) {
	   List<String> valuesinAccountSection = dataTable.asList();
	   System.out.println("Expected values: " + valuesinAccountSection);
	   List<String> actualList = accountPage.getAccountsSectionList();
	   System.out.println("Actual values: " + actualList);
	   Assert.assertTrue(actualList.containsAll(valuesinAccountSection));
	   
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
	    int n = accountPage.getAccountSectionCount();
	    Assert.assertTrue(n == int1);
	}

}
