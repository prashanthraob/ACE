package stepDefinitions.functional;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import library.PlanAndBenefitsLib;

public class PlanAndBenefitsSteps {

	private PlanAndBenefitsLib planAndBenefitsLib;
	WebDriver driver;

	public PlanAndBenefitsSteps(PlanAndBenefitsLib planAndBenefitsLibrary) {
		planAndBenefitsLib = planAndBenefitsLibrary;
	}

	@Then("^User verifies Plan details\\.$")
	public void user_verifies_Plan_details(DataTable arg1) throws Throwable {
		List<List<String>> data = arg1.raw();
		System.out.println(arg1);
		/*List<String> dataMap = arg1.asList(String.class);
		System.out.println(arg1(0));*/
		planAndBenefitsLib.verifyPlanDetails(data);
	}

	@Then("^User verifies Benefit details.$")
	public void user_verifies_Benefit_details() throws Throwable {
		planAndBenefitsLib.verifyBenefitDetails();
	}

}
