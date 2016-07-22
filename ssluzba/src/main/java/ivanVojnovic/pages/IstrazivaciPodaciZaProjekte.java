package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ivanVojnovic.pages.Utils;

public class IstrazivaciPodaciZaProjekte {

	private WebDriver driver;

	public IstrazivaciPodaciZaProjekte(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Cela forma
	public WebElement getCelaForma() {
		return Utils.waitForElementPresence(driver,By.xpath("//form[@name='Project']"),20);
	}
	
	//Tip osobe
	public WebElement getTipOsobe() {
		return Utils.waitForElementPresence(driver, By.name("personType"), 10);
	}

	public Select selectTipOsobe() {
		return new Select(Utils.waitForElementPresence(driver, By.name("personType"), 10));
	}

	public void setTipOsobe(String tip) {
		this.selectTipOsobe().selectByVisibleText(tip);
	}
	
	//Obračunsko zvanje
	public WebElement getObracunskoZvanje() {
		return Utils.waitForElementPresence(driver, By.name("personPosition"), 10);
	}

	public Select selectObracunskoZvanje() {
		return new Select(Utils.waitForElementPresence(driver, By.name("personPosition"), 10));
	}

	public void setObracunskoZvanje(String zvanje) {
		this.selectObracunskoZvanje().selectByVisibleText(zvanje);
	}
	
	//Kategorije istraživača
	public WebElement getKategorijaIstrazivaca() {
		return Utils.waitForElementPresence(driver, By.id("s2id_autogen96"), 10);
		//return Utils.waitForElementPresence(driver, By.xpath("//div[@title='Kategorije istraživača']"), 10);
	}

	public Select selectKategorijaIstrazivaca() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//div[@title='Kategorije istraživača']"), 10));
	}

	public void setKategorijaIstrazivaca(String kategorija) {
		this.selectKategorijaIstrazivaca().selectByVisibleText(kategorija);
	}
	
	//Buttons
	public WebElement getSacuvajBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='addctrl.savePerson(Project)']"), 10);
		//return Utils.waitForElementPresence(driver, By.name("btnSave"), 10);
	}
		
	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button [@ng-click='reset()']"), 10);
	}
	
	//Ovde je ispis o errors-u
	public WebElement getTipOsobeError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Tip osobe *\"]//span"), 10);
	}
	

}
