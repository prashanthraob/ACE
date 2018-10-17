package stepDefinitions.functional;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import library.CommonLib;
import library.ManagePCPLib;

public class ManagePCPSteps {

	CommonLib commonLib;
	ManagePCPLib managePCPLibrary;

	public ManagePCPSteps(ManagePCPLib managePCPLib) {
		managePCPLibrary = managePCPLib;
	}

	@When("^User clicks on Show more button$")
	public void user_clicks_on_Show_more_button() {
		managePCPLibrary.clickShowMore();
	}

	@When("^User clicks on Update PCP button$")
	public void user_clicks_on_UpdatePCP_button() {
		managePCPLibrary.clickUpdatePCP();
	}

	@When("^User clicks on search button$")
	public void user_clicks_on_search_button() {
		managePCPLibrary.clickSearchPCP();
	}

	@When("^User Clicks on Provider Name$")
	public void user_Clicks_on_Provider_Name() {
		managePCPLibrary.selectPCP();
	}

	@Then("^User verifies Update PCP popup$")
	public void user_verifies_Update_PCP_popup() {
		managePCPLibrary.verifyPCPSelection();
	}

	@When("^User searches Provider Id with \"([^\"]*)\"$")
	public void user_clicks_on_Show_more_button(String idValue) throws Throwable {
		managePCPLibrary.search_PCP(idValue);
	}

	@Then("^User verifies search results with Provider Id \"([^\"]*)\"$")
	public void user_verifies_Update_PCP_popup(String idValue) throws Throwable {
		managePCPLibrary.verify_SearchResult(idValue);
	}

	@When("^User clicks on Advance Search Criteria button$")
	public void advanceSearch_PCP() {
		managePCPLibrary.advanceSearch_PCP();
	}

	@When("^User selects provider gender with \"([^\"]*)\"$")
	public void user_clicks_on_UpdatePCP_button(String value) throws Throwable {
		managePCPLibrary.selectProviderGender(value);
	}

	@When("^User verifies Update PCP popup details below details$")
	public void user_verifies_Update_PCP_popup_details_below_details(DataTable value) throws Throwable {
		List<Map<String, String>> dataMap = value.asMaps(String.class, String.class);
		managePCPLibrary.UpdatePCP_Popup_verification(dataMap);
	}

	@Then("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		managePCPLibrary.click_submitBtn();
	}
}
