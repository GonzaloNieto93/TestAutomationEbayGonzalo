package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageTipoEnvio {
	private WebDriver driver;
	private By tipoDeEnvio;
	
	public PageTipoEnvio(WebDriver driver)
	{
		this.driver = driver;
		//tipoDeEnvio = By.id("w_1544183432319_cbx");
		tipoDeEnvio = By.xpath("//span[contains(text(),'gratis')]/preceding-sibling::input");
		//La primera vez corrio bien con todo el texto... despues no y ahora volvio a correr bien (hasta el proximo punto),
		//pero con la palabra gratis. Supuse que era un tema de '' para CHARS y no STRINGS
		// //span[contains(text(),'PUMA')]/preceding-sibling::input
	}
	
	public void seleccionarMetodoEnvio()
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(tipoDeEnvio).click();
	}
}
