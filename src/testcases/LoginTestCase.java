package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import core.BaseTest;

public class LoginTestCase extends BaseTest {

	@Test

	public void LIA() {

		driver.findElement(By.name("username")).sendKeys("ankit.jaiswal");
		
		driver.findElement(By.name("password")).sendKeys("Summer@12345");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
