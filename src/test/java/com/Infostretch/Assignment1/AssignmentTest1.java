package com.Infostretch.Assignment1;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Unit test for simple App.
 */
public class AssignmentTest1 extends BaseClass{
	
	public static WebDriver driver=null;
	
	public static void main(String[] args) throws IOException, ConfigurationException {
		
	    Logger log=Logger.getLogger("AssignmentTest1");
	    
        // configure log4j properties file
        PropertyConfigurator.configure("log4j.properties");
        
        //getting current date and time using Date class
        String logsPath = getPathWithCurrentDateAndTime();
        
        //Set path of logs in properties file
        setPathInPropertiesFile(logsPath);
        
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
