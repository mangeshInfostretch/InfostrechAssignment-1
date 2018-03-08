package com.Infostretch.Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Unit test for simple App.
 */
public class AssignmentTest1 extends BaseClass{
	
	public static WebDriver driver=null;
	
	public static void main(String[] args) throws IOException {
		
	    Logger log=Logger.getLogger("AssignmentTest1");
	 
        // configure log4j properties file
        PropertyConfigurator.configure("Log4j.properties");
        
		//Initiate driver
		driver=intDriver();
		log.info("<----------Inilizing the driver------------->");
		
		// Launch the application
		launchApp(driver);
		log.info("Launch the application");
		
		clickElement(driver, flightTab);
		log.info("User clicks on flight tab");
		
		takeScreenShot(driver);
		
		clickElement(driver, oneWayRadioBtn);
		log.info("User clicks on one way option");
		
		enterText(driver,prop.getProperty("Origin") , flightOriginTxtBox);
		log.info("User enter text");
		
		enterText(driver, prop.getProperty("Destination"), flightDestinationTxtBox);
		log.info("User enter text");
		
		clickElement(driver, selectDatePicker);
		log.info("User clicks date picker");
		
		clickElement(driver, travelDate);
		log.info("User selects trave date");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		clickElement(driver, searchBtn);
		log.info("User clicks search button");
		
		takeScreenShot(driver);
		
		Assert.assertTrue("Flight listing is not Present", verifyFlightListing(driver));
		log.info("User verified flight listing");
		
		driver.quit();
		log.info("<------Kill the driver------->");
		
	}
	
}
