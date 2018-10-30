package library;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import context.TestContext;
import pageObject.Website.PlanAndBenefitsPage;

public class PlanAndBenefitsLib {
	
	TestContext testContext;
	WebDriver driver;
	PlanAndBenefitsPage planAndBenefitsPage;
	CommonLib library;
	Actions action;
	
	
	public PlanAndBenefitsLib(TestContext context, CommonLib lib) {
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		library = lib;
		action = context.action();
		planAndBenefitsPage= context.getPageObjectManager().getPlanAndBenefitsPage();
	}


	public void verifyPlanDetails(List<List<String>> data) {
		try {
			if(library.isElementPresent(planAndBenefitsPage.hd_PlanDetails)) {
			    String xpath = null;
			    WebElement label = null;
			    List<String> fields = new ArrayList<String>();

			    fields.add("Plan Type");
			    fields.add("Effective Date");
			    fields.add("Termination Date");
			    fields.add("Re-certification Date");
			    fields.add("Enrollment County");
			    fields.add("Effectuated Date");
			    fields.add("Reason Description");
			    
			    for (String s : fields) {
			                 xpath = planAndBenefitsPage.xpath.replace("fieldName", s);
			                 label = driver.findElement(By.xpath(xpath));
			                 if(library.isElementPresent(label)) {
			                	 System.out.println("Verified : "+ s);
			          }
			           }
		} }catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fail : Not able to verify Plan Detail Fields");
		}   }
	public void verifyBenefitDetails() {
		try {
			if(library.isElementPresent(planAndBenefitsPage.hd_BenefitDetails)) {
				System.out.println("Benefit Details Section is displayed");
				Assert.assertTrue(library.isElementPresent(planAndBenefitsPage.hd_copayInf), "Fail: Copay Information section is not displayed");
				Assert.assertTrue(library.isElementPresent(planAndBenefitsPage.hd_claimedBenefits), "Fail: Claimed Benefit section is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException ("Fail: Not Able to verify Benefits Section");
		}
	}
}
