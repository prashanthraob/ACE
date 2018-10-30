package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import context.TestContext;
import pageObject.Website.AppLauncherPage;
import utils.Wait;

public class AppLauncherLib {
	
	TestContext testContext;
	WebDriver driver;
	CommonLib library;
	Actions action;
	AppLauncherPage appLauncherPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public AppLauncherLib(TestContext context, CommonLib lib) {
		System.out.println("Inside Constructor");
		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		appLauncherPage = context.getPageObjectManager().getAppLauncherPage();
		library = lib;
		action = context.action();
	}
	
	public void clickAppLauncherIcon() throws InterruptedException {
		System.out.println("Inside App");
		appLauncherPage.tab_App_Launcher.click();
		Thread.sleep(10000);
	}
	
	public void clickSalesConsole() {
		appLauncherPage.salesConsole.click();
	}

}
