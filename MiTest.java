package testPropio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageArticulo;
import pages.PageLogin;
import pages.PageLogon;
import pages.PageMarca;
import pages.PageReservation;
import pages.PageTalle;
import pages.PageTipoEnvio;

public class MiTest {
	
	private WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Agrego el lugar donde se encuentra el web driver
		driver = new ChromeDriver();
		//Punto 1
		driver.navigate().to("https://www.ebay.com/"); 
		Helpers helper = new Helpers();
		helper.sleepSeconds(2);
		
	/*System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Agrego el lugar donde se encuentra el web driver
	driver = new ChromeDriver();
	driver.navigate().to("http://newtours.demoaut.com/");
	
	Helpers helper = new Helpers();
	helper.sleepSeconds(2);
	*/
	}
	
	@Test(enabled=false)
	public void miPrueba()
	{	
		PageLogin pageLogin = new PageLogin(driver);
		PageLogon pageLogon = new PageLogon(driver);
		pageLogin.login("gonzalo","123456");
		pageLogon.assertLogonPage();
		//VERIFICAR QUE GONZALO 123456 FUE CREADO
		//voy a flight finder igual que con asdasd asdasd
	//IMPORTANTE: al hacerlo en pageLogin veo que no me manda a la misma pantalla ue antes!!!
	}
	
	@Test(enabled=false)
	public void miPruebados()
	{
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("asdasd","asdasd");
		pageReservation.assertPage();
		//VERIFICAR QUE GONZALO 123456 FUE CREADO
		//CREO CUENTA QUE FUNCIONA:
		// asdasd asdads -->voy a flight finder igual que con gonzalo	
	//IMPORTANTE: creo que este caso no lo corre porque
	}
	
	@Test(enabled=false) //RECORDA, QUE ESTOS DE NEWTOURS NO VAN A ANDAR PORQUE EN EL BEFORE NO LAUNCHEAS NEWTOURS.COM!
	public void miPruebatres()
	{
		PageLogin pageLogin = new PageLogin(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("gonzalo93", "gonzalo93");
		pageReservation.selectPassengers(2);
		pageReservation.selectFromPort(3);
		pageReservation.selectToPort("London");
		
	//aplico el IMPLICIT WAIT del 5to video
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//si en 10 segundos no cargo, timeout. Si en 2 segundos cargo, va a salir de aca y seguir en la ejec del programa
		
		//El EXPLICIT WAIT, espera que un elemento exista, sea clickleable, etc.
	}
	
	@Test
	public void miPruebaCuatro()
	{	
		//Punto 2
		PageArticulo paginaParaSeleccionarArticulo = new PageArticulo(driver);
		paginaParaSeleccionarArticulo.setearArticulo("shoes");
		//Cambia de pagina, luego de escribir shoes https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR12.TRC2.A0.H0.Xshoes.TRS0&_nkw=shoes&_sacat=0
		
		//Punto 3
		PageMarca paginaConMarcaSeleccionada = new PageMarca(driver);
		paginaConMarcaSeleccionada.setearMarca();
		//driver.findElement(By.xpath("//*[@id=\"w3-w0-w2-w2-w6\"]/a/span[1]")).click(); //Checkbox: seleccionar PUMA (buscarlo)
		//helper.sleepSeconds(3);
		//Vamos a otra pagina, luego de seleccionar brand PUMA https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&rt=nc&Brand=PUMA&_dcat=93427
		
		PageTipoEnvio paginaConTipoDeEnvio = new PageTipoEnvio(driver);
		paginaConTipoDeEnvio.seleccionarMetodoEnvio();
		//driver.findElement(By.xpath("//*[@id=\"w3-w0-multiselect[5]\"]/a/span[1]")).click(); //clickeo la opcion de ENVIO GRATIS
		// Cambia de pagina https://www.ebay.com/sch/i.html?_from=R40&_nkw=shoes&_sacat=0&Brand=PUMA&_dcat=93427&rt=nc&LH_FS=1
		//helper.sleepSeconds(2);
	
		//Punto 4, 5, 6, 7, 8 , 9 y 10
		PageTalle paginaConTalleSeleccionado = new PageTalle(driver);
		paginaConTalleSeleccionado.seleccionarTalle();
		paginaConTalleSeleccionado.verificarExistenciaElementos();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
