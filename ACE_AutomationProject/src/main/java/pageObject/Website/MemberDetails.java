package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberDetails extends HomePage {

	WebDriver driver;

	public MemberDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@height='2200' and @width='100%']")
	public WebElement iFrame_HomeFrame;

	@FindBy(xpath = "//div[@id='member360Option']//span[text()='Member 360']")
	public WebElement member360_Tab;

	@FindBy(xpath = "//div[@id='salesContentMenuOptions']/div[@id='claimsOption']")
	public WebElement claims_Tab;

	@FindBy(xpath = "//div[@id='salesContentMenuOptions']/div[@id='benefitsOption']")
	public WebElement benefits_Tab;

	@FindBy(xpath = "//div[@id='salesContentMenuOptions']/div[@id='careManagementOption']")
	public WebElement careManagement_Tab;

	@FindBy(xpath = "//div[@id='salesContentMenuOptions']/div[@id='costCalculatorOption']")
	public WebElement costCalculator_Tab;

	@FindBy(xpath = "(//a[contains(text(),'View Details')])[3]")
	public WebElement lnk_RewardViewDetails;

	@FindBy(xpath = "//p[contains(text(),'Total Rewards :')]")
	public WebElement lbl_totalRewardPoints;

	@FindBy(xpath = "//h1[contains(text(),'REWARDS SUMMARY')] ")
	public WebElement heading_RewardsSummary;

	@FindBy(xpath = "//span[contains(text(), 'REWARDS')]")
	public WebElement hd_Rewards;

	@FindBy(xpath = "//div[@id='buttondemographicsPanelId']/a[contains(text(),'See more')]")
	public WebElement lnk_seeMore;

	public String xpath = "//div[@id='demographicsPanelId']//label[text()='fieldName']/..//span";

	@FindBy(xpath = "//button[contains(text(),'Update Information')]")
	public WebElement btn_UpdateInformation;

	@FindBy(xpath = "//button[contains(text(),'Update PCP')]")
	public WebElement btn_UpdatePCP;

	@FindBy(xpath = "//div[contains(text(),'Request Id Card')]")
	public WebElement btn_RequestIdCard;

	@FindBy(xpath = "//span[contains(text(),'Find a Doctor')]/..")
	public WebElement btn_FindADoctor;

	@FindBy(xpath = "//h2[text()='FIND A DOCTOR']/../..//strong[contains(text(),'Results')]")
	public WebElement Lbl_Resuls_findADoctor;

}
