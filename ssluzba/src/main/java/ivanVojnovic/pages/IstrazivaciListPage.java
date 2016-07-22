package ivanVojnovic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ivanVojnovic.pages.Utils;

public class IstrazivaciListPage {
	private WebDriver driver;

	public IstrazivaciListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//	dugme za dodavanje istraživača
	public WebElement getDodajIstrazivacaBtn() {
		return Utils.waitForElementPresence(driver,By.xpath("//a[@ui-sref='addPerson']"),10);
	}
	
	// koristimo za pretragu (upisujemo početno slovo, a on izbaci ime ili nešto)
	public WebElement getPretrazivac() {
		return Utils.waitForElementPresence(driver,By.xpath("//input [@placeholder='Pretraži istraživače']"),10);
	}

	//	Tabela istraživača 
	public WebElement getIstrazivaciTable() {
		return Utils.waitForElementPresence(driver,By.xpath("//*[@id='page-content']//table"),10);
	}
	//Pokupi sve <tr> tagove    ..ako hoćemo prvi red - get(0).click();
	public List<WebElement> getTableRows() {
		return this.getIstrazivaciTable().findElements(By.tagName("tr"));
	}
	
	//Nalazi istraživača u tabeli po prezimenu (vraća true ili false kad mu se prosledi prezime)
	public boolean isIstrazivacInTable(String prezime) {
		return Utils.isPresent(driver, By.xpath("//*[contains(text(),\"" + prezime + "\")]/.."));
	}
	
	//nalazi red u tabeli na (red u kojem se nalazi prosleđeno prezime)
	public WebElement getIstrazivacRowByPrezime(String prezime) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + prezime + "\")]/.."), 10);
	}
	
	//na osnovu prosleđenog prezimena klikne na istraživača (vodi na stranu za editovanje)
	public void editIstrazivacByPrezime(String prezime) {
		this.getIstrazivacRowByPrezime(prezime).findElements(By.tagName("td")).get(0).click();
	}
	

	public void deleteIstrazivacByName(String prezime) {
		getIstrazivacRowByPrezime(prezime).findElement((By.xpath("//button [@ng-click='addctrl.deleteConnection(connection.id)']")));
	}
	
	//checkbox 2 dugmeta
	public WebElement getMigriraniPodaci() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='migrated']"), 10);
	}
	
	public WebElement getVerifikovaniMigriraniPodaci() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='changed']"), 10);
	}
	
	//sortiranje po imenu, prezimenu i datumu
	public WebElement getSortByIme() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains(text(),'Ime')]"), 10);
	}
	
	public WebElement getSortByPrezime() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains(text(),'Prezime')]"), 10);
	}
	
	public WebElement getSortByDatum() {
		return Utils.waitForElementPresence(driver, By.xpath("//span[contains(text(),'Datum')]"), 10);
	}
	
	//dugmići u dnu stranice
	public WebElement getPrviBtn() {
		return Utils.waitForElementPresence(driver, By.linkText("Prvi"), 10);
	}
	
	public WebElement getPrethodniBtn() {
		return Utils.waitForElementPresence(driver, By.linkText("Prethodni"), 10);
	}
	
	public WebElement getTrenutniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//a[@ng-click='selectPage(page.number, $event)']"), 10);
	}
	
	public WebElement getSledeciBtn() {
		return Utils.waitForElementPresence(driver, By.linkText("Sledeći"), 10);
	}
	
	public WebElement getPoslednjiBtn() {
		return Utils.waitForElementPresence(driver, By.linkText("Poslednji"), 10);
	}
	
}
