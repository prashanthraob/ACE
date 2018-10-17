package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CostCalculator {

	WebDriver driver;
	public CostCalculator(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='lookupCombobox']")
	public WebElement txtbox_costCal;

	@FindBy(xpath = "//input[@id='lookupCombobox']/../following-sibling::div//span[contains(text(),'Abdominal Abscess')]/..//button[contains(text(),'View Treatment')]")
	public WebElement btn_viewTreatment;
	
	@FindBy(xpath = "")
	public WebElement Result_CostCal;
	
	@FindBy(xpath = "(//h2[@title='Recomended Providers'])[1]")
	public WebElement Result_RecmndedProvider;
	
	@FindBy(xpath = "//p[@class='cc-heading2']")
	public WebElement hd_ResultHeader;
	
	@FindBy(xpath = "//a[@id='changeprovider1']")
	public WebElement lnk_ChangeProvider;
	
	@FindBy(xpath = "(//button[@title='Close dialog'])[1]")
	public WebElement icon_Close;	
	
	@FindBy(xpath = "//div[@id='lookuplistClaims']")
	public WebElement list_costCal;
	
}
