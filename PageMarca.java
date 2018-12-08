package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageMarca {
	private WebDriver driver;
	private By marcaCheckBox;
	
	public PageMarca(WebDriver driver)
	{
	this.driver = driver;
	//marcaCheckBox = By.id("w_1544182105051_cbx"); //Id debinspeccionar el checkbox en si.
	//marcaCheckBox = By.xpath("//*[@id=\"w_1544186310588_cbx\"]");//xpath de inspeccionar el checkbox en si.
	//marcaCheckBox = By.className("cbx x-refine__multi-select-cbx");//Clase de inspeccionar la palabra PUMA
	//marcaCheckBox = By.xpath("//*[@id=\"w3-w0-w2-w2-w6\"]/a/span[1]"); //Xpath resultante de inspeccionar la palabra PUMA 
	//Empezo a tirar error el xpath una vez modificado el PageTipoEnvio
	//marcaCheckBox = By.linkText("https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&rt=nc&Brand=PUMA&_dcat=93427");
	marcaCheckBox = By.xpath("//span[contains(text(),'PUMA')]/preceding-sibling::input");
	
	}
	
	public void setearMarca() {
	//WebDriverWait wait = new WebDriverWait(driver,10);
	//WebElement marca = wait.until(ExpectedConditions.presenceOfElementLocated(marcaCheckBox));
	//findElement no funciona con objetos del tipo WebElements...procedo a usar ImplicitWait
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.findElement(marcaCheckBox).click();
	
	Helpers helper = new Helpers();
	helper.sleepSeconds(4);
	//*[@id="w_1544182105051_cbx"]	
	}
}
