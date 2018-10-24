package pageObject.Website;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSearchLtnPage {

	WebDriver driver;
	public ContactSearchLtnPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='oneHeader']/div[3]/one-appnav/div/one-app-nav-bar/nav/ul/li//*[@title='Contact Search Lightning ACE']")
	public WebElement tab_ContactSearchLtn;
	
	@FindBy(id="input-3")
	public WebElement txtbox_FirstName;
	
	@FindBy(id="input-4")
	public WebElement txtbox_LastName;
	
	@FindBy(xpath="//button[@title='Search Contact']")
	public WebElement btn_Search;
	
	@FindBy(xpath="//button[@title='New Contact']")
	public WebElement btn_NewContact;
	
	@FindBy(xpath="//lightning-datatable/div[2]/div/div/div/table/thead/tr/th/div/span/span")
	public WebElement grid_Headers;
	
	@FindAll(@FindBy(xpath="//lightning-primitive-cell-wrapper/div/slot/lightning-primitive-cell-types"))
	public List<WebElement> grid_Results;
	
	@FindBy(id="input-4-message")
	public WebElement error_LastName;
	
	
}
