package ivanVojnovic.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
import ivanVojnovic.pages.IstrazivaciAngazujModalPage;

public class ZadatakMinis1 {
	private WebDriver driver;
	private LoginPage loginPage;
	private SuccessModalPage successModalPage;
	private MenuPage menuPage;
	private String baseUrl;
	private IstrazivaciListPage istrazivaciListPage;
	private IstrazivaciCreationPage istrazivaciCreationPage;
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
		istrazivaciAngazujModalPage = new IstrazivaciAngazujModalPage(driver);
	}
	@Test
	public void Zadatak1() {
		// assertuje da je baseUrl+login === trenutnom URL-u
		assertEquals(baseUrl + "login", driver.getCurrentUrl());

		// assertuje da su se pojavili buttons i polja
		assertTrue(loginPage.getUserName().isDisplayed());
		assertTrue(loginPage.getPassword().isDisplayed());
		assertTrue(loginPage.getSignInBtn().isDisplayed());

		// popunjavanje login-a  
		loginPage.login("ivanvojnovic7@gmail.com", "JQnnUEf9Ai5XycFMnKjK");


		// odemo na istraživači page
		menuPage.getIstrazivaciLink().click();
		// proverimo da li smo na pravoj stranici
		assertEquals("http://park.ftn.uns.ac.rs:8080/#/persons", driver.getCurrentUrl());
		
		// ovde odlazim na istraživača. Assertujem ga i popunjavam
		istrazivaciListPage.getDodajIstrazivacaBtn().click();
		
		// da li su prikazana sva polja
		assertTrue(istrazivaciCreationPage.getIme().isDisplayed());
		assertTrue(istrazivaciCreationPage.getPrezime().isDisplayed());
		assertTrue(istrazivaciCreationPage.getImeRoditelja().isDisplayed());
		assertTrue(istrazivaciCreationPage.getTitulaIstrazivaca().isDisplayed());
		assertTrue(istrazivaciCreationPage.getDatumRodjenja().isDisplayed());
		assertTrue(istrazivaciCreationPage.getDrzavaRodjenja().isDisplayed());
		assertTrue(istrazivaciCreationPage.getMestoRodjenja().isDisplayed());
		assertTrue(istrazivaciCreationPage.getOpstinaRodjenja().isDisplayed());
		assertTrue(istrazivaciCreationPage.getDrzavaBoravista().isDisplayed());
		assertTrue(istrazivaciCreationPage.getMestoBoravista().isDisplayed());
		assertTrue(istrazivaciCreationPage.getOpstinaBoravista().isDisplayed());
		assertTrue(istrazivaciCreationPage.getUlicaIBroj().isDisplayed());
		assertTrue(istrazivaciCreationPage.getPol().isDisplayed());
		assertTrue(istrazivaciCreationPage.getJmbg().isDisplayed());
		assertTrue(istrazivaciCreationPage.getEmail().isDisplayed());
		assertTrue(istrazivaciCreationPage.getJmbg().isDisplayed());
		assertTrue(istrazivaciCreationPage.getTelefon().isDisplayed());
		assertTrue(istrazivaciCreationPage.getWeb().isDisplayed());
		assertTrue(istrazivaciCreationPage.getStatusIstrazivaca().isDisplayed());
		
		assertTrue(istrazivaciCreationPage.getSacuvajBtn().isDisplayed());
		
		//ovde ga popunjavam
		istrazivaciCreationPage.unosCeleForme("Mika", "Mikic", "Sava", "nema", "12.12.2012", "Srbija", "Novi Sad", "Novi Sad", "Srbija",
				"Novi Sad", "Novi Sad", "Sarajevska 3", "Muški", "1212012014551", "nesto@gmail", "021111777", "www.nesto.com", "Status 1");
		
		//vrši se provera da je uspešno dodat. Kroz modal, kojeg posle gasi
		assertTrue(successModalPage.getModal().isDisplayed());
		successModalPage.exitModal();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ExpectedCondition eC = new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver d) {
	            return (!successModalPage.isPresentModal());
	          }
	        };
	    wait.until(eC);
	    
		
		istrazivaciCreationPage.getAngazovanja().click();
		// proverimo da li smo na pravoj stranici
		assertTrue(istrazivaciCreationPage.getAngazovanja().isDisplayed());

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
		/*assertTrue(istrazivaciAngazujModalPage.getOsoba().isDisplayed());
		
		// dodavanje angažovanja
		istrazivaciAngazujModalPage.setOsoba("Mika Mikic");
		
		WebElement istrazivacRow = istrazivaciListPage.getIstrazivacRowByPrezime("Mikic");
		String rowData = istrazivacRow.getText();
		assertTrue(rowData.contains("Mika Mikic"));
		
		istrazivaciListPage.getIstrazivacRowByPrezime("Mikic").click();*/
		
		istrazivaciAngazujModalPage.setZvanje("Asistent");
		istrazivaciAngazujModalPage.setDatumOd("10.01.2016");
		istrazivaciAngazujModalPage.setProcenatZaposlenosti("13");
		istrazivaciAngazujModalPage.getAngazujBtn().click();
		
		
		assertTrue(successModalPage.isPresentModal());
		successModalPage.exitModal();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		ExpectedCondition eC1 = new ExpectedCondition<Boolean>() {
	          public Boolean apply(WebDriver d) {
	            return (!successModalPage.isPresentModal());
	          }
	        };

	    wait.until(eC1);
	    assertFalse(successModalPage.isPresentModal());
		
		// prelazak na stranicu sa tabelom
		menuPage.getIstrazivaciLink().click();
		assertTrue(istrazivaciListPage.getIstrazivaciTable().isDisplayed());
		
		WebElement istrazivaciRow = istrazivaciListPage.getIstrazivacRowByPrezime("Mikic");
		String rowsData = istrazivaciRow.getText();
		assertTrue(rowsData.contains("Mika Mikic"));
		
		
		
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
