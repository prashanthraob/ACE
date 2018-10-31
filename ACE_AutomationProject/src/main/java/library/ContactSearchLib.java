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
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		contactSearchPage.btn_Search.click();
		driver.switchTo().defaultContent();
		library.takeScreenshot(path, "Passed_Search");
	}

	public void clickNewContactButton() {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		contactSearchPage.btn_NewContact.click();
		driver.switchTo().defaultContent();
	}

	public void clickAddContactButton() {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		contactSearchPage.btn_AddContact.click();
		driver.switchTo().defaultContent();
	}

	public void enterOnlyFirstName(String firstName) {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		contactSearchPage.txtbox_LastName.clear();
		this.enterFirstName(firstName);
		driver.switchTo().defaultContent();
	}

	public void verifyLastNameError() {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		try {
			if (contactSearchPage.error_LastName.getText().equals("Please fill last name")) {
				System.out.println("Error Message for Last Name verified");
			}else
				throw new RuntimeException("Error: last name error not displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}

	public void enterFirstAndLastName(String firstName, String lastName) throws InterruptedException {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		this.enterFirstName(firstName);
		this.enterLastName(lastName);
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		library.takeScreenshot(path, "Passed_Names");
	}

	public void verifyContactsDisplayed(String firstName, String lastName, String value) throws InterruptedException {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		Thread.sleep(10000);
		//WebDriverWait wait = new WebDriverWait(driver, 120);
		//wait.until(ExpectedConditions.visibilityOfAllElements(contactSearchPage.grid_Results));
		java.util.Iterator<WebElement> i = contactSearchPage.grid_Results.iterator();
		try {
			while(i.hasNext()) {
				WebElement fName = i.next();
				WebElement lName = i.next();
				System.out.println(fName.getText() + " " + lName.getText());
				if(fName.getText().equals(firstName) || lName.getText().equals(lastName)) {
					System.out.println("Verified the contacts Displayed");
					Thread.sleep(10000);
					if(value.equals("Contacts")) {
						WebElement link = i.next().findElement(By.tagName("a"));
						link.click();
						Thread.sleep(10000);
						i.next();
						library.takeScreenshot(path, "Passed_Verfication");
					}else if(value.equals("Welcome")) {
						i.next();
						WebElement link = i.next().findElement(By.tagName("a"));
						link.click();
						Thread.sleep(10000);
						library.takeScreenshot(path, "Passed_Verfication");
					}
					break;
				}else {
					library.takeScreenshot(path, "Failed_Verification");
					//throw new RuntimeException("Error: Contacts not verified");
					i.next();
					i.next();
					i.next();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}

	public void verifyNewContactDisabled() {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		try {
			if(contactSearchPage.btn_NewContact.getAttribute("disabled").equals("true")) {
				System.out.println("Add New Contact button is disabled");
			}else
				throw new RuntimeException("Error: Add New Contact button is not disabled on Page Load");
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}

	//	public void verifyNewContact(String firstName, String lastName) {
	//		try {
	//			driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
	//			if(contactSearchPage.btn_NewContact.getAttribute("disabled").equals("true")) {
	//				this.enterLastName(lastName);
	//				this.clickSearchButton();
	//				if(contactSearchPage.btn_NewContact.isEnabled()) {
	//					this.clickNewContactButton();
	//					Thread.sleep(5000);
	//					this.enterFirstName(firstName);
	//					this.enterLastName(lastName);
	//					this.clickAddContactButton();
	//				}else
	//					throw new RuntimeException("Error: New Contact button not enabled after first search");
	//			}else
	//				throw new RuntimeException("Error: New Contact button enabled before first search");
	//		}catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//		driver.switchTo().defaultContent();
	//	}

	public void verifyNewContactEnabled() throws InterruptedException {
		driver.switchTo().frame(contactSearchPage.frame_CustomerSearch);
		Thread.sleep(10000);
		if(contactSearchPage.btn_NewContact.isEnabled())
			System.out.println("New contact button verified.");
		else
			throw new RuntimeException("Error: New Contact button not enabled after first search");
		driver.switchTo().defaultContent();
	}



	public void clickContactSearchTab() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(contactSearchPage.tab_ContactSearch));
		element.click();
		library.takeScreenshot(path, "Passed_ContactSearch");
	}

	//Following login code is temporary and has to be rearranged to login page

	public void login() throws InterruptedException {
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("dsaishankar@deloitte.com");
		driver.findElement(By.id("password")).sendKeys("Coffee@55");
		library.takeScreenshot(path, "Passed_Login");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(15000);
		library.takeScreenshot(path, "Passed_Home");
		//driver.findElement(By.xpath("//header[@id='oneHeader']/div[3]/div/div/div/nav/button/div/div")).click();
		//System.out.println("Launcher clicked");
		//Thread.sleep(20000);
	}

	public void verifyWelcomeText() {

		driver.switchTo().frame(contactSearchPage.welcomeFrame);
		try {
			contactSearchPage.txt_Welcome.sendKeys("Hello");
			Thread.sleep(3000);
			System.out.println("Starts"+contactSearchPage.txt_Welcome.getText()+"Ends");
			if(contactSearchPage.txt_Welcome.getAttribute("value").equals("Hello")) {
				System.out.println("Welcome Text Verified!");
			}else {
				throw new RuntimeException("Error Welcome Text not verified");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
	}
}