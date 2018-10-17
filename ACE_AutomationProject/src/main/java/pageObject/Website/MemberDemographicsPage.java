package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberDemographicsPage {

	WebDriver driver ;
	
	public MemberDemographicsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath="//a[@style='color: #000']")
	public WebElement lbl_memberName; 

	@FindBy(xpath="//*[@id='j_id0:j_id178']/div[1]/div/div[3]/div[2]/div/span/strong")
	public WebElement lbl_memId; 

	@FindBy(xpath="//div[@class='slds-col']//span[text()= 'Plan Name']/following::span[1]")
	public WebElement lbl_planName; 

	@FindBy(xpath="//span[@title='HCSC']")
	public WebElement lbl_projectName;
	
	@FindBy(xpath="//label[text()='Date of Birth']/following-sibling::span")
	public WebElement lbl_dob;
	
	@FindBy(xpath="//label[text()='SSN']/following-sibling::span")
	public WebElement lbl_ssn;
	
	@FindBy(className="checkbox checkbox-css")
	public WebElement lbl_emailId;
	
	@FindBy(xpath="//label[text()='Primary Phone Number']/following-sibling::span")
	public WebElement lbl_phoneNmb;
	
	@FindBy(xpath="(//div[@id='buttondemographicsPanelId']/button)[1]")
	public WebElement lnk_seeMore;
	
	@FindBy(xpath="(//label[text()='Gender']/following-sibling::span")
	public WebElement lbl_gender;
	
	@FindBy(xpath="(//*[@id='j_id0:j_id178']//strong)[2]")
	public WebElement lbl_hapinesScore;
	
	@FindBy(id="j_id0:j_id285:j_id286:j_id370:j_id377")
	public WebElement lnk_RewardViewDetails;
	
	@FindBy(id="(//*[@id=\"memberAccountInformation\"]//p/label)[4]")
	public WebElement lbl_totalRewardPoints;
	
}
