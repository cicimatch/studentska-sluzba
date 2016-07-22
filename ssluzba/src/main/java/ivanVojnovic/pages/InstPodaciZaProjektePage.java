package ivanVojnovic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ivanVojnovic.pages.Utils;

public class InstPodaciZaProjektePage {

	private WebDriver driver;

	public InstPodaciZaProjektePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getCelaForma() {
		return Utils.waitForElementPresence(driver, By.xpath("//form[@name='Project']"), 20);
	}
	
	//Račun
	public WebElement getRacun() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='account']"), 10);
	}
	
	public void setRacun(String racun){
		WebElement racunPolje = this.getRacun();
		racunPolje.clear();
		racunPolje.sendKeys(racun);
	}
	
	public String getRacunLabelText() {
		return Utils.waitForElementPresence(driver, By.xpath("//label[contains(text(),'Broj računa')]"), 10).getText();
	}
	
	//ID u ministarstvu
	public WebElement getIdMinistarstvo() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='mntrID']"), 10);
	}
	
	public void setIdMinistarstvo(String id){
		WebElement idPolje = this.getIdMinistarstvo();
		idPolje.clear();
		idPolje.sendKeys(id);
	}
	
	//ID medjunarodni nivo
	public WebElement getIdMedjunarodniNivo() {
		return Utils.waitForElementPresence(driver, By.xpath("//input[@name='orcid']"), 10);
	}
	
	public void setIdMedjunarodniNivo(String idM){
		WebElement idMPolje = this.getIdMedjunarodniNivo();
		idMPolje.clear();
		idMPolje.sendKeys(idM);
	}
	
	//Status institucije
	public WebElement getStatusInstitucije() {
		return Utils.waitForElementPresence(driver, By.xpath("//select[@name='institutionStatus']"), 10);
	}
	
	public Select selectStatusInstitucije() {
		return new Select(Utils.waitForElementPresence(driver, By.xpath("//select[@name='institutionStatus']"), 10));
	}

	public void setStatusInstitucije(String status) {
		this.selectStatusInstitucije().selectByVisibleText(status);
	}
	
	//Oblast istraživanja
	public WebElement getOblastIstrazivanja() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title='Oblast istraživanja']/div/div/div/ul/li"), 10);
	}
	/*public WebElement getOblastIstrazivanja() {
		return Utils.waitForElementPresence(driver, By.id("s2id_autogen94"), 10);
	}*/
	
	public void setOblastIstrazivanja(String oblast){
		WebElement oblastPolje = this.getOblastIstrazivanja();
		oblastPolje.clear();
		oblastPolje.sendKeys(oblast);
	}
	
	//Ovde su errorsi
	public WebElement getRacunError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Broj računa *\"]//span[1]"), 10);
	}
	
	public WebElement getRacunFormatError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Broj računa *\"]//span[2]"), 10);
	}
	
	public WebElement getStatusInstitucijeError() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@title=\"Status institucije *\"]//span"), 10);
	}
	
	//Buttons
	public WebElement getSacuvajBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='addctrl.saveInstitution(Project)']"), 10);
	}
	
	public WebElement getOdustaniBtn() {
		return Utils.waitForElementPresence(driver, By.xpath("//button[@ng-click='reset(Project)']"), 10);
	}


}
