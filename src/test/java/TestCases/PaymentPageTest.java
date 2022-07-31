package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.PaymentPage;
import Pages.Recharge;

public class PaymentPageTest extends TestBase {
	
	PaymentPage pp;
	Recharge r;
	@BeforeMethod
	public void setup() throws IOException, EncryptedDocumentException, InterruptedException
	{
		initializeBrowser();
		 r = new Recharge();
		pp = new PaymentPage();
		r.rechargeModule();
	}
	
	@Test
	public void verifyTitleTest()
	{
		String title = pp.verifyTitle();
		Assert.assertEquals(title, "undostres.com.mx - Recargas en línea Telcel, Movistar, Iusacell, Unefon, Nextel, Virgin, Cierto, Weex, TeleVía, PASE Urbano, IAVE, Viapass");
	}
	
	@Test
	public void makePaymentTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		pp.makePayment();
	}
	
//	@AfterMethod
//	public void exit()
//	{
//		driver.close();
//	}
}
