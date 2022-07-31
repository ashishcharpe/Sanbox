package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;

	public String readPropertyFile(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\ashish\\Eclips Workplace new\\Sanbox\\src\\main\\java\\Configuration\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}

	public void initializeBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ashish\\Eclips Workplace new\\Sanbox\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(readPropertyFile("Url"));

	}

	public String readExcelFile(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream excel = new FileInputStream("C:\\Users\\ashish\\Eclips Workplace new\\Sanbox\\TestData\\Sanbox.xlsx");
		Sheet data = WorkbookFactory.create(excel).getSheet("Sheet1");
		String eValue = data.getRow(row).getCell(cell).getStringCellValue();
		return eValue;
	}

}
