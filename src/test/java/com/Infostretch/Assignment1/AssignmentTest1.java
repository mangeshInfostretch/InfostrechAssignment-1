package com.Infostretch.Assignment1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
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
        DateFormat df = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss aa");
        Date dateobj = new Date();
        String path = ".\\log\\testlog".concat(df.format(dateobj).toString().toString()).concat(".log");
        System.out.println(path);
        path=path.replace(":", "");
        path=path.replace(" ", "-");
        
        Properties props = new Properties();
        PropertiesConfiguration properties = new PropertiesConfiguration("log4j.properties");
        properties.setProperty("log4j.appender.R.File", path);
        properties.save();

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
