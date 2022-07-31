package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.Recharge;

public class RechargeTestCase extends TestBase {
	
	Recharge rec;
	@BeforeMethod
	public void setup() throws IOException
	{
		initializeBrowser();
		rec = new Recharge();
	}
	
	@Test
	
	public void verifyTitleTest()
	{
		String title = rec.verfyTitle();
		Assert.assertEquals(title, "UnDosTres - Recargas en línea Telcel, Movistar, AT&T, Unefon, Virgin, Bait, TeleVía, PASE, Boletos de Cine, Pagos CFE");
	}
	
	@Test
	
	public void verifyLogoTest()
	{
		boolean logo = rec.verifyLogo();
		Assert.assertEquals(logo, true);
	}
	
	@Test
	
	public void rechargeModuleTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		rec.rechargeModule();
	}
	
	
	@AfterMethod
	
	public void exit()
	{
		driver.close();
	}
	
}
