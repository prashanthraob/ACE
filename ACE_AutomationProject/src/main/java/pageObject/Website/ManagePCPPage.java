package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePCPPage {

	WebDriver driver ;

	public ManagePCPPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='buttondemographicsPanelId']/button")
	public WebElement seeMore_btn; 

	@FindBy(xpath=".//*[@id='demographicsPanelId']//button[starts-with(@onclick,'show')]")
	public WebElement updatePCP_btn; 

	@FindBy(xpath="//button[text()='Search']")
	public WebElement search_Btn; 

	@FindBy(xpath="//div[@id=\"resultsPCP\"]//td[@class='providerItem']")
	public WebElement selectPCP_lnk; 

	@FindBy(xpath=".//*[@id='modal-heading-01' and text() = 'Update PCP']")
	public WebElement updatePCP_popup; 

	@FindBy(xpath=".//*[@id='selectionPCP']//button[@class='slds-button slds-button_brand']")
	public WebElement submit_btn; 

	@FindBy(xpath=".//*[@id='selectionPCP']//button[@class='slds-button slds-button_neutral']")
	public WebElement cancle_btn; 

	@FindBy(xpath=".//*[@id='searchPCP']//label[text()='Reason for Change']/following-sibling::input")
	public WebElement reasnFrChange_txt; 

	@FindBy(xpath=".//*[@id='searchPCP']//label[text()='Effective Date']/following-sibling::input")
	public WebElement effectiveDate_txt; 

	@FindBy(xpath=".//*[@id='searchPCP']//label[text()='Notes']/following-sibling::input")
	public WebElement notes_txt; 

	@FindBy(xpath=".//*[@id='searchPCP']//label[text()='Provider Id']/following-sibling::input")
	public WebElement providerId_txt; 

	@FindBy(xpath=".//*[@id='searchPCP']//label[text()='Provider Name']/following-sibling::input")
	public WebElement providerName_txt; 

	@FindBy(xpath=".//*[@class='slds-col slds-size_6-of-12 slds-p-around_small']//label[text()='Panel status']/following-sibling::select")
	public WebElement panelStatus_drop; 

	@FindBy(xpath=".//*[@class='slds-col slds-size_6-of-12 slds-p-around_small']//label[text()='Network Status']/following-sibling::select")
	public WebElement NetworkStatus_drop; 

	@FindBy(xpath=".//*[@class='slds-col slds-size_6-of-12 slds-p-around_small']//label[text()='Plan Type']/following-sibling::select")
	public WebElement PlanType_drop; 

	@FindBy(xpath="//*[@id='openAdvancedPanelButton']/..")
	public WebElement advanceSearch_btn;

	@FindBy(xpath="//label[text()='Provider Gender']/following-sibling::select")
	public WebElement providerGender_drop;

	@FindBy(xpath="//label[text()='REVIEW SELECTION']")
	public WebElement ReviewSelection_tag;

	@FindBy(xpath="//span[text()='ID:']/following-sibling::span")
	public WebElement ProviderId_tag;

	@FindBy(xpath="(//button[starts-with(@onclick,'closePCP')])[2]")
	public WebElement submitPCP_btn;

}

