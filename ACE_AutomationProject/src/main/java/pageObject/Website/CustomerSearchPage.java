package pageObject.Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerSearchPage {
	WebDriver driver;

	public CustomerSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@title='Customer Search']")
	public WebElement frame_customerSearch;
	
	
	public String fields_xpath = "//label[text()='FieldName']/../input";
	
	
	
	// Member Search
	@FindBy(id = "j_id0:idApexForm:patientFirstNamePatientSearch")
	public WebElement txt_FirstName;

	@FindBy(id = "j_id0:idApexForm:idMRNPatientSearch")
	public WebElement txt_memberId;

	@FindBy(id = "searchButtonPatientSearch")
	public WebElement btn_search;

	@FindBy(xpath = "(//a//span[text()='Customer Search'])[2]")
	public WebElement tab_memberSearch;

	@FindBy(xpath = "//*[@id='DataTables_Table_3']/tbody/tr/td[1]/text()[1]")
	public WebElement lbl_memberName;

	@FindBy(xpath = "//button[@class='btn btn-primary' and @id='verifiedButtonPatientSearch']")
	public WebElement btn_verifyMember;

	@FindBy(xpath = "//a[text()='A matching customer was not found.']")
	public WebElement msg_customerNotFound;

}
