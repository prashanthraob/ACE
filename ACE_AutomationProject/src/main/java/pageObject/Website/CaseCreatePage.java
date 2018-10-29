package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaseCreatePage {
	
	WebDriver driver;
	public CaseCreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Comments']//following-sibling::div/textarea")
	public WebElement txtbox_Comments;
	
	@FindBy(xpath = "//span[text()='Status']//parent::label/following-sibling::div//select")
	public WebElement selbox_Status;
	
	@FindBy(xpath = "//span[text()='Origin']//parent::label/following-sibling::div//select")
	public WebElement selbox_Origin;
	
	@FindBy(xpath = "//button[text()='Create case']")
	public WebElement btn_CreateCase;
	
	@FindBy(xpath = "//button[text()='Clear']")
	public WebElement btn_Clear;
	
	@FindBy(xpath = "//*[text()='Case created!']")
	public WebElement ele_CaseCreated;
	
	@FindBy(xpath = "//div[text()='This field is required']")
	public WebElement ele_ErrorMessage;
	
	@FindBy(xpath = "(//a[contains(@class,'textUnderline outputLookupLink slds-truncate forceOutputLookup')])[2]")
	public WebElement eleCaseRecord;

	@FindBy(xpath = "//article[@class=' cuf-auxBody cuf-auxBodyCaseComment']")
	public WebElement eleCommentTextBox;
}
