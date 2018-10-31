package stepDefinitions.functional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.AppLauncherLib;
import library.ContactSearchLib;
import library.HomeLib;

public class ContactSearchSteps {
	
	ContactSearchLib contactSearchLib;
	AppLauncherLib appLauncherLib;
	HomeLib homeLib;
	
	public ContactSearchSteps(ContactSearchLib contactLib, AppLauncherLib appLib, HomeLib homLib) {
		contactSearchLib = contactLib;
		appLauncherLib = appLib;
		homeLib = homLib;
	}
	
	@Given("^User logins into the application$")
	public void the_user_logins_into_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		contactSearchLib.login();
	}

	@When("^User navigates to the contact search page$")
	public void user_navigates_to_the_contact_search_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.clickContactSearchTab();
	}

	@Then("^New button should be disabled before first search$")
	public void new_button_should_be_disabled_before_first_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.verifyNewContactDisabled();
	}

	@When("^User enters the First Name and Last Name and clicks on Search$")
	public void user_enters_the_First_Name_and_Last_Name_and_clicks_on_Search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.enterFirstAndLastName("sai shankar", "devarasetty");
	    contactSearchLib.clickSearchButton();
	}

	@Then("^New button should be enabled$")
	public void new_button_should_be_enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.verifyNewContactEnabled();
	}

	@When("^The user clicks on New contact button$")
	public void the_user_clicks_on_New_contact_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.clickNewContactButton();
	}

	@Then("^User enters the First Name and Last Name and clicks on Add Contact$")
	public void user_enters_the_First_Name_and_Last_Name_and_clicks_on_Add_Contact() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		contactSearchLib.enterFirstAndLastName("Sai Shankar", "Devarasetty");
		contactSearchLib.clickAddContactButton();
	}

	@Then("^User should be successfully created$")
	public void user_should_be_successfully_created() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	

	@Then("^User should verify the contacts displayed with \"([^\"]*)\"$")
	public void user_should_verify_the_contacts_displayed(String validation) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.verifyContactsDisplayed("Sai Shankar", "Devarasetty", validation);
	}
	
	@Then("^User is in the contact search page$")
	public void user_is_in_the_contact_search_page() throws Throwable{

	}

	@When("^User enters the First Name and clicks on Search$")
	public void user_enters_the_First_Name_and_clicks_on_Search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.enterOnlyFirstName("sai shankar");
	    contactSearchLib.clickSearchButton();
	}

	@Then("^User should be able to verify the error message$")
	public void user_should_be_able_to_verify_the_error_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.verifyLastNameError();
	}
	
	@Given("^User logins into the application as Sales Console$")
	public void user_logins_into_the_application_as_Sales_Console() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		contactSearchLib.login();
		appLauncherLib.clickAppLauncherIcon();
		appLauncherLib.clickSalesConsole();
		Thread.sleep(15000);
	}

	@When("^User navigates to the contact search page using dropdown$")
	public void user_navigates_to_the_contact_search_page_using_dropdown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homeLib.clickDropDown();
	    homeLib.clickContactSearchFromDropDown();
	}


	@Then("^User should be able to see welcome test$")
	public void user_should_be_able_to_see_welcome_test() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    contactSearchLib.verifyWelcomeText();
	}
}
