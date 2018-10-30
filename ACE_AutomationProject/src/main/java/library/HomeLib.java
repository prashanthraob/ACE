package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import context.TestContext;
import pageObject.Website.HomePage;
import utils.Wait;

public class HomeLib {
	
		TestContext testContext;
		WebDriver driver;
		CommonLib library;
		Actions action;
		HomePage homePage;
		String path = System.getProperty("EvidencePath");
		Wait wait = new Wait();

		public HomeLib(TestContext context, CommonLib lib) {

			testContext = context;
			driver = context.getWebDriverManager().getDriver();
			homePage = context.getPageObjectManager().getHomePage();
			library = lib;
			action = context.action();
		}
		
		public void clickDropDown() {
			homePage.dropDown.click();
		}
		
		public void clickContactSearchFromDropDown() throws InterruptedException {
			homePage.contactSearch.click();
			Thread.sleep(8000);
		}

}
