package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ivanVojnovic.pages.Utils;

public class InstitucijaOsnovniPage {

	// Konstruktor
	private WebDriver driver;

	public InstitucijaOsnovniPage(WebDriver driver) {
		this.driver = driver;
	}

	// Hvata celu formu (služi nam za proveru da se forma pojavila)
	public WebElement getCelaForma() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@name='Basic']"), 15);
	}

	// Save button
	public WebElement getSaveBtn() {
		return Utils.waitForElementPresence(driver,
				By.xpath("//form[@name='Basic']//button//text()[contains(.,' Sačuvaj')]/.."), 15);
				//By.xpath("//form[@name='Basic']//button[@name='btnSave']"), 20);
	}

	// Cancel button
	public WebElement getCancelBtn() {
		return Utils.waitForElementPresence(driver,
				By.xpath("//form[@name='Basic']//button//text()[contains(.,' Odustani')]/.."), 15);
	}

	// Institucija geter i Seter
	public WebElement getNazivInstitucije() {
		return Utils.waitForElementPresence(driver, By.name("name"), 10);
	}

	public void setNazivInstitucije(String naziv) {
		WebElement nazivInst = this.getNazivInstitucije();
		nazivInst.clear();
		nazivInst.sendKeys(naziv);
	}

	// Institucija na Eng - getter i Setter
	public WebElement getNazivInstitucijeEng() {
		return Utils.waitForElementPresence(driver, By.name("eng_name"), 10);
	}

	public void setNazivInstitucijeEng(String naziv) {
		WebElement nazivInstEng = this.getNazivInstitucijeEng();
		nazivInstEng.clear();
		nazivInstEng.sendKeys(naziv);
	}

	// drzava getter i setter preko Selekta getera i setera (mora prvo da bude uneta, da je ima u listi)
	public Select getDrzava() {
		return new Select(Utils.waitForElementPresence(driver, By.name("state"), 10));
	}

	public void setDrzava(String drzava) {
		this.getDrzava().selectByVisibleText(drzava);
	}

	// Kad hoćemo da izaberemo nešto iz dropDown-a (što već postoji npr „Dodaj novu, ili Srbija")
	public void getNovaDrzavaAppear() {
		Select sveDrzave = this.getDrzava();
		sveDrzave.selectByVisibleText("Dodaj novu...");
	}

	// Ime nove države, njen opis i confirm button
	public WebElement getImeNoveDrzave() {
		return Utils.waitForElementPresence(driver, By.name("stateName"), 10);
	}

	public WebElement getOpisNoveDrzave() {
		return Utils.waitForElementPresence(driver, By.name("stateDescription"), 10);
	}

	public WebElement getConfirmButton() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class='col-sm-3 text-right']/button"), 10);
	}
	

	//Funkcija koja ubacuje novu državu
	public void unesiNovuDrzavu(String drzava, String opis) {
		WebElement novaDrzava = this.getImeNoveDrzave();
		novaDrzava.sendKeys(drzava);

		WebElement opisDrzave = this.getOpisNoveDrzave();
		opisDrzave.sendKeys(opis);

		this.getConfirmButton().click();
	}

	//Getter za potvrdu da je selektovana država stvarno selektovana
	public String getSelectedState() {
		return Utils.waitForElementPresence(driver, By.cssSelector("select[name=state] option:checked"), 10).getText();
	}

	// Mesto Getter i Setter
	public WebElement getMesto() {
		return Utils.waitForElementPresence(driver, By.name("place"), 10);
	}

	public void setMesto(String mesto) {
		WebElement nazivMesta = this.getMesto();
		nazivMesta.clear();
		nazivMesta.sendKeys(mesto);
	}

	// Opština Getter i Setter
	public WebElement getOpstina() {
		return Utils.waitForElementPresence(driver, By.name("townShipText"), 10);
	}

	public void setOpstina(String opstina) {
		WebElement nazivOpstine = this.getOpstina();
		nazivOpstine.clear();
		nazivOpstine.sendKeys(opstina);
	}

	// Adresa getter i Setter
	public WebElement getUlica() {
		return Utils.waitForElementPresence(driver, By.name("address"), 10);
	}

	public void setUlica(String ulica) {
		WebElement nazivUlica = this.getUlica();
		nazivUlica.clear();
		nazivUlica.sendKeys(ulica);
	}

	// Web Getter i Setter
	public WebElement getWeb() {
		return Utils.waitForElementPresence(driver, By.name("uri"), 10);
	}

	public void setWeb(String adresa) {
		WebElement nazivWeba = this.getWeb();
		nazivWeba.clear();
		nazivWeba.sendKeys(adresa);
	}
	
	// Mail
	public WebElement getMail() {
		return Utils.waitForElementPresence(driver, By.name("email"), 10);
	}

	public void setMail(String mail) {
		WebElement nazivMaila = this.getMail();
		nazivMaila.clear();
		nazivMaila.sendKeys(mail);
	}
	
	// Telefon
	public WebElement getTelefon() {
		return Utils.waitForElementPresence(driver, By.name("phone"), 10);
	}

	public void setTelefon(String tel) {
		WebElement nazivTel = this.getTelefon();
		nazivTel.clear();
		nazivTel.sendKeys(tel);
	}
	
	//Skraćeni naziv
	public WebElement getSkraceni() {
		return Utils.waitForElementPresence(driver, By.name("acro"), 10);
	}

	public void setSkraceni(String skr) {
		WebElement nazivSkr = this.getSkraceni();
		nazivSkr.clear();
		nazivSkr.sendKeys(skr);
	}

	// Unos cele forme
	public void setForm(String naziv, String nazivEng, String drzava, String mesto, String opstina, String ulica, String web, String mail, String tel, String skr) {
		this.setNazivInstitucije(naziv);
		this.setNazivInstitucijeEng(nazivEng);
		this.setDrzava(drzava);
		this.setMesto(mesto);
		this.setOpstina(opstina);
		this.setUlica(ulica);
		this.setWeb(web);
		this.setMail(mail);
		this.setTelefon(tel);
		this.setSkraceni(skr);
		getSaveBtn().click();
	}

	// Errorsi
	public WebElement getNazivError() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[text()='Morate uneti naziv.']"), 10);
	}
	
	//Slično je i za ostale Errorse, gde im se menja samo ispis teksta. Osim za državu!


}
