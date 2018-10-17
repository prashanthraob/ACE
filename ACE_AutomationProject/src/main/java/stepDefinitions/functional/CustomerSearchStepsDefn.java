package stepDefinitions.functional;

import cucumber.api.java.en.And;
import library.CustomerSearchLib;

public class CustomerSearchStepsDefn {
	CustomerSearchLib customerSearchLib;

	public CustomerSearchStepsDefn(CustomerSearchLib custrSrchLib) {
		customerSearchLib = custrSrchLib;
	}

	@And("^User searches for member using field \"([^\"]*)\" as \"([^\"]*)\".$")
	public void user_searches_for_member_using_field_as(String fieldName, String value) throws Throwable {
		customerSearchLib.user_searches_for_member_using_field_as(value, fieldName);
	}

	@And("^User verifies member as \"([^\"]*)\".$")
	public void user_verifies_member_as(String memberName) throws Throwable {
		customerSearchLib.user_verifies_member_as(memberName);
	}
	
}
