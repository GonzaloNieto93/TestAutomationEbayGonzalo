package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageArticulo {

	private WebDriver driver;
	private By articleField;
	private By buttonField;
	
	public PageArticulo(WebDriver driver)
	{
		//Creamos variables que se correspondan al campo donde realizamos la busqueda y al boton para buscar.
		this.driver = driver;
		articleField = By.name("_nkw");
		buttonField = By.id("gh-btn");
	}
	
	public void setearArticulo(String articulo)
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(articleField).sendKeys(articulo);
		driver.findElement(buttonField).click();

	}
}
