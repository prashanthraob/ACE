package library;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import context.TestContext;
import pageObject.Website.CostCalculator;
import utils.Wait;

public class CostCalculatorLib {

	TestContext testContext;
	WebDriver driver;
	CommonLib library;
	Actions action;
	CostCalculator costCalPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public CostCalculatorLib(TestContext context, CommonLib lib) {
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		costCalPage = context.getPageObjectManager().getCostCalPage();
		library = lib;
		action = context.action();
	}

	public void verifyCostCalResult(String arg1) {
		try {
			wait.waitForPageLoad(driver);
			Thread.sleep(2000);
			if (costCalPage.hd_ResultHeader.isDisplayed()) {
				System.out.println("Passed: Cost Calculator Result Header is displayed");
				if (costCalPage.hd_ResultHeader.getText().equalsIgnoreCase(arg1)) {
					library.takeScreenshot(path, "Pass_CostCalculatorResults");
				}
			} else {
				System.out.println("Cost Calculator Result Header is not displayed");
			}
		} catch (Exception e) {
			e.getStackTrace();
			library.takeScreenshot(path, "Fail_CostCalculatorResults");
			throw new RuntimeException("Fail : Cost Calculator Result Header is not displayed");

		}
	}

	public void verifyChangeProviderResult() {
		try {
			Thread.sleep(3000);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			wait.waitForPageLoad(driver);
			Thread.sleep(3000);
			WebElement lnk = costCalPage.lnk_ChangeProvider;
			lnk.click();
			//action.moveToElement(costCalPage.lnk_ChangeProvider).click().perform();
			Thread.sleep(3000);
			if (costCalPage.Result_RecmndedProvider.isDisplayed()) {
				System.out.println("Passed : Recomended Providers are displayed on click on Change Provider link");
				library.takeScreenshot(path, "Pass_ChangeProviderResults");
			}
			costCalPage.icon_Close.click();
		} catch (Exception e) {
			e.getStackTrace();
			library.takeScreenshot(path, "Fail_ChangeProviderResults");
			throw new RuntimeException(
					"Fail : Recomended Providers are not displayed on click on Change Provider link");
		}

	}

	public void user_enters_in_textbox(String value, String textBox) {
		try {
			if(textBox.equalsIgnoreCase("Search")) {
			WebElement textBox_element =costCalPage.txtbox_costCal;
			textBox_element.clear();
			textBox_element.sendKeys(value);
			System.out.println("Successfully entered: "+value+" in textbox");			
			action.moveToElement(textBox_element).build().perform();
			WebElement viewTreatment = costCalPage.btn_viewTreatment;
			if(viewTreatment.isDisplayed()) {
				Thread.sleep(2000);
				viewTreatment.click();
				System.out.println("Successfully clicked: View Treatment");
			}else {
				System.out.println("Unable to click: View Treatment");
			}
			
			
			}	
			
		} catch (Exception e) {
		}

	}

}
