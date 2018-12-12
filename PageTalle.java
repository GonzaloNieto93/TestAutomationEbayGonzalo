package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helpers.Helpers;

public class PageTalle {

	private WebDriver driver;
	private By talle;
	private By cantidadDeResultados;
	
	public PageTalle(WebDriver driver)
	{
		
		this.driver = driver;
		talle = By.xpath("//span[contains(text(),'10')]/preceding-sibling::input");
		//cantidadDeResultados = By.className("srp-controls__count-heading");
		cantidadDeResultados = By.xpath("//h1[contains(text(),'resultados')]");
		//By.xpath("//h3[@class='s-item__title' and contains(text(), \"Para Hombre Puma V-Kon II GCI FG Botas De Fútbol De Cuero Negro 101726 02\")]");
	}
	
	public void seleccionarTalle()
	{
		String resultados;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		driver.findElement(talle).click();
		
		//Punto 5
		resultados = driver.findElement(cantidadDeResultados).getText();
		System.out.println(resultados);
		
		/*El ir a cierta pestaña, para clickear, y luego aparezca el elemento es muy rebuscado...
		Y como el objetivo principal no es probar ese click y tampoco queremos perder mucho tiempo buscando eso,
		lo que hacemos es concatenar la url anterior, con la url del precio + envio mas bajo primero.
		https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&Brand=PUMA&LH_FS=1&rt=nc&US%2520Shoe%2520Size%2520%2528Men%2527s%2529=10&_dcat=93427
		https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&Brand=PUMA&LH_FS=1&      US%2520Shoe%2520Size%2520%2528Men%2527s%2529=10&_dcat=93427&_sop=15
		System.out.println(driver.getCurrentUrl());
		el metodo de arriba me da otro link...
		*/
		
		//Punto 6
		String urlPaginaOrdenadaPorMenorPrecio = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&Brand=PUMA&LH_FS=1&US%2520Shoe%2520Size%2520%2528Men%2527s%2529=10&_dcat=93427&_sop=15";
		driver.navigate().to(urlPaginaOrdenadaPorMenorPrecio);
		Helpers helper = new Helpers();
		helper.sleepSeconds(2);	
	
		
	}
		
	public void verificarExistenciaElementos()
	{
		
		ArrayList<String> arrayElementos = new ArrayList<String>();
		ArrayList<String> arrayPrecios = new ArrayList<String>();
		By elemento1, elemento2, elemento3, elemento4, elemento5, precio1, precio2, precio3, precio4, precio5;
		String e1,e2,e3,e4,e5,p1,p2,p3,p4,p5;
		/*
		elemento1 = By.xpath("//h3[@class='s-item__title' and contains(text(), \"Puma Pop Cat diapositivas (36026523) Sandalias De Playa Flip Flop Zapatos Zapatillas diapositiva\")]");
		elemento2 = By.xpath("//h3[@class='s-item__title' and contains(text(), \"Zapatillas Para Correr Para Hombre Puma 10 EE. UU.\")]");
		elemento3 = By.xpath("//h3[@class='s-item__title' and contains(text(), \"Puma Divecat Unisex Adulto Flip Flop Zapatos de Ducha y Baño\")]");
		elemento4 = By.xpath("//h3[@class='s-item__title' and contains(text(), \"Puma Flexracer Para Hombre Gris Correr Tenis 360580-04\")]");
		elemento5 = By.xpath("//h3[@class='s-item__title' and contains(text(), \"Para Hombre Puma V-Kon II GCI FG Botas De Fútbol De Cuero Negro 101726 02\")]");
		*/
		elemento1 = By.xpath("//h3[contains(text(),'Puma Pop Cat diapositivas (36026523) Sandalias De Playa Flip Flop Zapatos Zapatillas diapositiva')]");
		elemento2 = By.xpath("//h3[contains(text(),'Zapatillas Para Correr Para Hombre Puma 10 EE. UU.')]");
		elemento3 = By.xpath("//h3[contains(text(),'Puma Divecat Unisex Adulto Flip Flop Zapatos de Ducha y Baño')]");
		elemento4 = By.xpath("//h3[contains(text(),'Puma Flexracer Para Hombre Gris Correr Tenis 360580-04')]");
		elemento5 = By.xpath("//h3[contains(text(),'Para Hombre Puma V-Kon II GCI FG Botas De Fútbol De Cuero Negro 101726 02')]");
		
		precio1 = By.xpath("//span[contains(text(),'USD32.90')]");
		precio2 = By.xpath("//span[contains(text(),'USD45.00')]");
		precio3 = By.xpath("//span[contains(text(),'USD55.56')]");
		precio4 = By.xpath("//span[contains(text(),'USD58.89')]");
		precio5 = By.xpath("//span[contains(text(),'USD59.89')]");
		
		e1=driver.findElement(elemento1).getText();
		e2=driver.findElement(elemento2).getText();
		e3=driver.findElement(elemento3).getText();
		e4=driver.findElement(elemento4).getText();
		e5=driver.findElement(elemento5).getText();
		
		p1=driver.findElement(precio1).getText();
		p2=driver.findElement(precio2).getText();
		p3=driver.findElement(precio3).getText();
		p4=driver.findElement(precio4).getText();
		p5=driver.findElement(precio5).getText();
		
		/*
		for(int i=0;i<5;i++)
		{
			arrayElementos.add("e"+i);
			arrayPrecios.add("p"+i);
		}
		*/
		arrayElementos.add(e1);
		arrayElementos.add(e2);
		arrayElementos.add(e3);
		arrayElementos.add(e4);
		arrayElementos.add(e5);
		
		arrayPrecios.add(p1);
		arrayPrecios.add(p2);
		arrayPrecios.add(p3);
		arrayPrecios.add(p4);
		arrayPrecios.add(p5);
		
		
		//Punto 8
		System.out.println("Elementos:" +arrayElementos);
		System.out.println("Precios:" +arrayPrecios);
		
		//Punto 9
		Collections.sort(arrayElementos);
		System.out.println("Elementos ordenados alfabeticamente de manera ascendente:"+arrayElementos );
		
		//Punto 10
		Collections.sort(arrayPrecios, Collections.reverseOrder());
		System.out.println("Precios ordenados de manera descendente:"+arrayPrecios);
	}

}
