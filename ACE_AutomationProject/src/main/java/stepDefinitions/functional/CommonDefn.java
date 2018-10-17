package stepDefinitions.functional;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.CommonLib;

public class CommonDefn {
	CommonLib commonLib;

	public CommonDefn(CommonLib comLib) {
		commonLib = comLib;
	}

	@Given("^User logins in to member connect Application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logins_in_to_member_connect_Application_with_and(String userName, String password)
			throws Throwable {
		commonLib.login(userName, password);
	}

	/*@When("^User navigates to \"([^\"]*)\" tab.$")
	public void user_navigates_to_tab(String tabName) {
		commonLib.user_navigates_to_tab(tabName);
	}*/

	@When("^User navigates to \"([^\"]*)\" tab on \"([^\"]*)\".$")
    public void user_navigates_to_tab_on(String tabName, String pageName) throws Throwable {
		commonLib.user_navigates_to_tab_on(tabName,pageName);
    }
	/*
	@When("^User enters \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void user_enters_in_field(String value, String fieldName) throws Throwable {
		commonLib.searchMember(value, fieldName);
	}

	@Then("^selected Member details are displayed \"([^\"]*)\"$")
	public void selected_member_details_are_displayed(String value) throws Throwable {
		commonLib.verifySelectedMemberDisplayed(value);
	}

	@Then("^Agent clicks on Verify button$")
	public void agent_clicks_on_verify_button() throws Throwable {
		commonLib.clickVerifybutton();
	}*/

	@Then("^User is on Member Home Page$")
	public void user_is_on_Member_Home_Page() throws Throwable {
		commonLib.verifyMemberHomePage();
	}

	/*@When("^user validates complete flow  $")
	public void user_validates_complete_flow() throws Throwable {
		commonLib.completeFlow();
	}*/
}
