package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ivanVojnovic.pages.Utils;

public class IstrazivaciPodaciZaRegistarPage {

	private WebDriver driver;

	public IstrazivaciPodaciZaRegistarPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Cela forma
	public WebElement getCelaForma() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@name='Register']"),20);
	}
	
	//Bibliografija
	public WebElement getBibliografija() {
		return Utils.waitForElementPresence(driver, By.name("bibliography"), 10);
	}
	
	public void setBibliografija(String bibiliografija) {
		WebElement bibiliografijaPolje = this.getBibliografija();
		bibiliografijaPolje.clear();
		bibiliografijaPolje.sendKeys(bibiliografija);
	}
	
	//Oblast istrazivanja
	public WebElement getOblastIstrazivanja() {
		return Utils.waitForElementPresence(driver, By.name("researchAreas"), 10);
	}
	
	public void setOblastIstrazivanja(String oblast) {
		WebElement oblastPolje = this.getOblastIstrazivanja();
		oblastPolje.clear();
		oblastPolje.sendKeys(oblast);
	}
	
	
	//Identifikacioni broj u ministarstvu
	public WebElement getIdMinistarstvo() {
		return Utils.waitForElementPresence(driver, By.name("mntrn"), 10);
	}
	
	public void setIdMinistarstvo(String id) {
		WebElement idPolje = this.getIdMinistarstvo();
		idPolje.clear();
		idPolje.sendKeys(id);
	}
	
	//Napomena
	public WebElement getNapomena() {
		return Utils.waitForElementPresence(driver, By.name("note"), 10);
	}
	
	public void setNapomena(String napomena) {
		WebElement napomenaPolje = this.getNapomena();
		napomenaPolje.clear();
		napomenaPolje.sendKeys(napomena);
	}
	
	//Buttons
	public WebElement getSacuvajBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='addctrl.savePerson(Register)']"), 10);
	}
		
	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='reset()']"), 10);
	}
	
	// Ovde su errors ispisi
	public WebElement getBibiliografijaError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Bibliografija *\"]//span"), 10);
	}
	
	public WebElement getOblastIstrazivanjaError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Oblasti istraživanja *\"]//span"), 10);
	}
	
	public WebElement getIdMinistarstvoError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Identifikacioni broj u ministarstvu *\"]//span"), 10);
	}
	

}
