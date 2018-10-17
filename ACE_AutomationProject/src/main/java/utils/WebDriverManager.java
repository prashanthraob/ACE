package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	private WebDriver driver;
	private static String driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	 ChromeOptions options = new ChromeOptions();
	public WebDriverManager() {
		driverType = Config.getInstance().getBrowser();
	}

	public WebDriver getDriver() {
		if (driver == null) {
			switch (driverType) {
			case "Firefox":
				System.setProperty(FIREFOX_DRIVER_PROPERTY, Config.getInstance().getDriverPath().concat("\\geckodriver.exe"));
				driver = new FirefoxDriver();
				break;
			case "Chrome":
				System.out.println(Config.getInstance().getDriverPath().concat("\\chromedriver.exe")+"____________________________________");
				System.setProperty(CHROME_DRIVER_PROPERTY,
						Config.getInstance().getDriverPath().concat("\\chromedriver.exe"));
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				break;
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(
					Config.getInstance().implicitWaitTime(), TimeUnit.SECONDS);
		}
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
