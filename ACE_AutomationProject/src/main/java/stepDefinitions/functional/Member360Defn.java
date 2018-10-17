package stepDefinitions.functional;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import library.Member360Lib;

public class Member360Defn {

	private Member360Lib memberLib;
	WebDriver driver;

	public Member360Defn(Member360Lib memberLibrary) {
		memberLib = memberLibrary;
	}

	@And("^User clicks on \"([^\"]*)\" under \"([^\"]*)\" section.$")
	public void user_clicks_on_under_section(String linkName, String sectionName) {
		memberLib.user_clicks_on_under_section(linkName, sectionName);
	}

	@Then("^User should be able to view the rewards summary.$")
	public void user_should_be_able_to_view_the_rewards_summary() {
		memberLib.user_should_be_able_to_view_the_rewards_summary();
	}

	@And("^User should be able to view total rewards points earned on Member Details page.$")
	public void user_should_be_able_to_view_total_rewards_points_earned_on_member_details_page() {
		memberLib.user_should_be_able_to_view_total_rewards_points_earned_on_member_details();
	}

	@And("^User verifies visibility and clicks on \"([^\"]*)\" button.$")
	public void user_verifies_visibility_and_clicks_on_button(String linkName) throws Throwable {
		memberLib.user_verifies_visibility_and_clicks_on_button(linkName);
	}

	@Then("^User verifies Member Personal Information.$")
	public void user_verifies_member_personal_information(DataTable value) throws Throwable {
		List<Map<String, String>> dataMap = value.asMaps(String.class, String.class);
		memberLib.verifyMemberDemographicDetails(dataMap);
	}

	@And("^User verifies the buttons under Personal Information section.$")
	public void user_verifies_the_buttons_under_personal_information_section(DataTable value) throws Throwable {
		List<Map<String, String>> dataMap = value.asMaps(String.class, String.class);
		memberLib.user_verifies_the_buttons_under_personal_information_section(dataMap);
	}

	@And("^User clicks on \"([^\"]*)\" button.$")
	public void user_clicks_on_button(String buttonName) throws Throwable {
		memberLib.user_clicks_on_button(buttonName);
	}

	@Then("^User is able to see list of doctors in popup.$")
	public void user_is_able_to_see_list_of_doctors_in_popup() throws Throwable {
		memberLib.user_is_able_to_see_list_of_doctors_in_popup();
	}

}
