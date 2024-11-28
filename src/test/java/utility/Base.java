package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Base {

	public WebDriver driver;


	public  Logger logger;
	public void launchApp() {	
		
		
		String browser = Constants.Browser;		
		
		logger = Logger.getLogger("Logger started");
		PropertyConfigurator.configure(".\\testData\\log4j.properties");
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("execution on chrome browser");
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			System.out.println("execution on edge browser");
			driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("execution on firefox browser");
			driver = new FirefoxDriver();
		}
		
		else {
			
			System.out.println("================execution in default CHROME browser===========================");
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
	}
	
	
	public void ClickUsingJS(WebElement element, WebDriver driver) {
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click()", element);
		
	}

}

		
