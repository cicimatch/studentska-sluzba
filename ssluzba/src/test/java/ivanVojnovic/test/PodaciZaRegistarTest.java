package ivanVojnovic.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ivanVojnovic.pages.LoginPage;
import ivanVojnovic.pages.SuccessModalPage;
import ivanVojnovic.pages.MenuPage;
import ivanVojnovic.pages.IstrazivaciCreationPage;
import ivanVojnovic.pages.InstPodaciZaProjektePage;
import ivanVojnovic.pages.InstitucijaOsnovniPage;

@Test
public class PodaciZaRegistarTest {

	private String baseUrl;
	private WebDriver driver;
	private LoginPage loginPage;
	private MenuPage menuPage;
	private IstrazivaciCreationPage istrazivaciCreationPage;
	private InstitucijaOsnovniPage institucijaOsnovniPage;
	private SuccessModalPage successModalPage;
	private InstPodaciZaProjektePage instPodaciZaProjektePage;

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

		loginPage = new LoginPage(driver);
		menuPage = new MenuPage(driver);
		istrazivaciCreationPage = new IstrazivaciCreationPage(driver);
		institucijaOsnovniPage = new InstitucijaOsnovniPage(driver);
		successModalPage = new SuccessModalPage(driver);
		instPodaciZaProjektePage = new InstPodaciZaProjektePage(driver);

	}

	public void testProjekat() {
		assertTrue(loginPage.getUserName().isDisplayed());
		assertTrue(loginPage.getPassword().isDisplayed());
		assertTrue(loginPage.getSignInBtn().isDisplayed());
		assertEquals("http://park.ftn.uns.ac.rs:8080/#/login", driver.getCurrentUrl());

		loginPage.getUserName().clear();
		loginPage.getPassword().clear();

		loginPage.setUserName("ivanvojnovic7@gmail.com");
		loginPage.setPassword("JQnnUEf9Ai5XycFMnKjK");
		loginPage.getSignInBtn().click();

		assertTrue(institucijaOsnovniPage.getCelaForma().isDisplayed());

		assertEquals("http://park.ftn.uns.ac.rs:8080/#/admin-institution/", driver.getCurrentUrl());

		istrazivaciCreationPage.getPodaciProjekat().click();

		assertTrue(instPodaciZaProjektePage.getCelaForma().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getRacun().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getIdMinistarstvo().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getIdMedjunarodniNivo().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getStatusInstitucije().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getOblastIstrazivanja().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getOdustaniBtn().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getSacuvajBtn().isDisplayed());

		// provera da li prikazuje poruke o grešci za prazna obavezna polja
		instPodaciZaProjektePage.getRacun().clear();
		instPodaciZaProjektePage.getSacuvajBtn().click();
		assertTrue(instPodaciZaProjektePage.getRacunError().isDisplayed());
		assertTrue(instPodaciZaProjektePage.getStatusInstitucijeError().isDisplayed());

		// provera za grešku kod nepravilnog formata broja racuna
		instPodaciZaProjektePage.setRacun("iiiiiii");
		instPodaciZaProjektePage.getSacuvajBtn().click();
		assertTrue(instPodaciZaProjektePage.getRacunFormatError().isDisplayed());

		// ispravan format broja racuna
		instPodaciZaProjektePage.setRacun("123-1234567890123-12");
		instPodaciZaProjektePage.getSacuvajBtn().click();
		assertFalse(instPodaciZaProjektePage.getRacunFormatError().isDisplayed());
		assertFalse(instPodaciZaProjektePage.getRacunError().isDisplayed());

		/** Nisam uspeo da sačuvam, jer ne mogu da izaberem status institucije.
		 *  Ali sam @Test mi je uspešan.
		 *  @author I.Vojnović
		 */
	}

	@AfterMethod
	public void closeSelenium() {
		// Shutdown the browser
		driver.quit();

	}

}
