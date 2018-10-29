package stepDefinitions.functional;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.CreateCaseLib;

public class CreateCaseSteps {
	
	CreateCaseLib createCaseLib;
	
	public CreateCaseSteps(CreateCaseLib createLib) {
		createCaseLib = createLib;
	}
	
	@Given("^The user login into to application$")
	public void the_user_login_into_to_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
	    createCaseLib.login();
	    
	}

	@When("^The user naviagtes to contact search page and search contact \"([^\"]*)\"$")
	public void the_user_naviagtes_to_contact_search_page_and_search_contact(String user) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		createCaseLib.findContact(user);
	}

	@Then("^User contact \"([^\"]*)\" should be displayed in the search result$")
	public void user_contact_should_be_displayed_in_the_search_result(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		createCaseLib.verifyContactDetails(arg1);
	}

	@Then("^User clicks on contact$")
	public void user_clicks_on_contact() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createCaseLib.clicksOnContact();
	}

	@Then("^Contact details page should be opened$")
	public void contact_details_page_should_be_opened() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		createCaseLib.verifyContactDetailPage();
	}

	@When("^User fills the fields \"([^\"]*)\" in case template with values \"([^\"]*)\" and click on create case button$")
	public void user_fills_the_fields_in_case_template_with_values_and_click_on_create_case_button(String fields, String values) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		createCaseLib.fillCase(fields, values);
		createCaseLib.clicksOnCreateCase();

	}

	@Then("^Verify case is created successfully$")
	public void verify_case_is_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
		createCaseLib.verifyCaseCreated();
	}
	
	@When("^User fills the fields \"([^\"]*)\" in case template with values \"([^\"]*)\" and click on clear button$")
	public void user_fills_the_fields_in_case_template_with_values_and_click_on_clear_button(String fields, String values) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		createCaseLib.fillCase(fields, values);
		createCaseLib.clicksOnClear();
	}

	@Then("^Verify case template information is cleared successfully$")
	public void verify_case_template_information_is_cleared_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    createCaseLib.verifyCaseTemplatedCleared();
	}
	
	@Then("^Verify validation message displayed in case template$")
	public void verify_validation_message_displayed_in_case_template() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    createCaseLib.verifyErrorMessage();
	}
	
	@Then("^User clicks on created case and should verify \"([^\"]*)\" in the comments$")
	public void user_clicks_on_created_case_and_should_verify_in_the_comments(String caseText) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    createCaseLib.clickOnCase(caseText);
	}


}
