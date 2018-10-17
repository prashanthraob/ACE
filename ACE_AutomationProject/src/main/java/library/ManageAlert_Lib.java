package library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import context.TestContext;
import pageObject.Website.ManageAlertPage;
import pageObject.Website.MemberDetails;
import utils.Wait;

public class ManageAlert_Lib {

	TestContext testContext;
	WebDriver driver;
	MemberDetails memberDetails;
	CommonLib library;
	Actions action;
	ManageAlertPage manageAlertPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public ManageAlert_Lib(TestContext context, CommonLib lib) {
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		memberDetails = context.getPageObjectManager().getMemberDetails();
		library = lib;
		action = context.action();
		manageAlertPage = context.getPageObjectManager().getManageAlertPage();
	}

	public void clickManagerAlerttab(String alertName, String type, String desc, String pod, String priority) {
		try {
			wait.waitForPageLoad(driver);
			// driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id
			// ,'vfFrameId')]")));
			wait.waitForPageLoad(driver);
			Thread.sleep(4000);
			manageAlertPage.manager_alert.click();
			WebElement alert_div = driver
					.findElement(By.xpath("//div[@class='slds-utility-panel__body' and @style='height: 507px;']"));
			if (alert_div.isDisplayed()) {
				library.takeScreenshot(path, "Alert Pop up is displaying");
				System.out.println("Alert Pop up is displaying");
			} else {
				System.out.println("Alert Pop up is not displaying");
			}

			manageAlertPage.alret_name.sendKeys(alertName);

			Select alr_typ = new Select(manageAlertPage.alert_type);
			alr_typ.selectByValue(type);

			manageAlertPage.alert_desc.sendKeys(desc);

			Select alr_pod = new Select(manageAlertPage.alert_pod);
			// List<WebElement> abc=alr_pod.getOptions();
			alr_pod.selectByVisibleText(pod);
			// alr_pod.selectByValue(pod);
			// System.out.println("Selected");

			Select alr_prior = new Select(manageAlertPage.alert_prio);
			alr_prior.selectByValue(priority);

			manageAlertPage.alert_sdate_cal.click();
			manageAlertPage.alert_start_date.click();
			manageAlertPage.alert_edate_cal.click();
			manageAlertPage.alert_next_month.click();
			manageAlertPage.alert_end_date.click();

			Thread.sleep(4000);
			library.takeScreenshot(path, "Alert with all details entered");
			System.out.println("Alert created successfully");

			manageAlertPage.save_btn.click();
			Thread.sleep(3000);
			library.takeScreenshot(path, "Alert created with all details entered");

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Unable to create New Alert");
			// throw new RuntimeException("Error : Couldn't create a new Alert");
		}

	}

	public void alertcreated(String alertname) {
		try {

			manageAlertPage.created_alert.click();
			// List<WebElement> list1=driver.findElements(By.xpath("//*[contains(text(),'" +
			// TestAlert123 + "')]"));
			// Assert.assertTrue(list1.size() > 0, "Text not found!");
			// Assert.IsTrue(driver.getPageSource().contains(arg1));
			boolean txt = driver.getPageSource().contains(alertname);
			if (txt == true) {
				library.takeScreenshot(path, "Created Alert name");
				System.out.println("The created alert name is displaying under Created Alert tab section");
			} else {
				System.out.println("The created alert name is not displaying under Created Alert tab section");
			}

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Created Alert is not showing");
			// throw new RuntimeException("Error : Couldn't create a new Alert");
		}

	}

	public void navigate_created_alert() {
		try {
			wait.waitForPageLoad(driver);
			wait.waitForPageLoad(driver);
			Thread.sleep(4000);
			manageAlertPage.manager_alert.click();
			WebElement alert_div = driver
					.findElement(By.xpath("//div[@class='slds-utility-panel__body' and @style='height: 507px;']"));
			if (alert_div.isDisplayed()) {
				library.takeScreenshot(path, "Alert Pop up is displaying");
				System.out.println("Alert Pop up is displaying");
			} else {
				System.out.println("Alert Pop up is not displaying");
			}
			manageAlertPage.created_alert.click();
			Thread.sleep(3000);
			library.takeScreenshot(path, "Created Alert Section");
			String alrt_txt = manageAlertPage.fst_alrt_nme.getText();

			List<WebElement> before_dlt = driver.findElements(By.xpath(
					"//strong[contains(text(),'Active Alert') or contains(text(),'Upcoming Alert')]//..//..//table//tr[not(contains(@class,'slds-text-title_caps'))]"));
			int bfr_count = before_dlt.size();
			System.out.println(bfr_count);
			Actions act = new Actions(driver);
			act.moveToElement(manageAlertPage.fst_dlt_icn);
			manageAlertPage.fst_dlt_icn.click();

			library.takeScreenshot(path, "'" + alrt_txt + "' " + "Alert deleted");

			List<WebElement> after_dlt = driver.findElements(By.xpath(
					"//strong[contains(text(),'Active Alert') or contains(text(),'Upcoming Alert')]//..//..//table//tr[not(contains(@class,'slds-text-title_caps'))]"));
			int aftr_count = after_dlt.size();
			System.out.println(aftr_count);

			if (aftr_count == bfr_count - 1) {
				System.out.println("The alert " + alrt_txt + "deleted");
				System.out.println("Previous alert count was" + bfr_count);
				System.out.println("Current alert count is" + aftr_count);
			} else {
				System.out.println("Alert is not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Alert is not deleted");
		}
	}

	public void deleted_alert() {
		try {
			/*
			 * WebElement tabl_actv=driver.findElement(By.
			 * xpath("//strong[contains(text(),'Active Alert')]//..//..//table"));
			 * WebElement tabl_upcmng=driver.findElement(By.
			 * xpath("//strong[contains(text(),'Upcoming Alert')]//..//..//table")); String
			 * inrhtml1=tabl_actv.getAttribute("innerHTML"); String
			 * inrhtml2=tabl_upcmng.getAttribute("innerHTML");
			 * 
			 * if (!(inrhtml1.contains(alrt_txt)) && !(inrhtml2.contains(alrt_txt))) {
			 * takeScreenshot(path, "'"+alrt_txt+"' "+"Alert deleted successfully");
			 * System.out.println("Alert deleted successfully");
			 * 
			 * } else { System.out.println("Alert still exists"); }
			 */
			System.out.println("Alert deleted successfuly");

		} catch (Exception e) {
			e.printStackTrace();
			library.takeScreenshot(path, "Alert is not deleted");
		}

	}

	public void changealertstatus(String sts) {
		try {
			wait.waitForPageLoad(driver);
			wait.waitForPageLoad(driver);
			Thread.sleep(4000);
			manageAlertPage.manager_alert.click();
			WebElement alert_div = driver
					.findElement(By.xpath("//div[@class='slds-utility-panel__body' and @style='height: 507px;']"));
			if (alert_div.isDisplayed()) {
				library.takeScreenshot(path, "Alert Pop up is displaying");
				System.out.println("Alert Pop up is displaying");
			} else {
				System.out.println("Alert Pop up is not displaying");
			}
			manageAlertPage.created_alert.click();
			Thread.sleep(4000);
			// takeScreenshot(path, "Created Alert Section");
			// action.sendKeys(Keys.PAGE_DOWN);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					manageAlertPage.dactv_alrt_name);
			manageAlertPage.dactv_alrt_name.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", manageAlertPage.minimize);
			manageAlertPage.minimize.click();

			Thread.sleep(5000);
			wait.waitForPageLoad(driver);
			/*
			 * Robot robot=new Robot(); for(int i=0;i<9; i++) {
			 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN); }
			 */

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", we);
			WebElement alertName = manageAlertPage.alrt_edt_icn;
			alertName.sendKeys(Keys.PAGE_DOWN);
			// WebElement we = manageAlertPage.sts_edt_icn;
			//

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);", we);
			// action.moveToElement(manageAlertPage.sts_edt_icn).build().perform();
			WebElement editIcon = manageAlertPage.sts_edt_icn;
			if (editIcon.isDisplayed()) {
				System.out.println("Status Edit icon is present ");
			} else {
				System.out.println("Status Edit icon is not present ");
			}

			editIcon.click();
			// Thread.sleep(2000);

			WebElement webel = driver.findElement(By.xpath("//span[text()='Start Date']"));
			webel.sendKeys(Keys.PAGE_DOWN);

			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// manageAlertPage.drpdwn_sts);
			manageAlertPage.drpdwn_sts.click();
			// WebElement
			// wl=driver.findElement(By.xpath("//span[text()='Status']//..//..//div//a"));
			// wl.click();
			System.out.println("clicked");
			// Select slct_dr=new Select(manageAlertPage.drpdwn_sts);
			// slct_dr.selectByValue(sts);
			// ((JavascriptExecutor)
			// driver).executeScript("arguments[0].scrollIntoView(true);",
			// manageAlertPage.active_sts);
			manageAlertPage.active_sts.click();
			Thread.sleep(2000);

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
					manageAlertPage.save_btn_sts);
			manageAlertPage.save_btn_sts.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to change the status of an Alert");

		}

	}

	public void verifyalertstatus(String sts) {
		try {
			String chng_sts_txt = manageAlertPage.changed_sts.getText();
			if (chng_sts_txt.equalsIgnoreCase(sts)) {
				System.out.println("Status of an alert changed to " + sts + "successfully");
			} else {
				System.out.println("Status of an alert has not changed to " + sts);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: handle exception

		finally {
			driver.quit();
		}

	}

	public void verifySystemDate() throws ParseException {

		try {
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String current_dt = dtf.format(date);
			Date system_dt = (Date) dtf.parse(current_dt);

			String start_dt = manageAlertPage.strt_DT_UpcmngAlert.getText().toString().trim();
			Date strt_date = (Date) dtf.parse(start_dt);

			String end_dt = manageAlertPage.end_DT_UpcmngAlert.getText().toString().trim();
			Date end_date = (Date) dtf.parse(end_dt);

			if (system_dt.after(strt_date) && system_dt.before(end_date)) {
				System.out.println("Current date " + system_dt + "is in between start date " + strt_date
						+ "and end date" + end_date + "PASS");
			} else {
				System.out.println("Current date " + system_dt + "is not in between start date " + strt_date
						+ "and end date" + end_date + "FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to retrive the system date");
		}
	}

	public void verifyAlertTableDetails() {

		try {
			Thread.sleep(4000);
			manageAlertPage.manager_alert.click();
			Thread.sleep(2000);
			if (manageAlertPage.created_alert.isDisplayed() && manageAlertPage.create_alert.isDisplayed()) {
				System.out.println("Create Alert and Created Alert tabs are displayed");
			} else {
				System.out.println("Create Alert and Created Alert tabs are not displayed");
			}
			Thread.sleep(2000);
			manageAlertPage.created_alert.click();
			Thread.sleep(2000);

			if (manageAlertPage.active_alert.isDisplayed() && manageAlertPage.upcoming_alert.isDisplayed()
					&& manageAlertPage.deactivated_alert.isDisplayed()) {
				System.out.println("Active Alert, Upcoming alert and Deactive alert sections are displayed");
			} else {
				System.out.println("Active Alert, Upcoming alert and Deactive alert sections are not displayed");
			}
			String headerNames = "POD,PRIORITY,SUBJECT,CREATED BY,ACKNOWLODGE,TYPE,START DATE,END DATE,ACTION";
			boolean flag = false;
			List<String> activeAlerts = verifyAlertTbleHeaders("Active Alerts");
			for (String alertHeader : activeAlerts) {
				if (headerNames.contains(alertHeader)) {
					flag = true;
					System.out.println("Active Alert Table contains expected header values" + alertHeader);
				}
			}
			if (!flag) {
				System.out.println("Active Alert Table doesnot contains expected header values");
			}
			Thread.sleep(2000);
			List<String> upcomingAlerts = verifyAlertTbleHeaders("Upcoming Alerts");
			for (String alertHeader : upcomingAlerts) {
				if (headerNames.contains(alertHeader)) {
					flag = true;
					System.out.println("Upcoming Alert Table contains expected header values" + alertHeader);
				}
			}
			if (!flag) {
				System.out.println("Upcoming Alert Table doesnot contains expected header values");
			}
			Thread.sleep(2000);
			List<String> deactivatedAlerts = verifyAlertTbleHeaders("Deactivated Alerts");
			for (String alertHeader : deactivatedAlerts) {
				if (headerNames.contains(alertHeader)) {
					flag = true;
					System.out.println("Deactivated Alert Table contains expected header values" + alertHeader);
				}
			}
			if (!flag) {
				System.out.println("Deactivated Alert Table doesnot contains expected header values");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to retrive the alert table details");
		}

	}

	public List<String> verifyAlertTbleHeaders(String alertTxt) {

		List<String> headerValue = new ArrayList<String>();
		try {
			List<WebElement> dtable = driver.findElements(By.xpath("//div/strong[contains(text(),'" + alertTxt
					+ "')]/parent::div/following-sibling::table/thead/tr/th"));
			int count = dtable.size();
			for (int i = 1; i <= count; i++) {
				WebElement alert_HeaderValues = driver.findElement(By.xpath("//div/strong[contains(text(),'" + alertTxt
						+ "')]/parent::div/following-sibling::table/thead/tr/th[" + i + "]/div/span"));
				String alertHeaderValues = alert_HeaderValues.getText().toString().trim();
				System.out.println(alertHeaderValues);
				headerValue.add(alertHeaderValues);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to retrive header values from alert tables");
		}
		return headerValue;

	}

}
