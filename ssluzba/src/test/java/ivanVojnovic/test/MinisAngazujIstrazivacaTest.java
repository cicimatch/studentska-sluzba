package ivanVojnovic.test;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ivanVojnovic.pages.LoginPage;
import ivanVojnovic.pages.SuccessModalPage;
import ivanVojnovic.pages.MenuPage;
import ivanVojnovic.pages.IstrazivaciListPage;
import ivanVojnovic.pages.IstrazivaciCreationPage;
import ivanVojnovic.pages.InstitucijaOsnovniPage;
import ivanVojnovic.pages.IstrazivaciAngazujModalPage;

@Test
public class MinisAngazujIstrazivacaTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private SuccessModalPage successModalPage;
	private MenuPage menuPage;
	private String baseUrl;
	private IstrazivaciListPage istrazivaciListPage;
	private IstrazivaciCreationPage istrazivaciCreationPage;
	private InstitucijaOsnovniPage institucijaOsnovniPage;
	private IstrazivaciAngazujModalPage istrazivaciAngazujModalPage;

	@BeforeMethod
	public void setupSelenium() {
		baseUrl = "http://park.ftn.uns.ac.rs:8080/#/";
		driver = new FirefoxDriver();
		// imlicit wait 1 sec
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// ovde uveličavamo prozor browsera
		// driver.manage().window().setSize(new Dimension(1024, 768));
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);

		// Instanciranje stranica
		loginPage = new LoginPage(driver);
		successModalPage = new SuccessModalPage(driver);
		menuPage = new MenuPage(driver);
		istrazivaciListPage = new IstrazivaciListPage(driver);
		istrazivaciCreationPage = new IstrazivaciCreationPage(driver);
		institucijaOsnovniPage = new InstitucijaOsnovniPage(driver);
		istrazivaciAngazujModalPage = new IstrazivaciAngazujModalPage(driver);
	}
	public void AngazujIstrazivaca() {
		// assertuje da je baseUrl+login === trenutnom URL-u
		assertEquals(baseUrl + "login", driver.getCurrentUrl());

		// assertuje da su se pojavili buttons i polja
		assertTrue(loginPage.getUserName().isDisplayed());
		assertTrue(loginPage.getPassword().isDisplayed());
		assertTrue(loginPage.getSignInBtn().isDisplayed());

		// popunjavanje login-a  
		loginPage.login("ivanvojnovic7@gmail.com", "JQnnUEf9Ai5XycFMnKjK");

		// Assertujem da sam se ulogovao i da sam prešao na glavnu stranu
		WebElement formaOsnovna = institucijaOsnovniPage.getCelaForma();
		assertTrue(formaOsnovna.isDisplayed());
		
		istrazivaciCreationPage.getIstrazivaci().click();
		// proverimo da li smo na pravoj stranici
		assertTrue(istrazivaciCreationPage.getIstrazivaci().isDisplayed());

		// potvrda da se angažuj modalni dijalog pojavio
		assertTrue(istrazivaciAngazujModalPage.getModal().isDisplayed());		
		// odemo na angažovanja page
		istrazivaciAngazujModalPage.getModal().click();
		
		// provera validnosti forme
		assertTrue(istrazivaciAngazujModalPage.getZvanje().isDisplayed());
		assertTrue(istrazivaciAngazujModalPage.getFunkcija().isDisplayed());
		assertTrue(istrazivaciAngazujModalPage.getDatumOd().isDisplayed());
		assertTrue(istrazivaciAngazujModalPage.getDatumDo().isDisplayed());
		assertTrue(istrazivaciAngazujModalPage.getAngazujBtn().isDisplayed());
		assertTrue(istrazivaciAngazujModalPage.getOsoba().isDisplayed());
		
		// dodavanje angažovanja
		istrazivaciAngazujModalPage.setOsoba("Sima Simic");
		
		WebElement istrazivacRow = istrazivaciListPage.getIstrazivacRowByPrezime("Simic");
		String rowData = istrazivacRow.getText();
		assertTrue(rowData.contains("Sima Simic"));
		
		istrazivaciListPage.getIstrazivacRowByPrezime("Simic").click();
		
		istrazivaciAngazujModalPage.setZvanje("Asistent");
		istrazivaciAngazujModalPage.setDatumOd("10.01.2016");
		istrazivaciAngazujModalPage.setProcenatZaposlenosti("13");
		istrazivaciAngazujModalPage.getAngazujBtn().click();
		
		
		assertTrue(successModalPage.isPresentModal());
		successModalPage.exitModal();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ExpectedCondition eC = new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver d) {
	            return (!successModalPage.isPresentModal());
	          }
	        };

	    wait.until(eC);
	    assertFalse(successModalPage.isPresentModal());
		
		// prelazak na stranicu sa tabelom
		menuPage.getIstrazivaciLink().click();
		assertTrue(istrazivaciListPage.getIstrazivaciTable().isDisplayed());
		
		WebElement istrazivaciRow = istrazivaciListPage.getIstrazivacRowByPrezime("Simic");
		String rowsData = istrazivaciRow.getText();
		assertTrue(rowsData.contains("Sima Simic"));
		
		// odjava. Odlazak na pocetnu stranu. Možda i nisam morao ovo, al' ajde 
		menuPage.getGrb().click();
		menuPage.getOdjava().click();
		
		
	}
	
	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		driver.quit();
	}
	


}
