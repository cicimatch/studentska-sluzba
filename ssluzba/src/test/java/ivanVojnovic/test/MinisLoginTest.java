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
import ivanVojnovic.pages.IstrazivaciAngazujModalPage;
import ivanVojnovic.pages.InstitucijaOsnovniPage;

public class MinisLoginTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private String baseUrl;
	private InstitucijaOsnovniPage institucijaOsnovniPage;

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
		institucijaOsnovniPage = new InstitucijaOsnovniPage(driver);
	}

	@Test
	public void login() {

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
		
	}

	@AfterMethod
	public void closeSelenium() {
		driver.quit();
	}
	
}
