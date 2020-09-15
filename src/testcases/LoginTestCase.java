package testcases;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import core.BaseTest;

public class LoginTestCase extends BaseTest {

	@Test

	public void wordpress() {

		driver.findElement(By.name(objectrepo.getProperty("emailid"))).sendKeys(exceldata.getData(0, 1, 0));
		driver.findElement(By.name(objectrepo.getProperty("password"))).sendKeys(exceldata.getData(0, 1, 1));
		driver.findElement(By.name(objectrepo.getProperty("name"))).click();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
	
	}

}
