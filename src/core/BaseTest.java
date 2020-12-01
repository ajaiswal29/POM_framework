package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.Excelconfig;
import util.Helper;

public class BaseTest {

	static public WebDriver driver;
	static public Properties config;
	static public Properties objectrepo;
	static public FileInputStream fis;
	static public FileInputStream Locator;
	static public Excelconfig exceldata;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeMethod
	
	//for parallel testing
	/*@Parameters("browser")
	public void init(String Browservalue) throws IOException {*/
	
	public void init() throws IOException {
		
		//select path of current working directory
		String Userpath = System.getProperty("user.dir");
		
		//Read data from excel
		exceldata = new Excelconfig(Userpath+"\\Data\\Testdata.xlsx");

		config = new Properties();
		objectrepo = new Properties();

		fis = new FileInputStream(Userpath + "\\src\\config\\config.properties");
		Locator = new FileInputStream(Userpath + "\\src\\objectrepo\\Locators.properties");

		config.load(fis);
		objectrepo.load(Locator);
		
		//Extent Reporting
		ExtentHtmlReporter extent = new ExtentHtmlReporter(Userpath+"\\Reports\\Login"+Helper.getCurrentDateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(extent);
		

		// Read from config.properties file
		String Browservalue = config.getProperty("Browser");
		
				
		if (Browservalue.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Userpath + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (Browservalue.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Userpath + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if (Browservalue.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", Userpath + "\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
		String URL = config.getProperty("url");
		driver.manage().window().maximize();
		
		driver.get(URL);
		

	}

	@AfterMethod

	public void Appclose() {
		driver.close();
		report.flush();
	}

}
