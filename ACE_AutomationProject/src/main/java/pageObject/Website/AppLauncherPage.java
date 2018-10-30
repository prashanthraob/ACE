package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppLauncherPage {
	
	WebDriver driver;
	public AppLauncherPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='slds-icon-waffle']")
	public WebElement tab_App_Launcher;
	
	@FindBy(linkText="Sales Console")
	public WebElement salesConsole;
	
	@FindBy(linkText="Sales")
	public WebElement sales;
	
}
