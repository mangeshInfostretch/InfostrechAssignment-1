package com.Infostretch.Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass implements PageFile{

	static int i=0;
	
	static Properties prop = new Properties();
	
	public static WebDriver driver=null;
	
	public static WebDriver intDriver() throws IOException {
		InputStream input = new FileInputStream("config.properties");
		// load a properties file
		prop.load(input);
		
		System.setProperty("webdriver.gecko.driver",prop.getProperty("geckoPath"));
		
		//Inilize the driver
		driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public static void launchApp(WebDriver driver) {
		driver.get(prop.getProperty("url"));
	}
	
	public static Boolean verifyFlightListing(WebDriver driver) throws IOException {
		Boolean flag = driver.findElement(flightList).isDisplayed();
		takeScreenShot(driver);
		return flag;
	}
	
	public static void takeScreenShot(WebDriver driver) throws IOException {
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mangesh.Kulkarni\\eclipse-workspace\\Test\\Snapshot\\snap"+i+".png"));
		i++;// Increment the order number of snapshot
	}
}
