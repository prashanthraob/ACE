package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAlertPage {

	WebDriver driver;

	public ManageAlertPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='bare slds-button slds-utility-bar__action uiButton' and @type='button' and contains(.,'Manager Alert')]")
	public WebElement manager_alert;

	@FindBy(xpath = "//input[@class=' input' and @type='text' and @data-interactive-lib-uid='4']")
	public WebElement alret_name;

	@FindBy(xpath = "//select[@class=' select' and @data-interactive-lib-uid='5']")
	public WebElement alert_type;

	@FindBy(xpath = "//textarea[@class=' textarea' and @data-interactive-lib-uid='6']")
	public WebElement alert_desc;

	@FindBy(xpath = "//select[@class=' select' and @data-interactive-lib-uid='8']")
	public WebElement alert_pod;

	@FindBy(xpath = "//select[@class=' select' and @data-interactive-lib-uid='9']")
	public WebElement alert_prio;

	@FindBy(xpath = "(//div[@class='form-element']//a[@class='datePicker-openIcon display'])[1]")
	public WebElement alert_sdate_cal;

	@FindBy(xpath = "(//div[@class='form-element']//a[@class='datePicker-openIcon display'])[2]")
	public WebElement alert_edate_cal;

	@FindBy(xpath = "//span[@class='slds-day weekday todayDate selectedDate DESKTOP uiDayInMonthCell--default']")
	public WebElement alert_start_date;

	@FindBy(xpath = "//a[@class='navLink nextMonth' and @title='Go to next month']")
	public WebElement alert_next_month;

	@FindBy(xpath = "(//span[@class='slds-day weekday DESKTOP uiDayInMonthCell--default'])[last()]")
	public WebElement alert_end_date;

	@FindBy(xpath = "//button[@class='slds-button slds-button_brand' and @type='button' and text()='Save']")
	public WebElement save_btn;

	@FindBy(xpath = "//a[@class='slds-tabs_default__link' and @role='tab' and contains(.,'Created Alerts')]")
	public WebElement created_alert;

	@FindBy(xpath = "//span[@class='slds-text-color_primary cursorPointer']")
	public WebElement created_alert_name;

	// @FindBy(xpath="(//span[@class='slds-text-color_primary cursorPointer'])[1]")
	// public WebElement fst_alrt_nme;

	// @FindBy(xpath="//strong[contains(text(),'Upcoming
	// Alert')]//..//..//table//tr[1]//td[9]")
	// public WebElement fst_dlt_icn;

	@FindBy(xpath = "//strong[contains(text(),'Active Alert') or contains(text(),'Upcoming Alert')]//..//..//table//tr[not(contains(@class,'slds-text-title_caps'))]")
	public WebElement count_alert;

	@FindBy(xpath = "//strong[contains(text(),'Deactivated Alert')]//..//..//table//tr[1]//td[3]//div//span")
	public WebElement dactv_alrt_name;

	@FindBy(xpath = "(//button[@class='slds-button minButton slds-button_icon-bare' and @title='Minimize'])[last()]")
	public WebElement minimize;

	@FindBy(xpath = "//span[text()='Status']//..//..//div//a")
	public WebElement drpdwn_sts;

	@FindBy(xpath = "//a[@title='Active']")
	public WebElement active_sts;

	@FindBy(xpath = "//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton' and @title='Save']")
	public WebElement save_btn_sts;

	// @FindBy(xpath="(//button[@class='slds-button test-id__inline-edit-trigger
	// slds-button_icon slds-button_icon-small slds-shrink-none inline-edit-trigger
	// slds-button_icon-container' and @title='Edit Status'])")
	// public WebElement sts_edt_icn;

	@FindBy(xpath = "//span[text()='Alert Name']//..//..//button")
	public WebElement alrt_edt_icn;

	@FindBy(xpath = "//span[text()='Status']//..//..//button")
	public WebElement sts_edt_icn;

	@FindBy(xpath = "//div[@class='test-id__field-label-container' and contains(.,'Status')]//following-sibling::div[@class='slds-form-element__control slds-grid itemBody']//span//span")
	public WebElement changed_sts;

	@FindBy(xpath = "//div/strong[contains(text(),'Upcoming Alerts')]/parent::div/following-sibling::table/tbody/tr[1]/td[7]")
	public WebElement strt_DT_UpcmngAlert;

	@FindBy(xpath = "//div/strong[contains(text(),'Upcoming Alerts')]/parent::div/following-sibling::table/tbody/tr[1]/td[8]")
	public WebElement end_DT_UpcmngAlert;

	@FindBy(xpath = "//div/strong[contains(text(),'Active Alerts')]/parent::div/following-sibling::table/thead")
	public WebElement active_Alert_Header;

	@FindBy(xpath = "//a[contains(text(),'Create Alerts')]")
	public WebElement create_alert;

	@FindBy(xpath = "//strong[contains(text(),'Active Alert')]")
	public WebElement active_alert;

	@FindBy(xpath = "//strong[contains(text(),'Upcoming Alert')]")
	public WebElement upcoming_alert;

	@FindBy(xpath = "//strong[contains(text(),'Deactivated Alert')]")
	public WebElement deactivated_alert;
	@FindBy(xpath = "(//*[name()='svg' and @data-key='delete']//*[name()='use'])[1]")
	public WebElement fst_dlt_icn;

	@FindBy(xpath = "//strong[contains(text(),'Active Alert')]//..//..//table//tr[1]//td[3]//span")
	public WebElement fst_alrt_nme;

}
