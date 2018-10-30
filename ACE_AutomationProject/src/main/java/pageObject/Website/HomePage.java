package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='slds-context-bar__icon-action']")
	public WebElement dropDown_contacts;
	
	@FindBy(xpath="//*[@id='oneHeader']/div[3]/div/div[1]/div[3]/div/button")
	public WebElement dropDown;

	@FindBy(xpath = "//span[text()='Customer Search']")
	public WebElement customerSearch;
	
	@FindBy(xpath = "//button[@class='bare slds-button slds-utility-bar__action uiButton' and @type='button' and contains(.,'Manager Alert')]")
	public WebElement manager_alert_Tab;

	@FindBy(xpath = "(//a[@title='Erica Schiff'])[1]")
	public WebElement EricaSchiff;
	
	@FindBy(xpath="//*[@id='navMenuList']//span[text()='Contact Search']")
	public WebElement contactSearch;

	/*
	 * @FindBy(id="costCalculatorOption") public WebElement tab_CostCalcator;
	 */
}
