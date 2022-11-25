package com.db.TestBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.db.PageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	public Logger logger;              //publically declared
	
	public LoginPage login;
	
	
	
	
	@BeforeClass
	public void start()
		{
			logger = Logger.getLogger("DalalStreet Framework");       //obj created
			PropertyConfigurator.configure("Log4j.properties");
			
			logger.info ("Execution started");
		}
		
		@AfterClass
		public void end()
			{
			logger.info ("Execution end");
			}
		
	
	
	
	
//----------------------------------------------------------------------------	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		String browser = "chroMe";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();              //can use directly in selenium 4.6.0 no need of system.setpropery
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();           //can use directly in selenium 4.6.0 no need of system.setpropery
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
		     driver = new EdgeDriver();            //can use directly in selenium 4.6.0 no need of system.setpropery
		}
		else
		{
			System.out.println("Please enter valid browser name");
		}
		
		logger.info ("Browser launched");
		
	    driver.get("https://apps.dalalstreet.ai/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		logger.info("URL , Maximize , Deletecookies and Provided Wait");
		

        }
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		//Thread.sleep(4000);
		driver.quit();
		logger.info("Browser closed");
		
	}
}