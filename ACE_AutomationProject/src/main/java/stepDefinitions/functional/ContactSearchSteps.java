package stepDefinitions.functional;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.ContactSearchLib;

public class ContactSearchSteps {
	
	ContactSearchLib contactSearchLib;
	
	public ContactSearchSteps(ContactSearchLib contactLib) {
		contactSearchLib = contactLib;
	}
	
	@Given("^The user logins into the application$")
	public void the_user_logins_into_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		contactSearchLib.login();
	}

	@When("^The user navigates to the contact search page$")
	public void the_user_navigates_to_the_contact_search_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^New button should be disabled before first search$")
	public void new_button_should_be_disabled_before_first_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	

	@When("^User searches with the first name and last name and clicks on search$")
	public void user_searches_with_the_first_name_and_last_name_and_clicks_on_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^New button should be enabled and new contact should be created$")
	public void new_button_should_be_enabled_and_new_contact_should_be_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^User provides the first name and last name and clicks search$")
	public void user_provides_the_first_name_and_last_name_and_clicks_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^User should verify the contacts displayed$")
	public void user_should_verify_the_contacts_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^User provided first name and clicks on Search$")
	public void user_provided_first_name_and_clicks_on_Search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^User should be able to verify the error message$")
	public void user_should_be_able_to_verify_the_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

}
