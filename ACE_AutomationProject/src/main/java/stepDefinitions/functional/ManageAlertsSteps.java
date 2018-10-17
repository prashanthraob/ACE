package stepDefinitions.functional;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.ManageAlert_Lib;

public class ManageAlertsSteps {

	ManageAlert_Lib manageAlertlib;

	public ManageAlertsSteps(ManageAlert_Lib lib) {
		manageAlertlib = lib;
	}

	@When("^User clicks on Manager Alert tab and creates an Alert with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_clicks_on_Manager_Alert_tab_and_creates_an_Alert_with_and_and_and_and(String alertName,
			String type, String desc, String pod, String priority) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.clickManagerAlerttab(alertName, type, desc, pod, priority);
	}

	@Then("^User verifies that an Alert is created successfully \"([^\"]*)\"$")
	public void user_verifies_that_an_Alert_is_created_successfully(String name) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.alertcreated(name);
	}

	@When("^User navigates to Created alert section and deletes an Alert$")
	public void user_navigates_to_Created_alert_section_and_deletes_an_Alert() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.navigate_created_alert();
	}

	@Then("^User verifies that an Alert is deletd$")
	public void user_verifies_that_an_Alert_is_deletd() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.deleted_alert();
	}

	@When("^User clicks on an alert and changes the alert status to \"([^\"]*)\"$")
	public void user_clicks_on_an_alert_and_changes_the_alert_status_to(String status) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.changealertstatus(status);
	}

	@Then("^User verifies that the alert status has changed to \"([^\"]*)\"$")
	public void user_verifies_that_the_alert_status_has_changed_to(String status) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.verifyalertstatus(status);
	}

	@When("^User clicks on an alert and verifies alert tab details")
	public void user_clicks_on_an_alert_and_verifies_alert_tab_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.verifyAlertTableDetails();
	}

	@Then("^User verifies if the current date is in between start date and end date")
	public void user_verifies_if_current_date_is_in_between_start_date_and_end_date() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		manageAlertlib.verifySystemDate();
	}

}
