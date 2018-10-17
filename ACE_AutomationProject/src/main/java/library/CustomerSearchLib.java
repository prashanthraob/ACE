package library;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import context.TestContext;
import pageObject.Website.CostCalculator;
import pageObject.Website.CustomerSearchPage;
import utils.Wait;

public class CustomerSearchLib {

	TestContext testContext;
	WebDriver driver;
	CommonLib library;
	Actions action;
	CostCalculator costCalPage;
	CustomerSearchPage customerSearchPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public CustomerSearchLib(TestContext context, CommonLib lib) {

		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		costCalPage = context.getPageObjectManager().getCostCalPage();
		customerSearchPage = context.getPageObjectManager().getCustomerSearchPage();
		library = lib;
		action = context.action();
	}

	public void searchMember(String value, String field) {

		try {
			switch (field) {

			case "First Name":
				WebElement frame = driver.findElement(By.xpath("//iframe[@title='Customer Search']"));
				driver.switchTo().frame(frame);
				Thread.sleep(10000);
				System.out.println("Switched to frame - Customer Search");
				WebElement field_phone = driver.findElement(By.xpath("//label[text()='Phone']/../input"));
				field_phone.sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(3000);
				System.out.println("Page Down operated sucessfully"); // WebElement
				WebElement field_firstName = driver.findElement(By.xpath("//label[text()='First Name']/../input"));
				field_firstName.clear();
				field_firstName.sendKeys("Erica");
				System.out.println("Entered Value - First Name");
				field_firstName.sendKeys(Keys.ENTER);
				System.out.println("Clicked successfully - Member Search");
				field_firstName.sendKeys(Keys.PAGE_UP);
				break;

			case "Member Id":
				WebElement memId = customerSearchPage.txt_memberId;
				memId.sendKeys(value);
				break;

			case "Cost Calculator Text box":
				costCalPage.txtbox_costCal.sendKeys(value);
				costCalPage.btn_viewTreatment.click();
				System.out.println("Clicked View Treatment button");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.getStackTrace();
			throw new RuntimeException("Error : Not able Enter search value in " + field);
		}
	}

	public void verifySelectedMemberDisplayed(String value) {
		try {
			wait.waitForPageLoad(driver);
			action.sendKeys(Keys.PAGE_UP).build().perform();
			List<WebElement> details = driver.findElements(By.xpath("//table[@id='DataTables_Table_0']//td"));
			List<String> detailsValue = new ArrayList<String>();
			for (WebElement e : details) {
				detailsValue.add(e.getText());
			}
			String memberName = (detailsValue.get(0).split(" "))[2];
			if (memberName.equalsIgnoreCase(value)) {
				library.takeScreenshot(path, "VerifySelectedMember");
			} else {
				library.takeScreenshot(path, "VerifySelectedMember");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error: Not able to verify results after member selection");
		}
	}

	public void clickVerifybutton() {
		try {

			Thread.sleep(5000);
			if (library.isElementPresent(customerSearchPage.btn_verifyMember)) {
				//action.sendKeys(Keys.PAGE_UP).build().perform();
				customerSearchPage.btn_verifyMember.click();
				System.out.println("Clicked successfully - Member Verified");
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error: Not able to click verify button");
		}
	}

	public void user_searches_for_member_using_field_as(String value, String fieldName) {
		try {
			
			library.enterValueInField(Keys.PAGE_DOWN, "Phone", "Customer Search");
			library.enterValueInField(value, fieldName, "Customer Search");
			library.enterValueInField(Keys.ENTER, fieldName, "Customer Search");
			library.enterValueInField(Keys.PAGE_UP, fieldName, "Customer Search");
			wait.waitForPageLoad(driver);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Unable to search member");
			System.out.println(e.getMessage());
		}

	}

	public void user_verifies_member_as(String memberName) {
		try {
			verifySelectedMemberDisplayed(memberName);
			clickVerifybutton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
