package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;

public class Invalidlogin extends BaseTest  {
	
	@Test
	
	public void invalidfacebook () throws Throwable{
		
		driver.findElement(By.name(objectrepo.getProperty("emailid"))).sendKeys(exceldata.getData(0, 2, 0));
		driver.findElement(By.name(objectrepo.getProperty("password"))).sendKeys(exceldata.getData(0, 2, 1));
		driver.findElement(By.name(objectrepo.getProperty("name"))).click();
		
		Thread.sleep(5000);
		
		
		
		
		
		
		//boolean isloginpagedisplayed = driver.findElement(By.xpath(objectrepo.getProperty("invalidlogin"))).isDisplayed();
		
		//whatever result (true or false) came in this, then accordingly will pass or fail.
		//Assert.assertTrue(isloginpagedisplayed);
		
		//OR
		
		/*if(isloginpagedisplayed) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}*/
	
					//OR
		
		/*String actual = driver.findElement(By.xpath(objectrepo.getProperty("invalidlogin"))).getText();
		
		String expected = "Log in to Facebook";
		
		Assert.assertEquals(actual, expected);*/
	}
		
		
	
	
	
	
		
	
	
	

}
