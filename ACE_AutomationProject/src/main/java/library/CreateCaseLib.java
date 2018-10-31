package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import context.TestContext;
import pageObject.Website.CaseCreatePage;
import utils.Wait;

public class CreateCaseLib {
	
	
	TestContext testContext;
	WebDriver driver;
	CommonLib library;
	Actions action;
	CaseCreatePage caseCreatePage;
	//ContactSearchPage contactSearchPage;
	String path = System.getProperty("EvidencePath");
	Wait wait = new Wait();

	public CreateCaseLib(TestContext context, CommonLib lib) {

		testContext = context;
		driver = context.getWebDriverManager().getDriver();
		caseCreatePage = context.getPageObjectManager().getCaseCreatePage();
		//contactSearchPage = context.getPageObjectManager().getContactSearchPage();
		library = lib;
		action = context.action();
	}
	
	public void fillCase(String fields,String Values) {
		
		String[] arrFields = fields.split(",");
		String[] arrValues = Values.split(",");
		
		for(int i = 0;i<arrFields.length;i++) {
			
			switch(arrFields[i].toUpperCase())
			{
			case "STATUS" :
				WebDriverWait wait = new WebDriverWait(driver, 120);
				wait.until(ExpectedConditions.elementToBeClickable(caseCreatePage.selbox_Status));
				Select sel_Status = new Select(caseCreatePage.selbox_Status);
				sel_Status.selectByValue(arrValues[i]);
				System.out.println("Status select from select box");
				break;
				
			case "ORIGIN" :
				Select sel_Origin = new Select(caseCreatePage.selbox_Origin);
				sel_Origin.selectByValue(arrValues[i]);
				System.out.println("Origin select from origin box");
				break;
				
			case "COMMENTS"	:				
				caseCreatePage.txtbox_Comments.sendKeys(arrValues[i]);
				System.out.println("Entered text in the comments text box");
				break;
				
			}
		}
		
	}
	public void clicksOnCreateCase() {
		
		caseCreatePage.btn_CreateCase.click();
		
	}
	
	public void clicksOnClear() throws Throwable {
		
		caseCreatePage.btn_Clear.click();
		System.out.println("Clicked on cleared button successfully");
		Thread.sleep(2000);
		
	}
	
	public void verifyCaseCreated() throws Throwable {
		
		library.isElementPresent(caseCreatePage.ele_CaseCreated);
		
	}
	
	public void verifyCaseTemplatedCleared() {
		
		try {
		
		Select sel_Status = new Select(caseCreatePage.selbox_Status);
		if(sel_Status.getFirstSelectedOption().getText().contains("None")) {
			System.out.println("Success: Status dropdown set to default");		
		}else {
			library.takeScreenshot(path, "Fail_DataNotClearedStatus");
			throw new RuntimeException("Error: Status dropdown value not set to default value");
		}
		Select sel_Origin = new Select(caseCreatePage.selbox_Origin);
		if(sel_Origin.getFirstSelectedOption().getText().contains("None")) {
			System.out.println("Success: Origin dropdown set to default");		
		}else {
			library.takeScreenshot(path, "Fail_DataNotClearedOrigin");
			throw new RuntimeException("Error: Origin dropdown value not set to default value");
		}
		if(caseCreatePage.txtbox_Comments.getText().equals("")) {
			System.out.println("Success: Text cleared in comment text box");
		}else {
			library.takeScreenshot(path, "Fail_DataNotClearedComments");
			throw new RuntimeException("Error: Text not cleared in text box");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyErrorMessage() throws Throwable {
		
		library.isElementPresent(caseCreatePage.ele_ErrorMessage);
		
	}
	
	public void clickOnCase(String caseText) throws Throwable {
			
		driver.navigate().refresh();
		
		wait.waitForPageLoad(driver);
		
		Thread.sleep(10000);
		
		caseCreatePage.eleCaseRecord.click();
		
		Thread.sleep(10000);
		
		wait.waitForPageLoad(driver);
		
		System.out.println(caseCreatePage.eleCommentTextBox.getText());
		
		try {
			
			if(caseCreatePage.eleCommentTextBox.getText().equals(caseText)) {
				System.out.println("Success: Case comments displayed successfully in case comments records");
			}else{
				library.takeScreenshot(path, "Fail_CaseCommentsNotDisplayed");
				throw new RuntimeException("Error: Case comments displayed successfully in case comments records");
			}
			
		}catch(Exception e) {
			
			library.takeScreenshot(path, "Fail_CaseCommentsNotDisplayed");
			throw new RuntimeException("Error: Case comments displayed successfully in case comments records");
			
		}
		
	}

}
