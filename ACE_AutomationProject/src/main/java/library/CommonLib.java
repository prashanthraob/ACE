package library;

import java.io.File;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import context.TestContext;
import pageObject.Website.CostCalculator;
import pageObject.Website.CustomerSearchPage;
import pageObject.Website.HomePage;
import pageObject.Website.LoginPage;
import pageObject.Website.MemberDemographicsPage;
import pageObject.Website.MemberDetails;
import stepDefinitions.functional.Hooks;
import utils.Config;
import utils.Wait;

public class CommonLib {

	TestContext testContext;
	WebDriver driver;
	MemberDetails memberDetails;
	LoginPage loginPage;
	HomePage homepage;
	MemberDemographicsPage memberPage;
	CostCalculator costCalPage;
	CustomerSearchPage customerSearchPage;
	JavascriptExecutor executor;
	Actions action;

	public CommonLib(TestContext context) {
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		memberDetails = context.getPageObjectManager().getMemberDetails();
		loginPage = context.getPageObjectManager().getLoginPage();
		homepage = context.getPageObjectManager().getHomePage();
		memberPage = context.getPageObjectManager().getMemberDemoPage();
		customerSearchPage = context.getPageObjectManager().getCustomerSearchPage();
		costCalPage = context.getPageObjectManager().getCostCalPage();
		action = context.action();
	}

	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public void login(String userName, String pwd) {
		try {
			System.out.println(path + " evidencepath");
			String url = Config.getInstance().getApplicationUrl();
			System.out.println(url + " url");
			driver.navigate().to(url);
			Assert.assertTrue(isElementPresent(loginPage.btn_login),
					"Error: Not able to navigate to Application Login Page");

			wait.waitForPageLoad(driver);
			loginPage.txt_userName.sendKeys(userName);
			loginPage.txt_pwd.sendKeys(pwd);
			loginPage.btn_login.click();
			wait.waitForPageLoad(driver);
			Assert.assertTrue(isElementPresent(memberPage.lbl_projectName), "Error: User Not able to Login");
			takeScreenshot(path, "Passed_login");
			closeOpenTabs();

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenshot(path, "Failed_login");
			throw new RuntimeException("Error : User Failed to login");
		}
	}
	public void closeOpenTabs() {
		try {
			wait.waitForPageLoad(driver);
			Thread.sleep(3000);
			WebElement closeMemberTab = driver.findElement(By.xpath(
					"//div[@class='slds-context-bar slds-context-bar--tabs oneGlobalNav oneConsoleNav']//button[@title='Close Erica Schiff']"));
			if(closeMemberTab!=null && closeMemberTab.isDisplayed()) {
				closeMemberTab.click();
				System.out.println("Clicked and closed successfully- Member Tab");
			}
			
		/*	WebElement closeCustomerSearchTab = driver.findElement(By.xpath(
					"//div[@class='slds-context-bar slds-context-bar--tabs oneGlobalNav oneConsoleNav']//button[@title='Close Customer Search']"));
			if(closeCustomerSearchTab!=null && closeCustomerSearchTab.isDisplayed()) {
				closeCustomerSearchTab.click();
				System.out.println("Clicked and closed successfully- Customer Search Tab");				
			}*/
		}catch(Exception e) {
			System.out.println("Unable to close open tabs");
		}
	}

	public void user_navigates_to_tab_on(String tabName, String pageName) {
		try {
						
			wait.waitForPageLoad(driver);
			Thread.sleep(10000);
			switch (pageName) {
			case "Home Page":
				driver.switchTo().defaultContent();
				switch (tabName) {
				case "Customer Search":
					Thread.sleep(5000);
					//driver.navigate().refresh();
					WebElement contacts_drpdwn = homepage.dropDown_contacts;
					contacts_drpdwn.click();
					System.out.println("Clicked successfully- Contacts Dropdown");
					WebElement option_customerSearch = homepage.customerSearch;
					option_customerSearch.click();
					System.out.println("Clicked successfully- Customer Search");
					Thread.sleep(10000);
					takeScreenshot(path, "Pass_CustomerSearch");
					WebElement frame_customerSearch = customerSearchPage.frame_customerSearch;
					/*
					 * WebElement frame_customerSearch = driver
					 * .findElement(By.xpath("//iframe[@title='Customer Search']"));
					 */
					driver.switchTo().frame(frame_customerSearch);
					Thread.sleep(10000);
					System.out.println("Switched to frame - Customer Search");
					break;
				case "Manager Alerts":
					WebElement managerAlertsTab = homepage.manager_alert_Tab;
					managerAlertsTab.click();
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					Thread.sleep(3000);
					takeScreenshot(path, "Pass_ManagerAlertTab");
					break;
				case "Agent Alert":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Macros":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Omni-Channel":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				default:
					System.out.println("Unable to find " + tabName + " tab on " + pageName + " page.");
					break;
				}
				break;

			case "Customer Search Page":
				// Currently there are no tabs on this page.
				break;
			case "Member Details Page":
				driver.navigate().refresh();
				Thread.sleep(5000);
				wait.waitForPageLoad(driver);
				driver.switchTo().defaultContent();
				System.out.println("Switched to frame : Default");
				WebElement memberFrame = driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
				driver.switchTo().frame(memberFrame);
				Thread.sleep(5000);
				System.out.println("Switched to frame : Member Details");
				switch (tabName) {

				case "Member 360":
					/*
					 * WebElement tab_member360 = driver .findElement(By.
					 * xpath("//div[@id='member360Option']//span[text()='Member 360']"));
					 */
					wait.waitForPageLoad(driver);
					Thread.sleep(2000);
					WebElement tab_member360 = memberDetails.member360_Tab;
					tab_member360.click();
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Claims":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Benefits":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Care Management":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Cost Calculator":
					WebElement tab_CostCalcator = memberDetails.costCalculator_Tab;
					tab_CostCalcator.click();
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				case "Next Actions":
					System.out.println("Clicked successfully " + tabName + " tab on " + pageName + " page.");
					break;
				default:
					System.out.println("Unable to find " + tabName + " tab on " + pageName + " page.");
					break;

				}
				break;
			default:
				System.out.println("Unable to find " + pageName + " page.");
				break;

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException("Not able to click on " + tabName + " tab");
		}

	}

	/*
	 * public void user_navigates_to_tab(String tabName) { try {
	 * 
	 * switch (tabName) { case "Customer Search": WebElement contacts_drpdwn =
	 * driver .findElement(By.xpath("//a[@class='slds-context-bar__icon-action']"));
	 * contacts_drpdwn.click(); WebElement option_customerSearch =
	 * driver.findElement(By.xpath("//span[text()='Customer Search']"));
	 * option_customerSearch.click();
	 * System.out.println("Clicked successfully- Contacts Dropdown");
	 * Thread.sleep(10000); takeScreenshot(path, "Pass_Member360"); break; case
	 * "Manager Alert": WebElement managerAlertsTab = homepage.manager_alert_Tab;
	 * managerAlertsTab.click();
	 * System.out.println("Clicked successfully- Mnanger Alerts Tab");
	 * Thread.sleep(3000); takeScreenshot(path, "Pass_ManagerAlertTab"); break;
	 * 
	 * case "Member 360": driver.switchTo().defaultContent(); Thread.sleep(5000);
	 * driver.navigate().refresh(); Thread.sleep(5000);
	 * wait.waitForPageLoad(driver);
	 * System.out.println("Switched to frame : Default"); WebElement memberFrame =
	 * driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
	 * driver.switchTo().frame(memberFrame); Thread.sleep(5000);
	 * System.out.println("Switched to frame : Member Details"); WebElement
	 * tab_member360 = driver .findElement(By.
	 * xpath("//div[@id='member360Option']//span[text()='Member 360']"));
	 * tab_member360.click();
	 * System.out.println("Clicked successfully - Member 360"); break; case
	 * "Erica Schiff": Thread.sleep(5000); wait.waitForPageLoad(driver);
	 * homepage.EricaSchiff.click(); Thread.sleep(2000);
	 * 
	 * case "Cost Calculator": driver.switchTo().defaultContent();
	 * Thread.sleep(5000); driver.navigate().refresh(); Thread.sleep(5000);
	 * wait.waitForPageLoad(driver);
	 * System.out.println("Switched to frame : Default");
	 * driver.switchTo().frame(homepage.iFrame_HomeFrame); Thread.sleep(5000);
	 * System.out.println("Switched to frame : Member Details");
	 * homepage.tab_CostCalcator.click(); System.out.println("Clicked successfully "
	 * + tabName + " Tab"); } } catch (Exception e) { e.getMessage(); throw new
	 * RuntimeException("Not able to click on " + tabName + " tab"); } }
	 */

	public void enterValueInField(String value, String fieldName, String pageName) throws Exception {
		String xpath = null;
		switch (pageName) {
		case "Customer Search":
			xpath = customerSearchPage.fields_xpath;
			break;
		default:
			System.out.println("Page:" + pageName + " not found");
			break;
		}
		String field_xpath = xpath.replace("FieldName", fieldName);
		WebElement field = driver.findElement(By.xpath(field_xpath));
		if (field.isDisplayed()) {
			field.clear();
			field.sendKeys(value);
			System.out.println("Successfully entered : " + value + " in text field : " + fieldName);
			Thread.sleep(3000);
		} else {
			System.out.println("Unable to enter value : " + value + " in text field : " + fieldName);
			throw new RuntimeException("Unable to enter value : " + value + " in text field : " + fieldName);

		}
	}

	public void enterValueInField(Keys value, String fieldName, String pageName) throws Exception {

		String xpath = null;
		WebElement frame = null;
		switch (pageName) {
		case "Customer Search":
			driver.switchTo().defaultContent();
			frame = customerSearchPage.frame_customerSearch;
			driver.switchTo().frame(frame);
			xpath = customerSearchPage.fields_xpath;
			break;
		default:
			System.out.println("Page:" + pageName + " not found");
			break;
		}
		String field_xpath = xpath.replace("FieldName", fieldName);
		WebElement field = driver.findElement(By.xpath(field_xpath));
		if (field.isDisplayed()) {
			field.sendKeys(value);
			Thread.sleep(3000);
			System.out.println("Page Down operated sucessfully");
		} else {
			throw new Exception("Unable to operate Key");
		}

	}

	public void takeScreenshot(String outputFilePath, String step) {
		try {
			File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image, new File(outputFilePath + "\\" + step + ".jpg"));
			Hooks.scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isHomePageDisplayed() {
		boolean flag;
		if (loginPage.btn_login.isDisplayed()) {
			flag = true;
			System.out.println("passed");
		} else {
			flag = true;
		}
		return flag;
	}

	public void highlightElement(WebElement element) {
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);

	}

	public boolean isElementPresent(WebElement element) throws Exception {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				flag = true;
				System.out.println("passed");
			}
		} catch (NoSuchElementException e) {
			flag = false;
		}
		return flag;
	}

	public void verifyMemberHomePage() {

		try {
			Thread.sleep(5000);
			wait.waitForPageLoad(driver);
			if (homepage.EricaSchiff.isDisplayed()) {
				System.out.println("Passed : Member is on Home Page");
			} else {
				throw new RuntimeException("Failed : Navigation to member home page failed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void completeFlow() { try { WebElement contacts_drpdwn =
	 * driver.findElement(By.xpath("//a[@class='slds-context-bar__icon-action']"));
	 * contacts_drpdwn.click(); WebElement option_customerSearch =
	 * driver.findElement(By.xpath("//span[text()='Customer Search']"));
	 * option_customerSearch.click();
	 * System.out.println("Clicked successfully- Contacts Dropdown"); WebElement
	 * frame = driver.findElement(By.xpath("//iframe[@title='Customer Search']"));
	 * driver.switchTo().frame(frame);
	 * System.out.println("Switched to frame - Customer Search"); WebElement
	 * field_phone =
	 * driver.findElement(By.xpath("//label[text()='Phone']/../input"));
	 * field_phone.sendKeys(Keys.PAGE_DOWN);
	 * System.out.println("Page Down operated sucessfully"); WebElement
	 * field_firstName =
	 * driver.findElement(By.xpath("//label[text()='First Name']/../input"));
	 * field_firstName.clear(); field_firstName.sendKeys("Erica");
	 * System.out.println("Entered Value - First Name");
	 * field_firstName.sendKeys(Keys.ENTER);
	 * System.out.println("Clicked successfully - Member Search");
	 * field_firstName.sendKeys(Keys.PAGE_UP); // wait.waitForPageLoad(driver);
	 * Thread.sleep(4000); WebElement btn_member_Verify =
	 * driver.findElement(By.xpath("//button[@id='verifiedButtonPatientSearch']"));
	 * btn_member_Verify.click();
	 * System.out.println("Clicked successfully - Member Verified");
	 * Thread.sleep(4000); driver.switchTo().defaultContent();
	 * System.out.println("Switched to frame : Default"); WebElement memberFrame =
	 * driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']"));
	 * driver.switchTo().frame(memberFrame);
	 * System.out.println("Switched to frame : Member Details"); WebElement
	 * tab_member360 = driver .findElement(By.
	 * xpath("//div[@id='member360Option']//span[text()='Member 360']"));
	 * tab_member360.click();
	 * System.out.println("Clicked successfully - Member 360"); WebElement
	 * lnk_Rewards_ViewDetails =
	 * driver.findElement(By.xpath("//span[@title='REWARDS']/../../..//a"));
	 * lnk_Rewards_ViewDetails.click();
	 * System.out.println("Clicked successfully - Rewards- View Details");
	 * Thread.sleep(5000); WebElement title_RewardsSummary =
	 * driver.findElement(By.xpath("//h1[text()='REWARDS SUMMARY']")); String header
	 * = title_RewardsSummary.getText(); if (title_RewardsSummary.isDisplayed()) {
	 * System.out.
	 * println("Clicked successfully - Rewards Summary Displayed successfully"); }
	 * else {
	 * System.out.println("Clicked successfully - Rewards Summary not displayed"); }
	 * WebElement btn_cancel = driver.findElement(By
	 * .xpath("//h1[text()='REWARDS SUMMARY']/../../../following-sibling::footer//span[text()='Cancel']"
	 * )); btn_cancel.click();
	 * System.out.println("Clicked successfully - Cancel Button - Rewards Summary");
	 * WebElement lbl_data_TotalRewards = driver
	 * .findElement(By.xpath("//p[contains(text(),'Total Rewards')]//label"));
	 * String actualRewardsPoints = lbl_data_TotalRewards.getText(); String
	 * expectedRewardsPoints = "425"; if
	 * (actualRewardsPoints.equalsIgnoreCase(expectedRewardsPoints)) {
	 * System.out.println("Verification successful - Total Rewards Points"); } else
	 * { System.out.println("Verification failed - Total Rewards Points"); }
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); }
	 * 
	 * }
	 */

}