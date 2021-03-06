package com.Infostretch.Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass implements PageFile{

	static int i=0;
	
	static Properties prop = new Properties();
	
	public static WebDriver driver=null;
	
	public static WebDriver intDriver() throws IOException {
		
		InputStream input = new FileInputStream("config.properties");
		// load a properties file
		prop.load(input);
		
		//Get gecko driver path
		System.setProperty("webdriver.gecko.driver",prop.getProperty("geckoDriverPath"));
		
		switch (prop.getProperty("Browser")) {
		
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			
			case "Chrome":
				System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
				driver = new ChromeDriver();
				break;
		
			case "IE":
				System.setProperty("webdriver.IE.driver",prop.getProperty("IEDriverPath"));
				driver = new InternetExplorerDriver();
				break;

			default:
				break;
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void launchApp(WebDriver driver) {
		driver.get(prop.getProperty("url"));
	}
	
	public static void enterText(WebDriver driver, String option, By locator) {
		driver.findElement(locator).sendKeys(option);
	}
	
	public static void clickElement(WebDriver driver,By locator) {
		driver.findElement(locator).click();
	}
	
	public static Boolean verifyFlightListing(WebDriver driver) throws IOException {
		Boolean flag = driver.findElement(flightList).isDisplayed();
		return flag;
	}
	
	public static void takeScreenShot(WebDriver driver) throws IOException {
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mangesh.Kulkarni\\eclipse-workspace\\InfostrechAssignment-1\\Snapshot\\snap"+i+".png"));
		i++;// Increment the order number of snapshot
	}
	
	public static String getPathWithCurrentDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        Date dateobj = new Date();
        String path = ".\\log\\testlog".concat(df.format(dateobj).toString().toString()).concat(".log");
        path=path.replace(":", "");
        path=path.replace(" ", "-");
        
        return path;
	}
	
	public static void setPathInPropertiesFile(String logsPath) throws ConfigurationException {
		PropertiesConfiguration properties = new PropertiesConfiguration("log4j.properties");
        properties.setProperty("log4j.appender.R.File", logsPath);
        properties.save();
	}
	
}
