package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Base;

public class Register extends Base {

	WebDriver driver;

	public Register(WebDriver rdriver) {

//		this.driver = driver;
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "newUser")
	WebElement newUser_btn;

	@FindBy(id = "firstname")
	WebElement firstName;

	@FindBy(id = "lastname")
	WebElement lastName;

	@FindBy(id = "userName")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
	WebElement captcha;

	@FindBy(id = "register")
	WebElement register_btn;

	public void clickUser_btn() {

		ClickUsingJS(newUser_btn, driver);
		/*
		 * JavascriptExecutor JS = (JavascriptExecutor)driver;
		 * JS.executeScript("arguments[0].click()", newUser_btn);
		 */
	}

	public void enterRegisterDetails(String firstN, String lastN, String userN, String pass)
			throws InterruptedException {
		firstName.sendKeys(firstN);
		Thread.sleep(1000);
		lastName.sendKeys(lastN);
		Thread.sleep(1000);
		userName.sendKeys(userN);
		Thread.sleep(1000);
		password.sendKeys(pass);
		Thread.sleep(1000);

	}

	public void handleCaptcha() {
		driver.switchTo().frame(captcha);

		ClickUsingJS(captcha, driver);
	}

	public void SubmitRegisteration() {
		ClickUsingJS(register_btn, driver);

	}

}
