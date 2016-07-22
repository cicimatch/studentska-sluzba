package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ivanVojnovic.pages.Utils;

public class IstrazivaciCreationPage {

	private WebDriver driver;
	public IstrazivaciCreationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
		  
	//Ovde sam ostavio ova dugmad čisto da znam gde se nalaze
	public WebElement getLicniPodaci() {
		return Utils.waitForElementPresence(driver, By.xpath("//a/tab-heading[text()='Lični podaci']/.."), 10);
	}

	public WebElement getPodaciRegistar() {
		return Utils.waitForElementPresence(driver, By.xpath("//a/tab-heading[text()='Podaci za registar']/.."), 10);
	}

	public WebElement getPodaciProjekat() {
		return Utils.waitForElementPresence(driver, By.xpath("//a/tab-heading[text()='Podaci za projekte']/.."), 10);
	}
	
	public WebElement getIstrazivaci() {
		return Utils.waitForElementPresence(driver ,By.xpath("//a/tab-heading[text()='Istraživači']/.."), 10);
	}
	
	// ne znam da li je ovo potrebno
	public WebElement getAngazovanja() {
		return Utils.waitForElementPresence(driver, By.xpath("//a/tab-heading[text()='Angažovanja']/.."), 10);
	}

	
	// buttons
	public WebElement getSacuvajBtn() {
		return Utils.waitForElementPresence(driver, By.name("btnSave"), 10);
		//return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='addctrl.savePerson(Basic)']"), 10);	
	}
	
	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='reset()']"), 10);
	}

	// Forma za unos istraživača sa geterima i seterima

	// ime
	public WebElement getIme() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='firstNameText']"), 10);
	}

	public void setIme(String ime) {
		WebElement imePolje = this.getIme();
		imePolje.clear();
		imePolje.sendKeys(ime);
	}

	// prezime
	public WebElement getPrezime() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@name='personSearchLastNameT']/input"), 10);
	}

	public void setPrezime(String prezime) {
		WebElement prezimePolje = this.getPrezime();
		prezimePolje.clear();
		prezimePolje.sendKeys(prezime);
	}

	// ime jednog roditelja
	public WebElement getImeRoditelja() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='middleName']"), 10);
	}

	public void setImeRoditelja(String roditelj) {
		WebElement imePolje = this.getImeRoditelja();
		imePolje.clear();
		imePolje.sendKeys(roditelj);
	}

	// titula istraživača DROP-DOWN dugme, (selektuj)
	public WebElement getTitulaIstrazivaca() {
		return Utils.waitForElementPresence(driver, By.xpath("//select[@name='personTitle']"), 10);
	}

	public Select selectTitulaIstrazivaca() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//select[@name='personTitle']"), 10));
	}

	public void setTitulaIstrazivaca(String titula) {
		this.selectTitulaIstrazivaca().selectByVisibleText(titula);
	}

	// datum rođenja
	public WebElement getDatumRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@placeholder='dd.MM.yyyy']"), 10);
	}

	public void setDatumRodjenja(String datumRodj) {
		WebElement datumPolje = this.getDatumRodjenja();
		datumPolje.clear();
		datumPolje.sendKeys(datumRodj);
	}

	// drzava rođenja (običan getter i setter) samo treba kod setovanja pogoditi
	// format dd.MM.yyyy
	public WebElement getDrzavaRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='state']"), 10);
	}

	public void setDrzavaRodjenja(String drzavaRodj) {
		WebElement drzavaPolje = this.getDrzavaRodjenja();
		drzavaPolje.clear();
		drzavaPolje.sendKeys(drzavaRodj);
	}

	// mesto rođenja
	public WebElement getMestoRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='placeOfBirth']"), 10);
	}

	public void setMestoRodjenja(String mestoRodj) {
		WebElement mestoPolje = this.getMestoRodjenja();
		mestoPolje.clear();
		mestoPolje.sendKeys(mestoRodj);
	}

	// opština rođenja
	public WebElement getOpstinaRodjenja() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='townShipOfBirth']"), 10);
	}

	public void setOpstinaRodjenja(String opstinaRodj) {
		WebElement opstinaPolje = this.getOpstinaRodjenja();
		opstinaPolje.clear();
		opstinaPolje.sendKeys(opstinaRodj);
	}

	// država boravišta
	public WebElement getDrzavaBoravista() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='stateOfResidence']"), 10);
	}

	public void setDrzavaBoravista(String drzavaBor) {
		WebElement drzavaPolje = this.getDrzavaBoravista();
		drzavaPolje.clear();
		drzavaPolje.sendKeys(drzavaBor);
	}

	// mesto boravišta
	public WebElement getMestoBoravista() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='city']"), 10);
	}

	public void setMestoBoravista(String mestoBor) {
		WebElement mestoPolje = this.getMestoBoravista();
		mestoPolje.clear();
		mestoPolje.sendKeys(mestoBor);
	}

	// opština boravišta
	public WebElement getOpstinaBoravista() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='townShipOfResidence']"), 10);
	}

	public void setOpstinaBoravista(String opstinaBor) {
		WebElement opstinaPolje = this.getOpstinaBoravista();
		opstinaPolje.clear();
		opstinaPolje.sendKeys(opstinaBor);
	}

	// ulica i broj boravišta
	public WebElement getUlicaIBroj() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='address']"), 10);
	}

	public void setUlicaIBroj(String ulicaBor) {
		WebElement ulicaPolje = this.getUlicaIBroj();
		ulicaPolje.clear();
		ulicaPolje.sendKeys(ulicaBor);
	}

	// pol. Dugme DROP-DOWN, (treba selektovati)
	public WebElement getPol() {
		return Utils.waitForElementPresence(driver, By.xpath("//select[@name='gender']"), 10);
	}

	public Select selectPol() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//select[@name='gender']"), 10));
	}

	public void setPol(String pol) {
		this.selectPol().selectByVisibleText(pol);
	}

	// JMBG
	public WebElement getJmbg() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='jmbg']"), 10);
	}

	public void setJmbg(String jmbg) {
		WebElement jmbgPolje = this.getJmbg();
		jmbgPolje.clear();
		jmbgPolje.sendKeys(jmbg);
	}

	// email
	public WebElement getEmail() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='email']"), 10);
	}

	public void setEmail(String email) {
		WebElement emailPolje = this.getEmail();
		emailPolje.clear();
		emailPolje.sendKeys(email);
	}

	// telefon
	public WebElement getTelefon() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='phones']"), 10);
	}

	public void setTelefon(String telefon) {
		WebElement telefonPolje = this.getTelefon();
		telefonPolje.clear();
		telefonPolje.sendKeys(telefon);
	}

	// WEB
	public WebElement getWeb() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='uri']"), 10);
	}

	public void setWeb(String web) {
		WebElement webPolje = this.getWeb();
		webPolje.clear();
		webPolje.sendKeys(web);
	}

	// status istraživača DROP-DOWN dugme
	public WebElement getStatusIstrazivaca() {
		return Utils.waitForElementPresence(driver, By.xpath("//select[@name='personStatus']"), 10);
	}

	public Select selectStatusIstrazivaca() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//select[@name='personStatus']"), 10));
	}

	public void setStatusIstrazivaca(String status) {
		this.selectStatusIstrazivaca().selectByVisibleText(status);
	}

	//funkcija za unos cele forme
	public void unosCeleForme(String ime, String prezime, String roditelj, String titula, String datumRodj,
			String drzavaRodj, String mestoRodj, String opstinaRodj, String drzavaBor, String mestoBor,
			String opstinaBor, String ulicaBor, String pol, String jmbg, String email, String telefon, String web,
			String status) {
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setImeRoditelja(roditelj);
		this.setTitulaIstrazivaca(titula);
		this.setDatumRodjenja(datumRodj);
		this.setDrzavaRodjenja(drzavaRodj);
		this.setMestoRodjenja(mestoRodj);
		this.setOpstinaRodjenja(opstinaRodj);
		this.setDrzavaBoravista(drzavaBor);
		this.setMestoBoravista(mestoBor);
		this.setOpstinaBoravista(opstinaBor);
		this.setUlicaIBroj(ulicaBor);
		this.setPol(pol);
		this.setJmbg(jmbg);
		this.setEmail(email);
		this.setTelefon(telefon);
		this.setWeb(web);
		this.setStatusIstrazivaca(status);
		this.getSacuvajBtn().click();
		
	}

	// ovde sam stavio ispise o greškama
	public WebElement getImeError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Ime *\"]//span"), 10);
	}

	public WebElement getPrezimeError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Prezime *\"]//span"), 10);
	}

	public WebElement getJmbgError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"JMBG / Broj pasoša *\"]//span[1]"), 10);
	}

	public WebElement getJmbgFormatError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"JMBG / Broj pasoša *\"]//span[2]"), 10);
	}

}
