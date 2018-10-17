package pageObject.Website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanAndBenefitsPage {
	
	WebDriver driver;
	
	public PlanAndBenefitsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='tab-default-1']//strong[contains(text(),'Plan Details')]")
	public WebElement hd_PlanDetails;
	
	public String xpath = "//span[contains(text(),'fieldName')]";

	@FindBy(xpath = "//strong[contains(text(),'Benefit Details')]")
	public WebElement hd_BenefitDetails;
	 
	@FindBy(xpath = "//strong[contains(text(),'Copay Information')]")
	public WebElement hd_copayInf;

	@FindBy(xpath = "//strong[contains(text(),'Claimed Benefits')]")
	public WebElement hd_claimedBenefits;
	
}
