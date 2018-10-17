package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import context.TestContext;
import pageObject.Website.MemberDetails;
import utils.Wait;

public class Member360Lib {

	TestContext testContext;
	WebDriver driver;
	MemberDetails memberDetails;
	JavascriptExecutor executor;
	CommonLib library;
	Actions action;
	String path = System.getProperty("EvidencePath");
	public static String total_Rewards;
	Wait wait = new Wait();

	public Member360Lib(TestContext context, CommonLib lib) {
		testContext = context;
		executor = context.executor();
		driver = context.getWebDriverManager().getDriver();
		memberDetails = context.getPageObjectManager().getMemberDetails();
		library = lib;
		action = context.action();
	}

	public void user_clicks_on_under_section(String linkName, String sectionName) {
		try {
			Thread.sleep(5000);
			WebElement lnk_Rewards_ViewDetails = driver.findElement(By.xpath("//span[@title='REWARDS']/../../..//a"));
			lnk_Rewards_ViewDetails.click();
			System.out.println("Clicked successfully - Rewards- View Details");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getStackTrace();
			library.takeScreenshot(path, "Fail_RewardsViewDetailsLink");
			throw new RuntimeException("Rewards View Link in Unavailable");
		}
	}

	public void user_should_be_able_to_view_the_rewards_summary() {
		try {
			String heading = "REWARDS SUMMARY";
			Thread.sleep(15000);

			WebElement we = memberDetails.heading_RewardsSummary;
			System.out.println("REWARDS SUMMARY DISPLAYED");

			if (we.isDisplayed()) {
				String actual = we.getText();
				Assert.assertEquals(actual, heading);
				WebElement cancelBtn = driver.findElement(By.xpath("(//span[text()='Cancel'])[5]"));

				action.moveToElement(cancelBtn).click().perform();
				Thread.sleep(2000);
				library.takeScreenshot(path, "Pass_heading_RewardsSummary");
				System.out.println("Passed : Verfied Reward Summary details");
			} else {
				library.takeScreenshot(path, "Fail_heading_RewardsSummary");
				throw new RuntimeException("no Rewards Summary displayed");
			}

		} catch (Exception e) {
			library.takeScreenshot(path, "Fail_RewardsSummaryScreen");
			e.printStackTrace();
			throw new RuntimeException("Not able to verify Rewards Summary Screen");
		}
	}

	public void user_should_be_able_to_view_total_rewards_points_earned_on_member_details() {
		try {
			Thread.sleep(3000);
			String TotalRewardPoints = "425";
			WebElement we = memberDetails.lbl_totalRewardPoints;
			String actual = (we.getText().split(":"))[1].trim();
			Assert.assertEquals(actual, TotalRewardPoints);
			System.out.println("Passed : Total Rewards points validated");
			library.takeScreenshot(path, "Pass_totalRewardPoints");
		} catch (Exception e) {
			library.takeScreenshot(path, "Fail_totalRewardPoints");
		}
	}

	public void user_verifies_visibility_and_clicks_on_button(String linkName) {
		try {
			wait.waitForPageLoad(driver);
			driver.switchTo().defaultContent();
			System.out.println("Switched to frame : Default");
			WebElement memberFrame = driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
			driver.switchTo().frame(memberFrame);
			Thread.sleep(5000);
			System.out.println("Switched to frame : Member Details");
			Thread.sleep(3000);
			WebElement lnk_seeMore = memberDetails.lnk_seeMore;
			lnk_seeMore.click();
			wait.waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_ShowMore");
			throw new RuntimeException("Error : Failed to click Show more button");
		}
	}

	public void verifyMemberDemographicDetails(List<Map<String, String>> dataMap) {
		wait.waitForPageLoad(driver);
		String expectedLabelValue = null;
		String actualLabelValue = null;
		String xpath = null;
		WebElement label = null;
		List<String> fields = new ArrayList<String>();

		fields.add("Gender");
		fields.add("Date of Birth");
		fields.add("Email");
		fields.add("Primary Phone Number");
		fields.add("HICI");
		fields.add("HBX");
		fields.add("CIN");
		fields.add("SSN");
		fields.add("Alternate Phone");
		fields.add("Subscriber Home Address");
		fields.add("Mailing Address");
		fields.add("Spoken");
		fields.add("Written");
		for (String s : fields) {
			if (s.equalsIgnoreCase("Email")) {
				xpath = memberDetails.xpath.replace("fieldName", s).replace("/..//span", "/..//div//label");
			} else {
				xpath = memberDetails.xpath.replace("fieldName", s);
			}
			label = driver.findElement(By.xpath(xpath));
			actualLabelValue = label.getText();
			if (actualLabelValue.equalsIgnoreCase("")) {
				actualLabelValue = "null";
			}
			expectedLabelValue = dataMap.get(0).get(s);
			Assert.assertEquals(actualLabelValue, expectedLabelValue);
			System.out.println("Successfully validated : " + s);

		}

	}

	public void user_verifies_the_buttons_under_personal_information_section(List<Map<String, String>> dataMap) {

		String s = null;
		WebElement btn_validate = null;
		for (int i = 1; i <= 4; i++) {
			s = dataMap.get(0).get("Button " + i);
			switch (s) {
			case "Update Information":
				btn_validate = memberDetails.btn_UpdateInformation;
				break;
			case "Update PCP":
				btn_validate = memberDetails.btn_UpdatePCP;
				break;
			case "Request Id Card":
				btn_validate = memberDetails.btn_RequestIdCard;
				break;
			case "Find A Doctor":
				btn_validate = memberDetails.btn_FindADoctor;
				break;
			default:
				System.out.println("Button " + s + " not found in Member details section.");
			}
			if (btn_validate.isDisplayed()) {
				System.out.println("Button " + btn_validate.getText() + " validated successfully.");
			}
		}

		// TODO Auto-generated method stub

	}

	public void user_clicks_on_button(String buttonName) {
		wait.waitForPageLoad(driver);

		driver.switchTo().defaultContent();
		System.out.println("Switched to frame : Default");
		WebElement memberFrame = driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
		driver.switchTo().frame(memberFrame);

		WebElement button = null;
		try {
			Thread.sleep(5000);
			switch (buttonName) {

			case "Update Information":
				button = memberDetails.btn_UpdateInformation;
				break;
			case "Update PCP":
				button = memberDetails.btn_UpdatePCP;
				break;
			case "Request Id Card":
				button = memberDetails.btn_RequestIdCard;
				break;
			case "Find a Doctor":
				button = driver.findElement(By.xpath("//span[contains(text(),'Find a Doctor')]/.."));

				break;
			default:
				System.out.println("Unable to locate button " + buttonName);
			}
			if (button != null) {
				button.click();
				System.out.println("Clicked successfully : " + buttonName);
				Thread.sleep(2000);
			} else {
				System.out.println("Unable to click the button :" + buttonName);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void user_is_able_to_see_list_of_doctors_in_popup() {
		try {
			driver.switchTo().defaultContent();
			System.out.println("Switched to frame : Default");
			WebElement memberFrame = driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
			driver.switchTo().frame(memberFrame);

			Thread.sleep(5000);
			WebElement results = memberDetails.Lbl_Resuls_findADoctor;
			if (results.isDisplayed()) {
				String resultsCount = (results.getText().split(" ")[1]).replace(")", "");
				if (resultsCount != "0") {
					System.out.println("Doctors list is displayed with " + resultsCount + " rows");
				} else {
					System.out.println("Doctors list is displayed with " + resultsCount + " rows");
				}
			} else {
				System.out.println("Not able to show Results for list of Doctors.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
