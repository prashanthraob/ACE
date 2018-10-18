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
	
	@FindBy(xpath="//iframe")
	public WebElement frame_CustomerSearch;
	
	@FindBy(xpath="//*[@id='j_id0:j_id82:firstName']")
	public WebElement txtbox_FirstName;
	
	@FindBy(xpath="//*[@id='j_id0:j_id82:lastName']")
	public WebElement txtbox_LastName;
	
	@FindBy(id="searchButton")
	public WebElement btn_Search;
	
	@FindBy(id="newContactButton")
	public WebElement btn_NewContact;
	
	@FindBy(xpath="//*[@id='j_id0:searchTable']/thead/tr/th/div")
	public WebElement grid_Headers;
	
	@FindAll(@FindBy(xpath="//*[@id='j_id0:searchTable']/tbody/tr[1]/td"))
	public List<WebElement> grid_Results;
	
	@FindBy(id="requiredFireldFirstNameMessage")
	public WebElement error_LastName;
	
	@FindBy(id="saveButton")
	public WebElement btn_AddContact;
	
}
