package testRunner;

import org.apache.log4j.Logger;
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
import pages.Register;
import utility.Base;
import utility.Constants;

public class RegisterToBooKStoreTest extends Base {

	Register register;

	@BeforeTest
	public void SetUp() {
		launchApp();	
		driver.get(Constants.LoginUrl);
		register=new Register(driver);
		logger.info("launching  browser");
	}

	@Test
	public void RegistertoBookStore() throws Exception {
		Thread.sleep(3000);
		logger.info("Test started");
		register.clickUser_btn();
		register.enterRegisterDetails(Constants.FirstName, Constants.LastName, Constants.UserID, Constants.Pass);
		Thread.sleep(2000);
		//register.handleCaptcha();
		register.SubmitRegisteration();		
		
	}

	@AfterTest
	public void closeApp() throws Exception {
		// close the browser
		logger.info("closing Application");
		Thread.sleep(2000);
		driver.quit();

	}

}
