package utils;

import org.openqa.selenium.WebDriver;

import pageObject.Website.CaseCreatePage;
import pageObject.Website.ContactSearchPage;
import pageObject.Website.CostCalculator;
import pageObject.Website.CustomerSearchPage;
import pageObject.Website.HomePage;
import pageObject.Website.LoginPage;
import pageObject.Website.ManageAlertPage;
import pageObject.Website.ManagePCPPage;
import pageObject.Website.MemberDemographicsPage;
import pageObject.Website.MemberDetails;
import pageObject.Website.PlanAndBenefitsPage;

public class PageObjectManager {

	WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	private LoginPage loginPage;
	private MemberDemographicsPage memberDemoPage;
	private HomePage homePage;
	private MemberDetails memberDetails;
	private CostCalculator costCalPage;
	private ManageAlertPage manageAlertPage;
	private CustomerSearchPage customerSearchPage;
	private ManagePCPPage managePCPPage;
	private PlanAndBenefitsPage planAndBenefitsPage;
	private ContactSearchPage contactSearchPage;
	private CaseCreatePage caseCreatePage;
	
	public WebDriver getDriver() {
		return driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public MemberDetails getMemberDetails() {
		return (memberDetails == null) ? memberDetails = new MemberDetails(driver) : memberDetails;

	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public MemberDemographicsPage getMemberDemoPage() {
		return (memberDemoPage == null) ? memberDemoPage = new MemberDemographicsPage(driver) : memberDemoPage;
	}

	public CostCalculator getCostCalPage() {
		return (costCalPage == null) ? costCalPage = new CostCalculator(driver) : costCalPage;
	}

	public ManageAlertPage getManageAlertPage() {
		return (manageAlertPage == null) ? manageAlertPage = new ManageAlertPage(driver) : manageAlertPage;
	}

	public ManagePCPPage getManagePCPPage() {
		return (managePCPPage == null) ? managePCPPage = new ManagePCPPage(driver) : managePCPPage;
	}

	public CustomerSearchPage getCustomerSearchPage() {
		return (customerSearchPage == null) ? customerSearchPage = new CustomerSearchPage(driver) : customerSearchPage;

	}

	public PlanAndBenefitsPage getPlanAndBenefitsPage() {

		return (planAndBenefitsPage == null) ? planAndBenefitsPage = new PlanAndBenefitsPage(driver)
				: planAndBenefitsPage;
	}
	
	public ContactSearchPage getContactSearchPage() {
		return (contactSearchPage == null) ? contactSearchPage = new ContactSearchPage(driver) : contactSearchPage;

	}
	
	public CaseCreatePage getCaseCreatePage() {
		return (caseCreatePage == null) ? caseCreatePage = new CaseCreatePage(driver) : caseCreatePage;

	}

}
