package com.Infostretch.Assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;

/**
 * Unit test for simple App.
 */
public class AssignmentTest1 extends BaseClass{
	
	public static WebDriver driver=null;
	
	public static void main(String[] args) throws IOException {
		
		//Initiate driver
		driver=intDriver();
		
		// Launch the application
		launchApp(driver);
		
		driver.findElement(flightTab).click();
		
		takeScreenShot(driver);
		
		driver.findElement(oneWayRadioBtn).click();
		
		driver.findElement(flightOriginTxtBox).sendKeys("Mumbai");
		
		driver.findElement(flightDestination).sendKeys("Delhi");
		
		driver.findElement(selectDatePicker).click();
		
		driver.findElement(travelDate).click();
		
		driver.findElement(searchBtn).click();
		
		Assert.assertTrue("Flight listing is not Present", verifyFlightListing(driver));
		
		driver.quit();
		
		System.out.println("TEST PASS");
		
	}
	
	
    

	
}
