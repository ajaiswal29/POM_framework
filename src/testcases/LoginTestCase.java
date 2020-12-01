package testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;

import core.BaseTest;
import util.Helper;

public class LoginTestCase extends BaseTest {
	
	

	@Test(priority = 1)

	public void wordpress() throws Throwable {

		logger = report.createTest("Login to website");

		driver.findElement(By.name(objectrepo.getProperty("emailid"))).sendKeys(exceldata.getData(0, 1, 0));
		logger.log(Status.PASS, "Entering username");
		driver.findElement(By.name(objectrepo.getProperty("password"))).sendKeys(exceldata.getData(0, 1, 1));
		logger.log(Status.PASS, "Entering password");
		driver.findElement(By.name(objectrepo.getProperty("name"))).click();
		logger.log(Status.PASS, "Press Enter");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='//wordpress.org/download/']")).click();
		Thread.sleep(5000);
		WebElement drop = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']"));
		Actions act = new Actions (driver);
		act.moveToElement(drop).perform();
		driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/div/ul/li[3]")).click();
		//logger.pass("pass");
		//OR
		logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}
		
	/*@Test(priority = 2)
	public void logout() throws Throwable {
		// logout
		logger = report.createTest("logout");
		
		logger.fail("fail");
		
		
		

	}*/

}
