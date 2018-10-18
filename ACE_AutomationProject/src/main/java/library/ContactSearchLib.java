package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import context.TestContext;
import pageObject.Website.ContactSearchPage;
import utils.Wait;

public class ContactSearchLib{
	TestContext testContext;
	WebDriver driver;
	CommonLib library;
	Actions action;
	ContactSearchPage contactSearchPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public ContactSearchLib(TestContext context, CommonLib lib) {

		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		contactSearchPage = context.getPageObjectManager().getContactSearchPage();
		library = lib;
		action = context.action();
	}

	public void enterFirstName(String value) {
		contactSearchPage.txtbox_FirstName.sendKeys(value);
	}

	public void enterLastName(String value) {
		contactSearchPage.txtbox_LastName.sendKeys(value);
	}

	public void clickSearchButton() {
		contactSearchPage.btn_Search.click();
	}
	
	public void clickNewContactButton() {
		contactSearchPage.btn_NewContact.click();
	}
	
	public void clickAddContactButton() {
		contactSearchPage.btn_AddContact.click();
	}

	public void verifyLastNameError(String firstName) {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		contactSearchPage.txtbox_LastName.clear();
		this.enterFirstName(firstName);
		this.clickSearchButton();
		try {
			if (contactSearchPage.error_LastName.getText() == "Please fill last name") {
				System.out.println("Error Message for Last Name verified");
			}else
				throw new RuntimeException("Error: last name error not displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}
	
	public void verifyContactsDisplayed(String firstName, String lastName) {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		this.enterFirstName(firstName);
		this.enterLastName(lastName);
		this.clickSearchButton();
		java.util.Iterator<WebElement> i = contactSearchPage.grid_Results.iterator();
		while(i.hasNext()) {
			WebElement fName = i.next();
			WebElement lName = i.next();
			try {
				if(fName.getText() == firstName && lName.getText() == lastName) {
					System.out.println("Verified the contacts Displayed");
					i.next().click();
					i.next();
				}else
					throw new RuntimeException("Error: Contacts not verified");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		driver.switchTo().defaultContent();
	}
	
	public void verifyNewContact(String firstName, String lastName) {
		try {
			driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
			if(contactSearchPage.btn_NewContact.getAttribute("disabled").equals("true")) {
				this.enterLastName(lastName);
				this.clickSearchButton();
				if(contactSearchPage.btn_NewContact.isEnabled()) {
					this.clickNewContactButton();
					Thread.sleep(5000);
					this.enterFirstName(firstName);
					this.enterLastName(lastName);
					this.clickAddContactButton();
				}else
					throw new RuntimeException("Error: New Contact button not enabled after first search");
			}else
				throw new RuntimeException("Error: New Contact button enabled before first search");
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}
	
	public void clickContactSearchTab() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(contactSearchPage.tab_ContactSearch));
		element.click();
	}
	
	//Following login code is temporary and has to be rearranged to login page
	
	public void login() {
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("dsaishankar@deloitte.com");
		driver.findElement(By.id("password")).sendKeys("Coffee@55");
		driver.findElement(By.id("Login")).click();
	}
}