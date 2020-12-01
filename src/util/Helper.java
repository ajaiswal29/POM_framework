package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	//Screenshot
	public static String captureScreenshot(WebDriver driver) {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshot = System.getProperty("user.dir") + "/Screenshot/wordpress" + getCurrentDateTime() +".png";

		try {

			org.openqa.selenium.io.FileHandler.copy(source, new File(screenshot));
			System.out.println("Screenshot captured");

		} catch (IOException e) {

			System.out.println("Exception while taking screesnhot" + e.getMessage());

		}
		return screenshot;

	}
		
	
	//Date and Time
	public static String getCurrentDateTime() {

		DateFormat customformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentDate = new Date();

		return customformat.format(currentDate);

	}

}
		
		
		

