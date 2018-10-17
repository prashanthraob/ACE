package library;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import context.TestContext;
import pageObject.Website.ManagePCPPage;
import pageObject.Website.MemberDetails;
import utils.Wait;

public class ManagePCPLib {

	TestContext testContext;
	WebDriver driver;
	MemberDetails memberDetails;
	CommonLib library;
	Actions action;
	ManagePCPPage managePCPPage;
	String path = System.getProperty("EvidencePath");
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	Wait wait = new Wait();

	public ManagePCPLib(TestContext context, CommonLib lib) {
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		memberDetails = context.getPageObjectManager().getMemberDetails();
		library = lib;
		action = context.action();
		managePCPPage = context.getPageObjectManager().getManagePCPPage();
	}

	public void clickShowMore() {

		try {

			wait.waitForPageLoad(driver);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@height='2200' and @width='100%']")));

			action.moveToElement(memberDetails.lnk_seeMore).click().perform();

			wait.waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_ShowMore");
			throw new RuntimeException("Error : Failed to click Show more button");
		}
	}

	public void clickUpdatePCP() {

		try {

			wait.waitForPageLoad(driver);
			Thread.sleep(3000);
			action.moveToElement(managePCPPage.updatePCP_btn).click().perform();

			// executor.executeScript("arguments[0].click();",
			// managePCPPage.managePCPPage_btn);
			wait.waitForPageLoad(driver);

		}

		catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_managePCPPage");
			throw new RuntimeException("Error : Failed to click Update PCP button");
		}
	}

	public void clickSearchPCP() {

		try {

			wait.waitForPageLoad(driver);
			Thread.sleep(3000);

			WebElement srchBtn = managePCPPage.search_Btn;
			srchBtn.sendKeys(Keys.ENTER);
			// executor.executeScript("arguments[0].click();", srchBtn);

			wait.waitForPageLoad(driver);

		}

		catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_SearchPCP");
			throw new RuntimeException("Error : Failed to click Search button in Update PCP pop up");
		}
	}

	public void selectPCP() {

		try {
			Thread.sleep(2000);
			wait.waitForPageLoad(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			WebElement selctPCP = managePCPPage.selectPCP_lnk;
			selctPCP.click();
			wait.waitForPageLoad(driver);
			library.takeScreenshot(path, "Pass_SelectPCP");
			//executor.executeScript("arguments[0].click();", selctPCP);
			

		}

		catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_SelectPCP");
			throw new RuntimeException("Error : Failed to select PCP from PCP list in Update PCP pop up");
		}
	}

	public void verifyPCPSelection() {

		try {
			Thread.sleep(2000);
			Assert.assertTrue(library.isElementPresent(managePCPPage.updatePCP_popup),
					"Error: Not able to find Update PCP pop up");

			System.out.println(managePCPPage.updatePCP_popup.getText());
			wait.waitForPageLoad(driver);
		}

		catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_VerificationSelectPCP");
			throw new RuntimeException("Error : Failed to find Update PCP pop up");
		}
	}

	public void search_PCP(String value) {
		try {
			wait.waitForPageLoad(driver);
			WebElement wee = managePCPPage.providerId_txt;
			wee.sendKeys(value);
			Thread.sleep(5000);
			wait.waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_searchPCP");
			throw new RuntimeException("Error : User Failed to search with Provider ID");
		}
	}

	public void verify_SearchResult(String value) {
		try {
			wait.waitForPageLoad(driver);

			WebElement selctPCP = managePCPPage.selectPCP_lnk;
			String srchResult = selctPCP.getText();

			Thread.sleep(3000);
			Assert.assertTrue(srchResult.endsWith(value));
			// highlightElement(selctPCP);
			System.out.println(srchResult);

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_verify_SearchResult");
			throw new RuntimeException("Error : User Failed to verify search result");
		}
	}

	public void advanceSearch_PCP() {
		try {
			Thread.sleep(2000);
			wait.waitForPageLoad(driver);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(4000);
			WebElement providrgndr = driver.findElement(By.xpath("//div[@id='openAdvancedPanelButton']/.."));
			action.moveToElement(providrgndr).click();
			//WebElement providrgndr = managePCPPage.advanceSearch_btn;
			// action.moveToElement(providrgndr).click().perform();
			//executor.executeScript("arguments[0].click();", providrgndr);

			wait.waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_searchPCP");
			throw new RuntimeException("Error : User Failed to click on advance search");
		}
	}

	public void selectProviderGender(String gender) {
		try {
			wait.waitForPageLoad(driver);
			Thread.sleep(2000);
			WebElement providrgndr = managePCPPage.providerGender_drop;
			Select provdrGndr = new Select(providrgndr);
			// provdrGndr.selectByValue(gender);
			provdrGndr.selectByVisibleText(gender);
			wait.waitForPageLoad(driver);

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_verify_SearchResult");
			throw new RuntimeException("Error : User Failed to search with Provider Gender");
		}
	}

	public void UpdatePCP_Popup_verification(List<Map<String, String>> dataMap) throws InterruptedException {
		try {
			wait.waitForPageLoad(driver);
			WebElement reviewSeltn = managePCPPage.ReviewSelection_tag;
			String txt = reviewSeltn.getText();
			Assert.assertTrue(library.isElementPresent(reviewSeltn),
					"Error: User Not able to navigate Update PCP popup");
			library.takeScreenshot(path, "Update_PCP_PopUp");

			String pid = managePCPPage.ProviderId_tag.getText().toString().trim();

			if ((dataMap.get(0).get("ID:").toString().trim().equals(pid))) {
				// highlightElement(managePCPPage.ProviderId_tag);
			}
			Thread.sleep(5000);
			wait.waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_searchPCP");
			throw new RuntimeException("Error : User Failed to verify managePCPPage Popup");
		}
	}

	public void click_submitBtn() {
		try {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			wait.waitForPageLoad(driver);

			WebElement submitBtn = managePCPPage.submitPCP_btn;

			// action.moveToElement(submitBtn).click().perform();
			submitBtn.sendKeys(Keys.ENTER);

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Failed_verify_SearchResult");
			throw new RuntimeException("Error : User Failed to click on submit button");
		}
	}
}
