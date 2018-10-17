package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Config config = null;
	private Properties prop = null;
	
	//to get Single Instance of a class
	public static Config getInstance(){
		if(config == null){
			config = new Config();
		}
		return config;
	}
	
	//private constructor for loading properties
	private Config(){
		Properties prop = new Properties();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("Config.properties");
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.prop = prop;
	}
	
	//get value from Config properties
	public String getProperty(String browser){
		String value = prop.getProperty(browser);
		return value;
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("Application URL not defined at specified Configuration File");
	}
	 
	public String getRewardsEndpointURL() {
		String url = prop.getProperty("rewardService");
		return url;	
	}
	
	public String getRewardsEndpointURLERROR() {
		String url = prop.getProperty("rewardServiceError");
		return url;	
	}
	
	

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public long implicitWaitTime() {
		
		String wait = prop.getProperty("implicitWait");
		return Long.parseLong(wait);
	/*	String implicitWaitTime = property.getProperty("implicitWait");
		if (implicitWaitTime != null)
			return Long.parseLong(implicitWaitTime);
		else
			throw new RuntimeException("implicit Wait time not specified at specified Configuration File");*/
	}

	public String getDriverPath() {
		String path  = System.getProperty("user.dir").concat(getProperty("driverPath"));
		return path;
	}
		//String driverPath = System.getProperty("user.dir").concat(property.getProperty("driverPath"));
//		if (driverPath != null)
//			return driverPath;
//		else
//			throw new RuntimeException("Driver Path not found at specified Configuration File");
//	}
}

