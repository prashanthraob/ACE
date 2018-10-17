package stepDefinitions.functional;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import library.CostCalculatorLib;

public class CostCalucatorSteps {

	private CostCalculatorLib costCalLib;
	WebDriver driver;

	public CostCalucatorSteps(CostCalculatorLib lib) {
		costCalLib = lib;
	}
	
	@And("^User enters \"([^\"]*)\" in \"([^\"]*)\" textbox.$")
    public void user_enters_in_textbox(String value, String textBox) throws Throwable {
		costCalLib.user_enters_in_textbox(value,textBox);
    }

	@Then("^User verifies the result set is displayed and contains Text \"([^\"]*)\"$")
	public void user_verifies_the_result_set_is_displayed_and_contains_Text(String value) throws Throwable {
		costCalLib.verifyCostCalResult(value);
	}

	@Then("^User verifies that recommended providers are displayed with change Provider link$")
	public void user_verifies_that_recommended_providers_are_displayed_with_change_Provider_link() throws Throwable {
		costCalLib.verifyChangeProviderResult();
	}
}
