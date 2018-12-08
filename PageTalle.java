package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTalle {

	private WebDriver driver;
	private By talle;
	private By numeroResultados;
	private By ordenDeAparicion;
	private By ordenarPor;
	
	public PageTalle(WebDriver driver)
	{
		this.driver = driver;
		talle = By.xpath("//span[contains(text(),'10')]/preceding-sibling::input");
			//numeroResultados = By.xpath("//span[contains(text(),'resultados')]");
		
		//tipoDeEnvio = By.xpath("//span[contains(text(),'gratis')]/preceding-sibling::input");
		//Me aparecio un error de elemento no visible...debo ver como acceder a el (moviendo el mouse al "select"
		ordenarPor = By.className("srp-controls__control");
		ordenDeAparicion = By.xpath("//span[contains(text(),'bajo primero')]");
	}
	
	public void seleccionarTalle()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		driver.findElement(talle).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
			//WebElement cantidadResultados = driver.findElement(numeroResultados);
		//String cantidadResultados = driver.findElement(By.xpath("//span[contains(text(),'resultados')]")).getText();
		//Probe con String y WebElement pero no puedo mostrar...
			//System.out.println("Cantidad de elementos de la busqueda:" + cantidadResultados.getText());
		driver.findElement(ordenarPor).click();
		driver.findElement(ordenDeAparicion).click();
		
		
	}
}
