package context;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import utils.PageObjectManager;
import utils.WebDriverManager;

public class TestContext {

	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private JavascriptExecutor executor;
	Actions action;
	
	public TestContext(){
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		executor = (JavascriptExecutor)webDriverManager.getDriver();
		action = new Actions(webDriverManager.getDriver());
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public JavascriptExecutor executor () {
		executor = (JavascriptExecutor)webDriverManager.getDriver();
		return executor;
	}
	
	public Actions action () {
		action = new Actions(webDriverManager.getDriver());
		return action;
	}
}

