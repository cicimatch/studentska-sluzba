package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ivanVojnovic.pages.Utils;

public class IstrazivaciAngazujModalPage {

	private WebDriver driver;

	public IstrazivaciAngazujModalPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// modal iskače
	public WebElement getModal() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='addctrl.addConnection()']"), 10);
	}

	public WebElement getOsoba() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@placeholder='Pretraži osobe']"), 10);
	}	

	public void setOsoba(String osoba) {
		WebElement osobaPolje = this.getOsoba();
		osobaPolje.sendKeys(osoba);
	}
	
	public WebElement getOsobaPadajuciMeni() {
		return Utils.waitForElementPresence(driver, By.id("typeahead-2794-2084"), 10);
	}	

	// zvanje (može Value-Zvanje da bude Profesor, ili Saradnik u nastavi, ili Asistent)
	public WebElement getZvanje() {
		return Utils.waitForElementPresence(driver, By.xpath("//option [contains(text(),'Izaberite zvanje')]"), 10);
	}

	public void setZvanje(String zvanje) {
		WebElement zvanjePolje = this.getZvanje();
		zvanjePolje.sendKeys(zvanje);
	}

	// funkcija (može Value-Funkcija da bude Dekan)
	public WebElement getFunkcija() {
		return Utils.waitForElementPresence(driver, By.xpath("//option [contains(text(),'Izaberite funkciju')]"), 10);
	}

	public void setFunkcija(String funkcija) {
		WebElement funkcijaPolje = this.getFunkcija();
		funkcijaPolje.sendKeys(funkcija);
	}

	// datum OD (obavezno polje) - format datuma dd.MM.yyyy
	public WebElement getDatumOd() {
		return Utils.waitForElementPresence(driver,
				By.xpath("//em-date-time-picker [@name='startDate']/span/div/input"), 10);
	}

	public void setDatumOd(String datum) {
		WebElement datumPolje = this.getDatumOd();
		datumPolje.clear();
		datumPolje.sendKeys(datum);
	}
	
	public WebElement getDatumOdError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[text()='Unesite datum angažovanja.']"),
				10);
	}

	// datum DO - format datuma dd.MM.yyyy
	public WebElement getDatumDo() {
		return Utils.waitForElementPresence(driver, By.xpath("//em-date-time-picker [@name='endDate']/span/div/input"),
				10);
	}

	public void setDatumDo(String datum) {
		WebElement datumPolje = this.getDatumDo();
		datumPolje.clear();
		datumPolje.sendKeys(datum);
	}
	
	// procenat zaposlenosti u organizaciji
	public WebElement getProcenatZaposlenosti() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='employmentPercentage']"), 10);

	}
	public void setProcenatZaposlenosti(String procenat) {
		WebElement pZ = this.getProcenatZaposlenosti();
		pZ.clear();
		pZ.sendKeys(procenat);

	}

	// buttons
	public WebElement getAngazujBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='addctrl.savePersonConnection(Persons)']"), 10);
	}

	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='addctrl.cancel(Persons)')]"), 10);
	}
	

}
