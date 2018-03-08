package com.Infostretch.Assignment1;

import org.openqa.selenium.By;

public interface PageFile {

	By flightTab = By.xpath("//span[contains(text(),'Flights')]");
	By oneWayRadioBtn = By.id("flight-type-one-way-label");
	By flightOriginTxtBox = By.id("flight-origin");
	By flightDestinationTxtBox = By.id("flight-destination");
	By selectDatePicker = By.xpath("//span[@class='icon icon-calendar']");
	By travelDate = By.xpath("//button[@class='datepicker-cal-date' and @data-year='2018' and @data-month='2' and @data-day='13']");
	By searchBtn = By.id("search-button");
	By flightList = By.id("flightModuleList");
	
}
