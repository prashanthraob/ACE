package pageObject.Website;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSearchPage {

	WebDriver driver;
	public ContactSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='oneHeader']/div[3]/one-appnav/div/one-app-nav-bar/nav/ul/li//*[@title='Contact Search']")
	public WebElement tab_ContactSearch;
	
	
	//Following elements fall under a frame
	//frame="//iframe"
	
	@FindBy(xpath="//div[@class='content']/iframe")
	public WebElement frame_CustomerSearch;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	public WebElement txtbox_FirstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	public WebElement txtbox_LastName;
	
	@FindBy(id="searchButton")
	public WebElement btn_Search;
	
	@FindBy(id="newContactButton")
	public WebElement btn_NewContact;
	
	@FindBy(xpath="//table[contains(@id,'searchTable')]/thead/tr/th")
	public WebElement grid_Headers;
	
	@FindAll(@FindBy(xpath="//table[contains(@id,'searchTable')]/tbody/tr[2]/td"))
	public List<WebElement> grid_Results;
	
	@FindBy(id="requiredFireldFirstNameMessage")
	public WebElement error_LastName;
	
	@FindBy(id="saveButton")
	public WebElement btn_AddContact;
	
	@FindBy(xpath="//tbody/tr[1]/td[3]/a")
	public WebElement tblResult;
	
	@FindBy(xpath="//*[text()='Follow']")
	public WebElement ele_Follow;
	
	@FindBy(xpath="//div[@class='slds-template_iframe slds-card']/iframe")
	public WebElement welcomeFrame;
	
	@FindBy(xpath="//form/input[2]")
	public WebElement txt_Welcome;
}
