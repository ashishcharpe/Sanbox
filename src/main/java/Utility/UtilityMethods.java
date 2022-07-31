package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;

import Base.TestBase;

public class UtilityMethods extends TestBase {

	public void screenShot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\ashish\\Eclips Workplace new\\YourLagaAutomationTest\\ScreenShots\\photo.jpg");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	
	
}
