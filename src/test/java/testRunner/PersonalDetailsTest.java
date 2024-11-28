package testRunner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.PersonalDetails;
import utility.Base;
import utility.Constants;

public class PersonalDetailsTest extends Base {

	PersonalDetails personaldetails;
	
	

	@BeforeTest
	public void SetUp() {
		launchApp();		
		driver.get(Constants.AppUrl);	
		logger.info("launching  browser");
	}

	@Test
	public void verifyPerSonalDetails() throws Exception {
		Thread.sleep(3000);
		logger.info("Test started");
		personaldetails = new PersonalDetails(driver);
		personaldetails.enterUserName(Constants.FullName);
		personaldetails.enterEmailAddresse("Automation.Tester@gmail.com");
		personaldetails.enterCurrentAddress("ABC Chowk, Raipur");
		personaldetails.enterpermanentAddress("ABC Chowk, Raipur");
		personaldetails.submitForm();
		personaldetails.confirmsumittedDetails();
		personaldetails.validateDetails(Constants.FullName);
	}

	@AfterTest
	public void closeApp() throws Exception {
		// close the browser
		logger.info("closing Application");
		Thread.sleep(2000);
		driver.quit();

	}

}
