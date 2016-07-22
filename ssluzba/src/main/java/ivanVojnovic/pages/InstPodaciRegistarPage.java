package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ivanVojnovic.pages.Utils;

public class InstPodaciRegistarPage {
	private WebDriver driver;

	public InstPodaciRegistarPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCelaForma() {
		return Utils.waitForElementPresence(driver,By.xpath("//form[@name='Register']"),10);
	}
	// Podaci identifikacionog broja
	public WebElement getPib() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='pib']"), 10);
	}
	
	public void setPib(String pib) {
		WebElement pibPolje = this.getPib();
		pibPolje.clear();
		pibPolje.sendKeys(pib);
	}
	
	// Matični broj
	public WebElement getMaticni() {
		return Utils.waitForElementPresence(driver, By.name("maticniBroj"), 10);
	}
	
	public void setMaticni(String maticni) {
		WebElement maticniPolje = this.getMaticni();
		maticniPolje.clear();
		maticniPolje.sendKeys(maticni);
	}
	
	// Broj poslednje naučne akreditacije
	public WebElement getBpna() {
		return Utils.waitForElementPresence(driver, By.name("accreditationNumber"), 10);
	}
	
	public void setBpna(String bpna) {
		WebElement bpnaPolje = this.getBpna();
		bpnaPolje.clear();
		bpnaPolje.sendKeys(bpna);
	}
	
	// Datum poslednje naučne akreditacije
	public WebElement getDatum() {
		return Utils.waitForElementPresence(driver, By.name("accreditationDate"), 10);
	}

	public void setDatum(String datum) {
		WebElement datumPolje = this.getDatum();
		datumPolje.clear();
		datumPolje.sendKeys(datum);
	}
	
	// Naziv institucije iz akreditacije
	public WebElement getNiIa() {
		return Utils.waitForElementPresence(driver, By.name("accreditationNote"), 10);
	}

	public void setNiIa(String niIa) {
		WebElement niIaPolje = this.getNiIa();
		niIaPolje.clear();
		niIaPolje.sendKeys(niIa);
	}
	
	// Napomena o registru
	public WebElement getNor() {
		return Utils.waitForElementPresence(driver, By.name("note"), 10);
	}

	public void setNor(String nor) {
		WebElement norPolje = this.getNor();
		norPolje.clear();
		norPolje.sendKeys(nor);
	}
	
	// Vrsta institucije
	public Select selectVi() {
		return  new Select (Utils.waitForElementPresence(driver, By.name("institutionType"), 10));
	}
	public void setVi(String vi) {
		this.selectVi().selectByVisibleText(vi);
	}
	
	// Osnovna delatnost institucije
	public WebElement getOdi() {
		return Utils.waitForElementPresence(driver, By.id("s2id_autogen70"), 10);
	}

	public void setOdi(String odi) {
		WebElement odiPolje = this.getOdi();
		odiPolje.clear();
		odiPolje.sendKeys(odi);
	}
	
	// Osnivač
	public WebElement getOsnivac() {
		return Utils.waitForElementPresence(driver, By.name("founder"), 10);
	}

	public void setOsnivac(String osnivac) {
		WebElement osnivacPolje = this.getOsnivac();
		osnivacPolje.clear();
		osnivacPolje.sendKeys(osnivac);
	}
	
	// Datum osnivanja
	public WebElement getDatumO() {
		return Utils.waitForElementPresence(driver, By.name("date"), 10);
	}

	public void setDatumO(String datumO) {
		WebElement datumOPolje = this.getDatumO();
		datumOPolje.clear();
		datumOPolje.sendKeys(datumO);
	}
	
	// Broj rešenja o osnivanju
	public WebElement getBros() {
		return Utils.waitForElementPresence(driver, By.name("rescriptNumber"), 10);
	}

	public void setBros(String bros) {
		WebElement brosPolje = this.getBros();
		brosPolje.clear();
		brosPolje.sendKeys(bros);
	}
	
	// Vlasnička struktura
	public Select selectVs() {
		return  new Select (Utils.waitForElementPresence(driver, By.name("ownershipStructure"), 10));
	}
	public void setVs(String vs) {
		this.selectVs().selectByVisibleText(vs);
	}

	// buttons
	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='reset(Register)']"), 10);
	}
	
	public WebElement getSacuvajBtn() {
		return  Utils.waitForElementPresence(driver, By.name("btnSave"), 10);
	}
	
	// Unos cele forme
	public void setForm(String pib, String maticni, String bpna, String datum, String niIa, String nor, String vi, String odi, String osnivac, String datumO, String bros, String vs) {
		this.setPib(pib);
		this.setMaticni(maticni);
		this.setBpna(bpna);
		this.setDatum(datum);
		this.setNiIa(niIa);
		this.setNor(nor);
		this.setVi(vi);
		this.setOdi(odi);
		this.setOsnivac(osnivac);
		this.setDatumO(datumO);
		this.setBros(bros);
		this.setVs(vs);
		getSacuvajBtn().click();
	}

}
