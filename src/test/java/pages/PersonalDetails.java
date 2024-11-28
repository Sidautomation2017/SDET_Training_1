package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PersonalDetails {
	
	WebDriver driver;
public PersonalDetails(WebDriver rdriver) {
		
		
//		this.driver = driver;
		driver = rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}

	@FindBy(id = "userName")
	WebElement fullName;
	
	@FindBy(id = "userEmail")
	WebElement emailAddress;
	
	@FindBy(id = "currentAddress")
	WebElement currentAddress;
	
	@FindBy(id = "permanentAddress")
	WebElement permanentAddress;
	
	
	@FindBy(id = "submit")
	WebElement btn_submit;
	
	
	
	@FindBy(id = "output")
	WebElement output;
	

	@FindBy(id = "name")
	WebElement fullNameData;
	
	
	
	
	

	
	/*
	WebElement textBox=driver.findElement(By.id("userName"));
	
	JS.executeScript("arguments[0].click()", textBox);

	Thread.sleep(2000);*/
	
	public void enterUserName(String uName) {
		
//		driver.findElement(txtUserName).sendKeys(uName);
		fullName.sendKeys(uName);
		
	}
	
public void enterEmailAddresse(String email) {
		
//		driver.findElement(txtUserName).sendKeys(uName);
	emailAddress.sendKeys(email);
		
	}




public void enterCurrentAddress(String address2) {
	
//	driver.findElement(txtUserName).sendKeys(uName);
	currentAddress.sendKeys(address2);
	
}

public void enterpermanentAddress(String address1) {
	
//	driver.findElement(txtUserName).sendKeys(uName);
	permanentAddress.sendKeys(address1);
	
}

public void submitForm() {
	JavascriptExecutor JS = (JavascriptExecutor)driver;
	JS.executeScript("arguments[0].click()", btn_submit);
	
}



	public boolean confirmsumittedDetails() {
			return output.isDisplayed();
		}
	
	
	public void validateDetails(String fullname) {
		Assert.assertTrue(fullNameData.getText().contains(fullname));
		
	}
	

	
	
	
	
	
	


}
