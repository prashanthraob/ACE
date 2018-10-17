package stepDefinitions.functional;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/** Hooks class should always be present in Step Definitions folder
 * 
 */
public class Hooks {
	public static Scenario scenario;

	TestContext testContext ;
	WebDriver driver;
	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario(Scenario scenario){

		this.scenario = scenario;
		String scenarioName = scenario.getName();
		//we will need only test case number so getting only number
		String testCaseId = getTestCase(scenarioName);
		//Now will create a Folder path to save screenshots for this
		String filePath = "target/";
		String screenshotsPath = filePath+"screenshots/"+testCaseId;
		createFolder(screenshotsPath);
		System.setProperty("EvidencePath", screenshotsPath);
	}

	//creating folder
	private static void createFolder(String path){		
		if(path.contains("NoTestCaseId")){
			Calendar currentTime = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
			path = path+"\\"+sdf.format(currentTime.getTime());
		}
		File screenshotDir = new File(path);
		screenshotDir.mkdirs();
		if(!(path.contains("NoTestCaseId")) && screenshotDir.exists()){
			//this feature is compatible in only Java 1.8 for lower versions, we should create a method
			Arrays.stream(new File(path).listFiles()).forEach(File::delete);
			screenshotDir.delete();
			screenshotDir.mkdirs();
		}else if(!(path.contains("NoTestCaseId")) && !(screenshotDir.exists())){
			screenshotDir.mkdirs();
		}else if(path.contains("NoTestCaseId") && !(screenshotDir.exists())){
			screenshotDir.mkdirs();
		}
		screenshotDir.setWritable(true);
	}

	//getting Test case number in the beginning of scenario
	private String getTestCase(String name){
		StringBuilder testCaseNo = new StringBuilder();
		for(int i=0; i<name.length();i++){
			if(name.charAt(i) > 47 && name.charAt(i) < 58){
				testCaseNo.append(name.charAt(i));
			}else{
				break;
			}
		}
		if(!(testCaseNo.length()>0)){
			testCaseNo.append("NoTestCaseId");
		}
		return testCaseNo.toString();
	}

	@After
	public void afterScenario(){
		if(testContext.getWebDriverManager().getDriver()!=null) {
			testContext.getWebDriverManager().closeDriver();
		}
	}
}

