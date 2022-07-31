package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class Recharge extends TestBase{

	// Object Repository
	@FindBy(xpath = "//img[@id='undostres_logo']")private WebElement logo;
	@FindBy(xpath = "//span[@class='icon-container topSpecialMobileIcon ']")private WebElement recarga_celular;
	@FindBy(xpath = "//input[@suggestmobile='mobile-numbers']")private WebElement numero_de_celular;
	@FindBy(xpath = "//input[@data-qa='celular-operator']")private WebElement operador;
	@FindBy(xpath = "//input[@data-qa='celular-amount']")private WebElement monto_de_recarga;
	@FindBy(xpath = "//button[@data-qa='celular-pay']")private WebElement siguienteBtn;
	@FindBy(xpath = "//li[@data-show='Telcel']")private WebElement telcel;
	@FindBy(xpath = "//li[@data-show='$10 (Recarga Saldo)']")private WebElement amt10;
	public Recharge()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods 
	
	public String verfyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public void rechargeModule() throws EncryptedDocumentException, IOException, InterruptedException
	{
		recarga_celular.click();
		numero_de_celular.sendKeys(readPropertyFile("MobileNumber"));
		Thread.sleep(2000);
		operador.click();
		Actions act = new Actions(driver);
		act.moveToElement(telcel).click().build().perform();
		Thread.sleep(2000);
		amt10.click();
		Thread.sleep(2000);
		siguienteBtn.click();
	}
	
	
}
