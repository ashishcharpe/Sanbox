package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class PaymentPage extends TestBase {

	// Object repository
	@FindBy(xpath = "//a[@class='select-card payment-options']")private WebElement tarjeta;
	@FindBy(xpath = "//label[@for='radio-c']")private WebElement usar_nueva_tarjeta;
	@FindBy(xpath = "//input[@id='cardnumberunique']")private WebElement card_Number;
	@FindBy(xpath = "//input[@data-qa='mes-input']")private WebElement month;
	@FindBy(xpath = "//input[@data-qa='expyear-input']")private WebElement date;
	@FindBy(xpath = "//input[@data-qa='cvv-input']")private WebElement cvv;
	@FindBy(xpath = "//input[@class='form-control email preventChromeAutofill']")private WebElement email;
	@FindBy(xpath = "//button[@id='paylimit']")private WebElement pagar_con_tarjeta_Btn;
	@FindBy(xpath = "//input[@id='usrname']")private WebElement popup_mail_TextBox;
	@FindBy(xpath = "//input[@id='psw']")private WebElement popup_pswd_TextBox;
	//@FindBy(xpath = "not getting xpath")private WebElement captcha_chkBox; // find x path by axes 
	@FindBy(xpath = "//button[@type='submit']")private WebElement submit_Btn;
	@FindBy(xpath = "//a[text()='¿Olvidaste tu contraseña?']")private WebElement link;
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Methods 
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public void makePayment() throws EncryptedDocumentException, IOException, InterruptedException
	{
		tarjeta.click();
		Thread.sleep(2000);
		usar_nueva_tarjeta.click();
		//Thread.sleep(2000);
		card_Number.click();
		Thread.sleep(2000);
		card_Number.sendKeys(readExcelFile(3, 0));
//		 WebDriverWait wait = new WebDriverWait(driver, 10);
//		    WebElement cardElement = wait.until(ExpectedConditions.(card_Number));
//		    cardElement.click();
//		    cardElement.sendKeys("123");
		Thread.sleep(2000);
		month.sendKeys(readExcelFile(3, 1));
		Thread.sleep(2000);
		date.sendKeys(readExcelFile(3, 2));
		Thread.sleep(2000);
		cvv.sendKeys(readExcelFile(3, 3));
		Thread.sleep(2000);
		email.sendKeys(readExcelFile(3, 4));
		Thread.sleep(2000);
		pagar_con_tarjeta_Btn.click();
		Thread.sleep(2000);
		popup_mail_TextBox.sendKeys(readPropertyFile("Mail"));
		Thread.sleep(2000);
		popup_pswd_TextBox.sendKeys(readPropertyFile("Password"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", link);
		Thread.sleep(2000);
		captcha_chkBox.click();
		Thread.sleep(2000);
		submit_Btn.click();
		
	}
	
}
